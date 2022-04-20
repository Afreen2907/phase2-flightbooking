package dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entity.Login;

/**
 * Servlet implementation class LoginDAO
 */
@WebServlet("/LoginDAO")
public class LoginDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginDAO() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public boolean validate(String userLogin, String password) {


    	System.out.println("Validating");
    	SessionFactory factory = new Configuration()
    						     .configure("hibernate.cfg.xml")
    						     .addAnnotatedClass(Login.class)
    						     .buildSessionFactory();
    	Session session = factory.getCurrentSession();
    	
    	try{
    		
    		System.out.println("......");
    		Login user= new Login(userLogin, password);
    		
    		
    		
    		//NOW GET A NEW SESSION AND START TRANSACTION
    		session=factory.getCurrentSession();
    		session.beginTransaction();
    		//RETREIVE STUDENT BASED ON PRIMARY KEY: USEREMAIL
    		
    		Login myUser = session.get(Login.class, user.getUserEmail());
    		
    		
    		
    		if(myUser != null && myUser.getPassword().equals(user.getPassword())) {
    			return true;
    		}
    		
    		//COMMIT THE TRANSACTION
    	
    		session.getTransaction().commit();
    		
    	}
    	 catch (Exception e) {
           
             e.printStackTrace();
         } finally {
        	 session.close();
         }
    	return false;
    } 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userEmail= request.getParameter("useremail");
		String password = request.getParameter("password");
		
	
		
		boolean checkValidation = validate(userEmail, password);
		
//		PrintWriter out=response.getWriter();
		if(!checkValidation) {
//			out.println("Incorrect User Email or Password");
			
			request.setAttribute("authenticate", "Incorrect User Email or Password");
			
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request,response);
		} else {
			response.sendRedirect("search-flight.jsp?userId=" + userEmail);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
