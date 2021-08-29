package approve_reimbursements.boss;

import java.util.List;

public interface EmployeeDAO {
	
public List<Employee> findAllEmployees();
	
	public Employee findEmployeeById(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployeeById(int id);

}
