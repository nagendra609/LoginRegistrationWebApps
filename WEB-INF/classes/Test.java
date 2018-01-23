

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		/*try{
		
		if(conn!=null){
			System.out.println("Connected");
			String sql="insert into adjetter_users(name,email,password,contact_no) values(?,?,?,?)";
			PreparedStatement prep=conn.prepareStatement(sql); 
			prep.setString(1, "nagendra");
			prep.setString(2, "nagendra2@gmail.com");
			prep.setString(3, "nagendra");
			prep.setInt(4, 987677676);		
			prep.executeUpdate();
		}else System.out.println("Not cconnected");
		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}*/
		/*Connection conn=new Test().getConnection();
		if(conn!=null)
			System.out.println("Connected");
		else
			System.out.println("Not Connected");*/
	}

	public void passRecords(UserDto dto) throws ClassNotFoundException, SQLException{
		
		Connection conn=new Test().getConnection();
		if(conn!=null)
			System.out.println("Connected");
		else
			System.out.println("Not Connected");
		System.out.println("Name : "+dto.getName()+" : Email : "+dto.getEmail());
		
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Get Connection 2");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","root");
		if(conn!=null)
			System.out.println("Connected");
		else
			System.out.println("Not Connected");
		return conn;
	}
}
