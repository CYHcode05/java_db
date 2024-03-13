package project1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// mysql과 자바 연동
public class StudentDAO {
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_URL ="jdbc:mysql://localhost:3306/student_db?characterEncoding=UTF-8&serverTimezone=UTC";


     
	private final String USER_NAME = "root";
	private final String PASSWORD =  "root";
	
	Connection conn = null;
	PreparedStatement state = null;
    ResultSet rs = null;
    
	private void getConnection(){
		
	try {
		Class.forName(JDBC_DRIVER);
	    conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);   
	}
	catch(Exception e){
		System.out.println("데이터 베이스 연결 오류 :" + e.getMessage());
	}
	}
	
	//학생 등록 프로그램
	public boolean insertStudent(StudentInfor infor) {
		
		boolean result = false;
		
		try {
			getConnection();
			
			String sql = "INSERT INTO student_db(" + "s_code,s_name,s_depart,s_num,s_jumsu)"+"values(?,?,?,?,?)";
			state = conn.prepareStatement(sql);
			
			state.setString(1,infor.getCode());
			state.setString(2,infor.getName());
			state.setString(3, infor.getDepart());
			state.setString(4,infor.getNum());
			state.setString(5, infor.getJumsu());
			
			int r = state.executeUpdate();
			
			if(r>0) { 
				result = true;
			}
		}
			catch(Exception e)
			{
				System.out.println("예외발생1" +e.getMessage());
			}finally {
				dbClose();
			}
			return result;
		}
// 저장된 학번에 해당하는 학생 정보 찾기
	public StudentInfor getStudent(String in)
	{
		StudentInfor dto = null;
		try {
			getConnection();
			
			String sql = "SELECT s_code, s_name,s_depart,s_num,s_jumsu 	FROM student_db WHERE s_code = ?";
			state = conn.prepareStatement(sql);
			state.setString(1, in);
			rs = state.executeQuery();
			
			if(rs.next()) {
				String s_code = rs.getString("s_code").toString();
				String s_name = rs.getString("s_name");
				String s_depart = rs.getString("s_depart");
				String s_num = rs.getString("s_num");
				String s_jumsu = rs.getString("s_jumsu");
				dto = new StudentInfor(s_code, s_name,s_depart,s_num, s_jumsu);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			dbClose();
		}
		return dto;
	}
//저장된 학생 정보 보기
	public List<StudentInfor> getStundetList(){
	  List<StudentInfor> list = new ArrayList<StudentInfor>();
	  
	  try
	  {
		  getConnection();
		  
		  String sql = "SELECT s_code,s_name,s_depart,s_num,s_jumsu FROM student_db";
		  
		  state = conn.prepareStatement(sql);
		  rs = state.executeQuery();
		  
		  while(rs.next())
		  {
			  String s_code = rs.getString("s_code");
			  String s_name = rs.getString("s_name");
			  String s_depart = rs.getString("s_depart");
			  String s_num = rs.getString("s_num");
			  String s_jumsu = rs.getString("s_jumsu");
			  list.add(new StudentInfor(s_code,s_name,s_depart,s_num,s_jumsu));
		  }

	  }catch(Exception e)
		{
			System.out.println(e);
		}finally {
			dbClose();
		}
	return list;
	}
	 
	
	
//학생 정보 변경	
	public boolean updateStudent(StudentInfor infor)
	{
		boolean result = false;
		
		try {
			getConnection();
			
			String sql = new String();
			
			sql = "update student_db set s_name=? , s_depart =?, s_num=?, s_jumsu=? where s_code =?";
			
			state = conn.prepareStatement(sql);
			
			state.setString(1, infor.getName());
			state.setString(2, infor.getDepart());
			state.setString(3,infor.getNum());
			state.setString(4, infor.getJumsu());
			state.setString(5, infor.getCode());
			
			int r = state.executeUpdate();
			
			if(r>0) { 
				result = true;
			}
			
			}
			catch(Exception e)
			{
				System.out.println(e);
			}finally {
				dbClose();
			}
		return result;
		}
// 학생 정보 삭제	
    public boolean deleteStudent(String id)
    {
    	boolean result = false;
    	try {
    		getConnection();
    		
    		String sql = "DELETE FROM student_db WHERE s_code =?";
    		PreparedStatement state = conn.prepareStatement(sql);
    		
    		state.setString(1,id);
    		int r = state.executeUpdate();
    		
    		if(r>0) { 
				result = true;
			}
			
			}catch(Exception e)
			{
				System.out.println(e);
			}finally {
				dbClose();
			}
		return result;
    	}
    
	private void dbClose() {
		
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
            System.out.println(e);
			}
		}
		
		if (state != null)
		{
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
            System.out.println(e);
			}
		}
		
		if (conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
            System.out.println(e);
			}
		}
		conn = null;
	}
}
