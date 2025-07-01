package com.sinse.web0618.member.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sinse.web0618.exception.MemberException;
import com.sinse.web0618.member.model.Member;

public class MemberDAO {
	String Driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/shop";
	String user = "shop";
	String pwd = "12341234";
	
	
	public void insert(Member member) throws MemberException{
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		
		try {
			Class.forName(Driver);
			con = DriverManager.getConnection(url,user,pwd);
			
			sql.append("insert into member(id,pwd,emial) values(?,?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getEmial());
			
			int result = pstmt.executeUpdate();
			
			if(result  ==0 ) {
				throw new MemberException("회원가입 실패~~");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new MemberException("회원가입 실패!!!",e);
		}
		
		finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
