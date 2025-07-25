package newmvcproject.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class PoolManager {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/spring4";
	private String user = "spring4";
	private String pass = "12341234";

	// 비록 생성자는 막았지만 내가 지원해주는 메서드로 인스턴스를 가져가라
	private static PoolManager instance;


	// Connection 들을 모아서 관리할 벡터(순서가 있는 List)
	Vector<Connection> connectionPool = new Vector<>();

	private PoolManager() {
		
	}

	public static PoolManager getInstance() {
		if (instance == null) {
			instance = new PoolManager();
		}
		return instance;
	}

	// connection 담아두기
	public void createConnection() {
		for (int i = 0; i < 20; i++) {
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, user, pass);
				
				//vector에 모아놓기
				connectionPool.add(con);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//빌려주기 -> get 
	public synchronized Connection getConnection() {
		//빌려줄 것이 없으면 또 만든다.
		if(connectionPool.isEmpty()) {
			createConnection();
		}
		return connectionPool.remove(0);
	}
	
	//반납하기
	public void release(Connection con,PreparedStatement pstmt,ResultSet rs) {
		if (con != null) {
			connectionPool.add(con); //다시 벡터에 추가하
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void release(Connection con) {
		if (con != null) {
			connectionPool.add(con); //다시 벡터에 추가하
		}
		
	}
	public void release(Connection con,PreparedStatement pstmt) {
		if (con != null) {
			connectionPool.add(con); //다시 벡터에 추가하
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
