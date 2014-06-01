package org.jsplogin.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{	 
		     BeanUser user = new BeanUser();
		     user.setUserName(request.getParameter("un"));
		     user.setPassword(request.getParameter("pw"));

		     user = UsersDAO.login(user);
			   		    
		     if (user.isValid())
		     {
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentUser",user); 
		          response.sendRedirect("userLogged.jsp");   		
		     }
			        
		     else 
		          response.sendRedirect("invalidLogin.jsp");
		} 
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}
}
