

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String sessionUserName=request.getSession().getAttribute("userName").toString();
		String newPass=request.getParameter("newpass");
		String oldPass=request.getParameter("oldpass");
		PrintWriter out=response.getWriter();
		Connection conn=null;
		PreparedStatement prepSt=null;
		if(oldPass.equals(newPass)){
			response.sendRedirect("changePassAck.jsp");
		}else{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","root");
			if(conn!=null){				
				String sql="update adjetterUsers set password= ? where user_email= ?";			
				prepSt=(PreparedStatement) conn.prepareStatement(sql);
				prepSt.setString(1, newPass);
				prepSt.setString(2, sessionUserName);
				if(prepSt.executeUpdate()>0){
					response.sendRedirect("changePassAck.jsp");
				}else{
					out.println("  Error during change password");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		    if (prepSt != null) {
		        try {
		        	prepSt.close();
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
}

