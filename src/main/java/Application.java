public class Application {
    public static void main(String[] args) {

        Employee employee = new Employee(15,"Ivan", "Ivanov","male", 35,3);
        EmployeeDAO employeeDao = new EmployeeDAOImpl();

        Integer employeeId = employeeDao.addEmployee(employee);
        System.out.println(employeeDao.getAllEmployee());


    }


}

