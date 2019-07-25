package id.bts.dynamicdb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import id.bts.dynamicdb.DTOs.DbaDataFilesDTO;
import id.bts.dynamicdb.repos.TableSpaceRepo;

@RestController
public class TableSpaceController {

	@Autowired
	@Qualifier("tableSpaceRepo")
	private TableSpaceRepo tableSpaceRepo;
	
	@GetMapping(path = "/")
	public List<DbaDataFilesDTO> getTotalSpace() {
		return tableSpaceRepo.getTotalSpace();
	}
}
