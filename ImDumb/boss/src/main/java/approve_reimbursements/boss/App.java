package approve_reimbursements.boss;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.Session;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Your Project has started...." );        
        // create a configuration object
        Configuration cfg = new Configuration();        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
//        // begin the transition
        Transaction t = session.beginTransaction();
        System.out.println(factory);
        System.out.println(factory.isClosed());
        
//       try{ 
//        
//       // create  new employee
//        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setName("ck");
//        employee.setEmail("ck@ck.com");
//        employee.setAcct_balance(0.00);
//        employee.setLoggedIn(true);
//        employee.setPassword("password");
//        
//        // save the employee
//        session.save(employee);
//       
//        //commit the transition
//        t.commit();
//        System.out.println(Employee created!);
//       } finally {  
//      		//close the session
//      	session.close();
//        }
    }
}
