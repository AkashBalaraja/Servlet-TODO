package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.io.ListenCallback;

import dao.UserDao;
import dto.Task;
import dto.User;

@WebServlet("/Login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		UserDao userDao=new UserDao();
		User user=userDao.fetchByEmail(email);
		
		if (user==null) {
			resp.getWriter().print("<h1> Incorrect Email</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);			
		}
		else {
			if (user.getPassword().equals(password)) {
				resp.getWriter().print("<h1> Login success</h1>");
				//fetch data from database
				List<Task> list=userDao.fetchAllTasks();
				
				//set the data in request 
				req.setAttribute("list", list);
				req.getRequestDispatcher("Homepage.html").include(req, resp);
		}else {
			resp.getWriter().print("<h1> Incorrect password</h1>");
		}
				
	}
	

	}}