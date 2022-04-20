package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="flightdetails")
public class FlightDetails implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="flight_no")
	private String flight_no;
	
	@Column(name="airline_name")
	private String airline_name;
	
	@Column(name="price")
	private int price;
	
	@Column(name="source_city")
	private String source_city;
	
	@Column(name="destination_city")
	private String destination_city;
	
	@Column(name="departure_time")
	private Date departure_time;
	
	@Column(name="arrival_time")
	private Date arrival_time;
	
	@Column(name="depart_date")
	private Date depart_date;
	
	
	
	public Date getDepart_date() {
		return depart_date;
	}


	public void setDepart_date(Date depart_date) {
		this.depart_date = depart_date;
	}


	private FlightDetails() {}


	public FlightDetails(String source_city, String destination_city, Date departDate) {
		super();
		this.source_city = source_city;
		this.destination_city = destination_city;
		this.depart_date = departDate;
	}


	public String getFlight_no() {
		return flight_no;
	}


	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}


	public String getAirline_name() {
		return airline_name;
	}


	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getSource_city() {
		return source_city;
	}


	public void setSource_city(String source_city) {
		this.source_city = source_city;
	}


	public String getDestination_city() {
		return destination_city;
	}


	public void setDestination_city(String destination_city) {
		this.destination_city = destination_city;
	}


	public Date getDeparture_time() {
		return departure_time;
	}


	public void setDeparture_time(Date departure_time) {
		this.departure_time = departure_time;
	}


	public Date getArrival_time() {
		return arrival_time;
	}


	public void setArrival_time(Date arrival_time) {
		this.arrival_time = arrival_time;
	}


	public Date getDepartDate() {
		return depart_date;
	}


	public void setDepartDate(Date departDate) {
		this.depart_date = departDate;
	}
	
	


	

}
