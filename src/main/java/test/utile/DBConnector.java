package test.utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC ����̹��� ���Ͽ� DB������ �����Ѵ�.
 * Singleton ����
 * Singleton : Ŭ������ �� �ϳ��� ��ü���� ���� ���� ����
 */
public class DBConnector {
	
	private static String driver = "";
	private static String url = "";
	private static String id = "";
	private static String pwd = "";
	
	private static Connection conn;
	
	public static Connection getDBConnector() {
		try {
			if(conn == null) {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, id, pwd);
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
