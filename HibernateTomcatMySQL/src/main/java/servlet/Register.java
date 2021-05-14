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

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean hasError = false;
        String errorString = null;
        
        String email = request.getParameter("email");
		String password = request.getParameter("password");
		
        if (email == null || password == null || email.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Email and password can not be empty";
        }else {
        	//User user2 = DBUtils.getUserByEmail(email);

            if (DBUtils.getUserByEmail(email) != null) {
                hasError = true;
                errorString = "This email is already taken ";
            }
        }

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phone = request.getParameter("phone");
		
		User user = new User(name, surname, email, phone, password);
        
        if (hasError) {
            // Сохранить информацию в request attribute перед forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            // Forward (перенаправить) к странице /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/register.jsp");
 
            dispatcher.forward(request, response);
        }
        else {
    		DBUtils.addUser(user);
    		
        	request.setAttribute("user", user);
        	//Перенаправить на страницу пользователя.
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userInfo.jsp");
            dispatcher.forward(request, response);
        }
	}

}
