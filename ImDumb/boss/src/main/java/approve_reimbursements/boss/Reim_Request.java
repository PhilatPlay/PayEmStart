package approve_reimbursements.boss;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reim_requests")
public class Reim_Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int employeeId;
	private double amount;
	private String details;
	private String status;
	private Date date;

	
	public Reim_Request() {}


	public Reim_Request(int id, int employeeId, double amount, String details, String status, Date date) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.amount = amount;
		this.details = details;
		this.status = status;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Reim_Request [id=" + id + ", employeeId=" + employeeId + ", amount=" + amount + ", details=" + details
				+ ", status=" + status + ", date=" + date + "]";
	}
	
	
}
