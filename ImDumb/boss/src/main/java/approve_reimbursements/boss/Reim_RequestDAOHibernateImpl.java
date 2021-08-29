package approve_reimbursements.boss;


	import java.util.List;

	import javax.persistence.EntityManager;

	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.Transaction;
	import org.hibernate.Session;
	import org.hibernate.query.Query;


	public class Reim_RequestDAOHibernateImpl implements Reim_RequestDAO {
		
		System.out.println( "Your Project has started...." );        
	    // create a configuration object
	    Configuration cfg = new Configuration();        
	    // read the configuration and load in the object
	    cfg.configure("hibernate.cfg.xml");        
	    // create factory
	    SessionFactory factory = cfg.buildSessionFactory();
	    // open the session
	    Session session = factory.openSession();
//	    // begin the transition
	    Transaction t = session.beginTransaction();
		
		
		@Override
		public List<Reim_Request> findAllRequests() {
			
			// create a query
			Query<Reim_Request> theQuery =
					session.createQuery("from Reim_Request", Reim_Request.class);
			
			// execute query and get result list
			List<Reim_Request> requests = theQuery.getResultList();
			
			// return the results		
			return requests;
		}


		@Override
		public Reim_Request findRequestsById(int id) {
			
			// get the request
			Reim_Request request =
					session.get(Reim_Request.class, id);
			
			// return the request
			return request;
		}


		@Override
		public void saveRequest(Reim_Request request) {
			
			// save request
			session.saveOrUpdate(request);
		}


		@Override
		public void deleteRequestById(int theId) {
					
			// delete object with primary key
			Query theQuery = 
					session.createQuery(
							"delete from Reim_Request where id=:requestId");
			theQuery.setParameter("requestId", id);
			
			theQuery.executeUpdate();
		}

	}

