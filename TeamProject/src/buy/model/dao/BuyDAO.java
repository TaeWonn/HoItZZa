package buy.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BuyDAO {
	
	private Properties prop = new Properties();
	
	public BuyDAO() {
		String filePath = getClass().getResource("/buy/buy-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
