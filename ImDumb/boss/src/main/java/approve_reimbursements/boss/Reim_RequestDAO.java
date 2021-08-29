package approve_reimbursements.boss;


	import java.util.List;

	public interface Reim_RequestDAO {
		
	public List<Reim_Request> findAllReim_Requests();
		
		public Reim_Request findReim_RequestById(int id);
		
		public void saveReim_Request(Reim_Request request);
		
		public void deleteReim_RequestById(int id);

	}

