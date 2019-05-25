package admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import common.JDBCTemplate.*;

public class AdminDAO {
	
	private Properties prop = new Properties();
	
	public AdminDAO() {
		String filePath = getClass().getResource("/sql/admin/admin-query/properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
