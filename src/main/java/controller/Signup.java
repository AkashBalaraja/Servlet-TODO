package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/Signup")
public class Signup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String dob=req.getParameter("date");
		String address=req.getParameter("address");
		
		UserDao dao=new UserDao();
		
		User user=dao.fetchByEmail(email);
		
		if (user==null) {
			user=new User();
			user.setName(name);
			user.setEmail(email);
			user.setMobile(Long.parseLong(mobile));
			user.setPassword(password);
			user.setGender(gender);
			user.setDob(LocalDate.parse(dob));
			user.setAddress(address);
				
		
	
		dao.save(user);
		
		resp.getWriter().print("<h1 style='color:green'>Account created successfully");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		dispatcher.include(req, resp);
		}
		else {
			resp.getWriter().print("<h1 style='color:red'>Email alredy exist</h1>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Signup.html");
			dispatcher.include(req, resp);
		//	req.getRequestDispatcher("Signup.html");
		}	
	}
}
