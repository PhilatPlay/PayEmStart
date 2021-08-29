package approve_reimbursements.boss;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String role;
	private String name;
	private String email;
	private double acct_balance;
	private String password;
	private boolean loggedIn;
	
	public Employee() {}
	
	public Employee(int id, String role, String name, String email, double acct_balance, String password, boolean loggedIn) {
		super();
		this.id = id;
		this.role = role;
		this.name = name;
		this.email = email;
		this.acct_balance = acct_balance;
		this.password = password;
		this.loggedIn = loggedIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getAcct_balance() {
		return acct_balance;
	}

	public void setAcct_balance(double acct_balance) {
		this.acct_balance = acct_balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", role=" + role + ", name=" + name + ", email=" + email + ", acct_balance=" + acct_balance + ", password=" + password + ", loggedIn="
				+ loggedIn + "]";
	}
}
	
	