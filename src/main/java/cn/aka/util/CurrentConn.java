package cn.aka.util;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.InputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.sql.*;
import java.util.Properties;

/**
 * @author 赵鹏,zhaopeng
 */
public class CurrentConn {

	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	private static CurrentConn CONN = null;  //CurrentConn类单例对象

	private CurrentConn(){}

	//静态工厂方法 ,保证只有该类只有一个实例,节省内存
	public synchronized static CurrentConn getInstance() {
		if (CONN == null) {  
			CONN = new CurrentConn();
		}  
		return CONN;
	}

	static{  //静态块,读取参数配置,只加载一次
		Properties prop = new Properties();
		try {
			InputStream is = CurrentConn.class.getResourceAsStream("/db.properties");
			prop.load(is);

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");

			is.close();
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private static Key key;
	private static String KEY_STR = "ffms";
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public static Connection getConn(){
		try{
			Connection conn= DriverManager.getConnection(url, username, password);
			return conn;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		

	}

	public static void closeConnection(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void closePreparedStatement(PreparedStatement ps) {

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void closeResultSet(ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	public static String getDecryptString(String str) {
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			byte[] strBytes = base64De.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
