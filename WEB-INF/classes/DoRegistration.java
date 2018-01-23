

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class DoRegistration
 */
@WebServlet("/DoRegistration")
public class DoRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		doGet(request, response);
		String uName=request.getParameter("name");
		String uEmail=request.getParameter("email");
		String contactNo=request.getParameter("phone");
		String pass=request.getParameter("password");
		Connection conn=null;
		PreparedStatement prepst=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","root");

		if(conn!=null){
			
			HttpSession session=request.getSession();
			
			String sql="insert into adjetterUsers(user_name,user_email,password,contact_no) values(?,?,?,?)";
			prepst=(PreparedStatement) conn.prepareStatement(sql);
			prepst.setString(1, uName);
			prepst.setString(2, uEmail);
			prepst.setString(3,pass);
			prepst.setString(4, contactNo);
			if(prepst.executeUpdate()==1){
			response.sendRedirect("RegisteredAck.jsp");
			}
		}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		    if (prepst != null) {
		        try {
		        	prepst.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }		
	    }		
	}

}
