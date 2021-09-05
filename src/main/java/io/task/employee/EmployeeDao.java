package io.task.employee;
//Repository

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	Connection conn=null;
	public EmployeeDao(){
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","123456");
			}
			catch(Exception e) {
            System.out.println(e.getMessage());				
			}
		}
	}
	public void save(Employee e ) {
		String sql="insert into employee values (?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setInt(2, e.getNumber());
			ps.executeUpdate();
		}
		catch(Exception S) {
			System.out.println(S.getMessage());
		}
		
	}
	public void delete(String name) {
		String sql="delete from employee where name=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
ps.setString(1, name);
			ps.executeUpdate();
		}
		catch(Exception S) {
			System.out.println(S.getMessage());
		}
		
	}
	public void update(Employee e) {
		String sql="update employee set number=? where name=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(2, e.getName());
			ps.setInt(1,e.getNumber());
			ps.executeUpdate();
		}
		catch(Exception S) {
			System.out.println(S.getMessage());
		}
	
		
	}
	public List<Employee> getAllEmployee(){
		List<Employee> list=new ArrayList<>();
		String sql="select * from employee";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setName(rs.getString(1));
				e.setNumber(rs.getInt(2));
				list.add(e);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}
	

}
