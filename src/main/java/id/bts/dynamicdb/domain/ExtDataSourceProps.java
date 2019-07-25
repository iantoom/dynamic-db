package id.bts.dynamicdb.domain;

public class ExtDataSourceProps {

	private String url;
	private String username;
	private String password;
	private String driverClass;
	
	public ExtDataSourceProps() {
		super();
	}

	public ExtDataSourceProps(String url, String username, String password, String className) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.driverClass = className;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverClass == null) ? 0 : driverClass.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		ExtDataSourceProps other = (ExtDataSourceProps) obj;
		if (driverClass == null) {
			if (other.driverClass != null)
				return false;
		} else if (!driverClass.equals(other.driverClass))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DataSourceEntity [url=" + url + ", username=" + username + ", password=" + password + ", className="
				+ driverClass + "]";
	}
	
	
}
