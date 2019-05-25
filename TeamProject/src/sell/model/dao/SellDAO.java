package sell.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SellDAO {
	
	private Properties prop = new Properties();
	
	public SellDAO() {
		String filePath = getClass().getResource("/sell/sell-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
