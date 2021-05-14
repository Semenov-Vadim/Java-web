package servlet;

import java.io.IOException;

import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import db.DBUtils;
import product.Product;

@WebServlet("/ShowStuff")
public class ShowStuff extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowStuff() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = DBUtils.getAllProducts();
		
		ServletOutputStream out = response.getOutputStream ();
		out.println ("<html>");
		out.println ("<head> <title> Stuff </title> </head>");
		out.println ("<body>");
		out.println ("<h3> Stuff </h3>");
		
		
		//out.println (user.getName());
        for (Product product : products) {
        	out.println ("<table>");
        	
        	out.println ("<tr><td> Name</td><td>");
        	out.println(product.getName());
        	out.println("</td><tr>");
        	
        	out.println ("<tr><td> Description</td><td>");
        	out.println(product.getDescription());
        	out.println("</td><tr>");
        	
        	out.println ("<tr><td> Count</td><td>");
        	out.println(product.getCount());
        	out.println("</td><tr>");
        	
        	out.println ("<tr><td> Cost</td><td>");
        	out.println(product.getCost());
        	out.println("</td><tr>");
        	
        	out.println ("<tr><td> Seller</td><td>");
        	out.println(product.getSeller());
        	out.println ("<tr></td>");
        	
        	out.println ("</table>");
        	out.println("<hr>");
        }
		
		out.println ("</body>");
		out.println ("<html>");
		
		out.close();
	}

}
