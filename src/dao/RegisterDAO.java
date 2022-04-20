package dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Login;
import entity.Register;

/**
 * Servlet implementation class RegisterDAO
 */
@WebServlet("/RegisterDAO")
public class RegisterDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				int age = Integer.parseInt(request.getParameter("age"));
				String docType = request.getParameter("docType");
				String address = request.getParameter("address");
				String country = request.getParameter("country");
				String useremail = request.getParameter("useremail");
				String password = request.getParameter("password");
				String conPassword = request.getParameter("conPassword");
				
				System.out.println(firstName + lastName + age + docType + address +  country + password + conPassword);
				
				System.out.println(!(password == conPassword));
				if( !(password.equals(conPassword))) {
					System.out.println("Password mismatched");
					request.setAttribute("mismatch-password", "Password mismatch");
					RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
					rd.forward(request,response);
				} else {
					response.sendRedirect("login.jsp");
					
					Register newUser = new Register();
					newUser.setFirstName(firstName);
					newUser.setLastName(lastName);
					newUser.setAge(age);
					newUser.setAddress(address);
					newUser.setDocType(docType);
					newUser.setCountry(country);
					newUser.setUserEmail(useremail);
					
					Login user = new Login(useremail, password);
				
					createNewUser(newUser, user);
					
					
				}
	}

	private void createNewUser(Register newUser, Login user) {
		SessionFactory factory = new Configuration()
			     .configure("hibernate.cfg.xml")
			     .addAnnotatedClass(Register.class)
			     .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(newUser);
			session.getTransaction().commit();
		
			System.out.println("Done!");
			addUserLogin(user);
		}catch (Exception e) {
	           
            e.printStackTrace();
        } finally {
       	 session.close();
        }
	}
	
	private void addUserLogin(Login user) {
		SessionFactory factory = new Configuration()
			     .configure("hibernate.cfg.xml")
			     .addAnnotatedClass(Login.class)
			     .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		
			System.out.println("Done!");
		}catch (Exception e) {
	           
            e.printStackTrace();
        } finally {
       	 factory.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
