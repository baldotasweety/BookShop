

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSer
 */
@WebServlet("/LoginSer")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginSer() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		 String user=(String)request.getParameter("uname");
		String pas=(String)request.getParameter("pass");
		if(pas=="hello123")
		{
	      out.println("You have logged in successfully "+user);
		}
		else{
			RequestDispatcher disp= request.getRequestDispatcher("Login.html");
			disp.forward(request, response);
			out.println("Login correctly..");
		}
	}

}
