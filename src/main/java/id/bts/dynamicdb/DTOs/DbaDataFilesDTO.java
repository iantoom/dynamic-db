package id.bts.dynamicdb.DTOs;

public class DbaDataFilesDTO {

	String dbName;
	
	String tablespace_name;
	
	int totalSpace;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getTablespace_name() {
		return tablespace_name;
	}

	public void setTablespace_name(String tablespace_name) {
		this.tablespace_name = tablespace_name;
	}

	public int getTotalSpace() {
		return totalSpace;
	}

	public void setTotalSpace(int totalSpace) {
		this.totalSpace = totalSpace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tablespace_name == null) ? 0 : tablespace_name.hashCode());
		result = prime * result + totalSpace;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DbaDataFilesDTO other = (DbaDataFilesDTO) obj;
		if (tablespace_name == null) {
			if (other.tablespace_name != null)
				return false;
		} else if (!tablespace_name.equals(other.tablespace_name))
			return false;
		if (totalSpace != other.totalSpace)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DbaDataFilesDTO [tablespace_name=" + tablespace_name + ", totalSpace=" + totalSpace + "]";
	}
}
