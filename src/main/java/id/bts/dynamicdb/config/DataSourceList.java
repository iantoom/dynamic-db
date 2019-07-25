package id.bts.dynamicdb.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import id.bts.dynamicdb.domain.ExtDataSourceProps;

@Component(value = "dataSourceList")
@ConfigurationProperties(prefix = "ocdb12c")
public class DataSourceList {

	private List<ExtDataSourceProps> lists;

	public DataSourceList() {
		super();
	}

	public DataSourceList(List<ExtDataSourceProps> lists) {
		super();
		this.lists = lists;
	}

	public List<ExtDataSourceProps> getLists() {
		return lists;
	}

	public void setLists(List<ExtDataSourceProps> lists) {
		this.lists = lists;
	}

	public List<DataSource> getDataSources() {

		List<DataSource> dataSources = new ArrayList<>();
		for (Iterator<ExtDataSourceProps> iterator = lists.iterator(); iterator.hasNext();) {
			ExtDataSourceProps extDataSourceProps = (ExtDataSourceProps) iterator.next();

			DataSourceProperties dataSourceProperties = new DataSourceProperties();
			dataSourceProperties.setContinueOnError(true);
			dataSourceProperties.setUrl(extDataSourceProps.getUrl());
			dataSourceProperties.setUsername(extDataSourceProps.getUsername());
			dataSourceProperties.setPassword(extDataSourceProps.getPassword());
			dataSourceProperties.setDriverClassName(extDataSourceProps.getDriverClass());
			
			DataSource dataSource = dataSourceProperties.initializeDataSourceBuilder().build();
			
			dataSources.add(dataSource);
		}
		
		return dataSources;
	}

}
