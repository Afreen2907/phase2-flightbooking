package dao;

import java.io.IOException;

import java.util.List;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import entity.Login;
import entity.FlightDetails;

/**
 * Servlet implementation class SearchDAO
 */
@WebServlet("/SearchDAO")
public class FlightDetailsDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightDetailsDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sourceCity = request.getParameter("source_city");
		String destinationCity = request.getParameter("destination_city");
		String departDate = request.getParameter("departDate");

		Date date = Date.valueOf(departDate);// converting string into sql date

		FlightDetails flightSearch = new FlightDetails(sourceCity, destinationCity, date);

		List<FlightDetails> flightLists = listflights(flightSearch);
		

			String userId = request.getParameter("userId");
			
			request.setAttribute("flightLists", flightLists);
			
			RequestDispatcher rd=request.getRequestDispatcher("search-flight.jsp?userId=" + userId);
			rd.forward(request,response);
	

		

	}

	private List<FlightDetails> listflights(FlightDetails flightSearch) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FlightDetails.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
	
		
		
		String sourceCity = flightSearch.getSource_city();
		String destCity = flightSearch.getDestination_city();
		Date depart = flightSearch.getDepartDate();
		
		try {
			
			//NOW GET A NEW SESSION AND START TRANSACTION
    	
    		session.beginTransaction();
    		  		
    		//query the flightdetails
    		CriteriaBuilder cb = session.getCriteriaBuilder();
    		CriteriaQuery<FlightDetails> cq = cb.createQuery(FlightDetails.class);
    		Root<FlightDetails> root = cq.from(FlightDetails.class);
    		Predicate[] predicates = new Predicate[3];
    		predicates[0] = cb.equal(root.get("source_city"), sourceCity);
    		predicates[1] = cb.equal(root.get("destination_city"), destCity);
    		predicates[2] = cb.equal(root.get("depart_date"), depart);
    		
    		
    		cq.select(root).where(predicates);
    		
    		List<FlightDetails> theFlightDetails = session.createQuery(cq).getResultList();
    		
    		//display the result
		
			
		
			
			//COMMIT THE TRANSACTION
	    	
    		session.getTransaction().commit();
    		
    		return theFlightDetails;
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}

		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
