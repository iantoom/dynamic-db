package id.bts.dynamicdb.repos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import id.bts.dynamicdb.DTOs.DbaDataFilesDTO;
import id.bts.dynamicdb.config.DataSourceList;
import id.bts.dynamicdb.mapper.DbaDataFilesMapper;

@Repository("tableSpaceRepo")
public class TableSpaceRepo {

	private static final Logger log = LoggerFactory.getLogger(TableSpaceRepo.class);

	@Autowired
	@Qualifier("dataSourceList")
	private DataSourceList dataSourceList;

	public List<DbaDataFilesDTO> getTotalSpace() {
		String query = "SELECT tablespace_name,\n" + "    ROUND(SUM(bytes) / 1048576) TotalSpace\n"
				+ "  FROM dba_data_files\n" + "  GROUP BY tablespace_name";

		log.warn(query);
		log.warn(dataSourceList.getLists().toString());

		List<DbaDataFilesDTO> results = new ArrayList<>();

		for (Iterator<DataSource> iterator = dataSourceList.getDataSources().iterator(); iterator.hasNext();) {
			DataSource dataSource = (DataSource) iterator.next();

			log.warn(dataSource.toString());

			try {
				if (dataSource.getConnection().isValid(5)) {
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					List<DbaDataFilesDTO> result = jdbcTemplate.query(query, new DbaDataFilesMapper());

					for (Iterator<DbaDataFilesDTO> iterator2 = result.iterator(); iterator2.hasNext();) {
						DbaDataFilesDTO dbaDataFilesDTO = (DbaDataFilesDTO) iterator2.next();

						try {
							dbaDataFilesDTO.setDbName(dataSource.getConnection().toString());
						} catch (SQLException e) {
							e.printStackTrace();
						}
						results.add(dbaDataFilesDTO);
					}
				}
			} catch (DataAccessException | SQLException e) {
				
				e.printStackTrace();
			}
		}

		return results;
	}
}
