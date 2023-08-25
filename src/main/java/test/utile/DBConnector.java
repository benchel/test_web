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
	
	private static String driver = "org.mariadb.jdbc.Driver";
	private static String url = "jdbc:mariadb://localhost:3306/sample_db";
	private static String id = "gasipan";
	private static String pwd = "gasipan";
	
	private static Connection conn;
	
	public static Connection getDBConnector() {
		try {
			if(conn == null) {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, id, pwd);
			}
			
			System.out.println("DB ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
