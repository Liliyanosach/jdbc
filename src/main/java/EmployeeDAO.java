import java.util.List;

public interface EmployeeDAO {

    Integer addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    void updateEmployee(Employee employee, int id);

    void deleteEmployee(Employee employee);
}
