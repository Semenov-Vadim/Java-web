package servlet;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import pack.Example2;
import user.User;
import db.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		/*String email = request.getParameter("email");
		User user = DBUtils.getUserByEmail(email);
		
		ServletOutputStream out = response.getOutputStream ();
		out.println ("<html>");
		out.println ("<head> <title> Hello Servlet </title> </head>");
		
		out.println ("<body>");
		out.println ("<h3> Hello World </h3>");
		out.println ("This is my first Servlet");
		
		out.println (user.getName());
		
		out.println ("</body>");
		out.println ("<html>");
		
		out.close();*/
		
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        User user = null;
        boolean hasError = false;
        String errorString = null;
        
        if (email == null || password == null || email.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required email and password!";
        }else {
        	//user = DBUtils.findUser(session, userName, password);
        	user = DBUtils.getUserByEmail(email);

            if (user == null) {
                hasError = true;
                errorString = "User email or password invalid";
            }
            else {
            	if(!user.getPassword().equals(password)) {
            		hasError = true;
                    errorString = "Invalid password";
            	}
            }
        }
        if (hasError) {
            user = new User();
            user.setEmail(email);
            user.setPassword(password);
 
            // Сохранить информацию в request attribute перед forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            // Forward (перенаправить) к странице /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/loginView.jsp");
 
            dispatcher.forward(request, response);
        }else {
        	//request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
            
            //Перенаправить на страницу пользователя.
            //response.sendRedirect(request.getContextPath() + "/userInfo.jsp");
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userInfo.jsp");
            
            dispatcher.forward(request, response);
        }
	}

}



