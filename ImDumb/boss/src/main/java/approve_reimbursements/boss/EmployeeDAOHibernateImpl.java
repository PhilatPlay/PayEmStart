package approve_reimbursements.boss;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	System.out.println("Your Project has started...");        
    // create a configuration object
    Configuration cfg = new Configuration();        
    // read the configuration and load in the object
    cfg.configure("hibernate.cfg.xml");        
    // create factory
    SessionFactory factory = cfg.buildSessionFactory();
    // open the session
    Session session = factory.openSession();
//    // begin the transition
    Transaction t = session.beginTransaction();
	
	
	@Override
	public List<Employee> findAllEmployees() {
		
		// create a query
		Query<Employee> theQuery =
				session.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results		
		return employees;
	}


	@Override
	public Employee findEmployeeById(int id) {

		// get the employee
		Employee employee =
				session.get(Employee.class, id);
		
		// return the employee
		return employee;
	}


	@Override
	public void saveEmployee(Employee employee) {

		// save employee
		session.saveOrUpdate(employee);
	}


	@Override
	public void deleteEmplyeeById(int id) {
				
		// delete object with primary key
		Query theQuery = 
				session.createQuery(
						"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
	}

}