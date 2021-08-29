package approve_reimbursements.boss;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

@WebServlet("/TheBossServs")
public class TheBossServs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Configuration cfg = new Configuration();        
    // read the configuration and load in the object
    cfg.configure("hibernate.cfg.xml");        
    // create factory
    SessionFactory factory = cfg.buildSessionFactory();
    // open the session
    Session session = factory.openSession();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				// ************ below order will come from a hidden input name= "order" in each form and will have one 
		//	of the values below in the swith...					
		
		try {
			// read the "order" parameter
			String theOrder = request.getParameter("command");
			
			// if the command is missing, then default to listing employees
			if (theOrder == null) {
				theOrder = "LIST";
			}
			
			// route to the appropriate method
			switch (theOrder) {
			
			case "LIST_REIM_REQUESTS":
				findAllReim_Requests(request, response);
				break;
				
			case "ADD_ REIM_REQUEST":
				saveOrUpdate(request, response);
				break;
				
			case "UPDATE_REIM_REQUEST":
				updateRequest(request, response);
				break;
				
			case "ADD_ EMPLOYEE":
				addEmployee(request, response);
				break;
				
			case "LOAD_EMPLOYEE":
				findEmployeeById(request, response);
				break;
				
			case "UPDATE_EMPLOYEE":
				updateEmployee(request, response);
				break;
			
			case "DELETE_EMPLOYEE":
				deleteEmployeebyId(request, response);
				break;
				
			default:
				findAll(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteEmployeeById(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read employee id from form data
		String employeeId = request.getParameter("employeeId");
		
		// delete student from database
		session.deleteEmployee(employeeId);
		
		//commit the transaction
		t.commit();
					
		// close session
		session.close();
		
		// send them back to "list students" page
		listEmployees(request, response);
	}

	private void saveEmployee(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read employee info from form data
		int id = Integer.parseInt(request.getParameter("employeeId"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// create a new employee object
		Employee employee = new Employee(id, name, email, password);
		
		// perform update on database
		session.save(employee);
		
		//commit the transaction
		t.commit();
			
		// close session
		session.close();
			
		// send them back to the "list students" page
		listStudents(request, response);
		
	}

	private void findById(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read employee id from form data
		int employeeId = request.getParameter("employeeId");
		
		// get employee from database (db util)
		Employee employee = ((Object) session).getEmployee(employeeId);
		
		// place student in the request attribute
		request.setAttribute("THE_Employee", employee);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String name = request.getParameter("name");
		String role = "employee";
		String email = request.getParameter("email");
		double acct_balance = 0;
		String password = request.getParameter("password");
		boolean loggedIn = true;
		
		// create a new student object
		Employee employee = new Employee(name, role, email, acct_balance, password, loggedIn);
		
		// add the student to the database
		session.save(employee);
				
		// send back to main page (the student list)
		listStudents(request, response);
	}

	private void findAllEmployees(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Employee> employees = session.getEmployees();
		
		// add students to the request
		request.setAttribute("EMPLOYEE_LIST", employees);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

}














