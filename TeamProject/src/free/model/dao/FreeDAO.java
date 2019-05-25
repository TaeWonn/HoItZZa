package free.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FreeDAO {
	
	private Properties prop = new Properties();
	
	public FreeDAO() {
		String filePath = getClass().getResource("/free/free-query.properteis").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
