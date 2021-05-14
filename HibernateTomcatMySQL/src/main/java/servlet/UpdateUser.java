package servlet;

import java.io.IOException;

import db.DBUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import user.User;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateUser() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean hasError = false;
        String errorString = null;
        
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		User user = new User(name, surname, email, phone, password);
		
        if (email == null || password == null || email.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Email and password can not be empty";
        }else {
        	DBUtils.updateUser(user);
        }
        if (hasError) {
            request.setAttribute("errorString", errorString);
            
            // Сохранить информацию в request attribute перед forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
            
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userInfo.jsp");
            dispatcher.forward(request, response);
        }else {
        	request.setAttribute("user", user);
            
            //Перенаправить на страницу пользователя.
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userInfo.jsp");
            dispatcher.forward(request, response);
        }
	}

}
