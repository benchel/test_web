package test.utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC 드라이버를 통하여 DB연결을 수행한다.
 * Singleton 적용
 * Singleton : 클래스가 단 하나의 객체만을 갖는 설계 패턴
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
			
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
