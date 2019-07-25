package id.bts.dynamicdb.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import id.bts.dynamicdb.config.DataSourceList;
import id.bts.dynamicdb.repos.TableSpaceRepo;

@Component
public class Init implements CommandLineRunner {

	@Autowired
	@Qualifier("dataSourceList")
	public DataSourceList lists;
	
	@Autowired
	@Qualifier("tableSpaceRepo")
	public TableSpaceRepo tableSpaceRepo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Loaded Properties: " + lists.getLists());
		System.out.println("Loaded DataSources: " + lists.getDataSources());
		System.out.println("Query Operations: " + tableSpaceRepo.getTotalSpace());
		
	}

}
