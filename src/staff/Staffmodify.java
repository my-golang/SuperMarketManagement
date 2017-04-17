package staff;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.DbUtil;
/**
 * Servlet implementation class Staffmodify
 */
@WebServlet("/Staffmodify")
public class Staffmodify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Staffmodify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			String id = (String) request.getSession().getAttribute("id");
			String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		    String phone=new String(request.getParameter("phone").getBytes("iso-8859-1"), "utf-8");
			String email=new String(request.getParameter("email").getBytes("iso-8859-1"), "utf-8");
			String socialID=new String(request.getParameter("socialID").getBytes("iso-8859-1"), "utf-8");
			PreparedStatement pstat = null;
				ResultSet rs = null;
				String sql = null;
				try{
					Connection conn = DbUtil.getConnection();
					sql="update `casher` set name='"+ name.trim() + "', email='"+ email.trim() + "' ,phone='"+ phone.trim() + "',socialID='"+ socialID.trim() + "'  where  id='"+ id.trim() + "'";
					 pstat = conn.prepareStatement(sql);
					 pstat.executeUpdate();
					// out.close();
					// rs.close();
					 pstat.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				response.sendRedirect("manager/manager-staff.jsp");		
		
		}

	}