import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        final String user = "postgres";
        final String password = "Nosachsech1@";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        System.out.println("Соединение установлено!");

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee city JOIN employee ON employee.city_id = city.city_id WHERE employee.id = 2")) {


            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {


                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderNameOfEmployee = resultSet.getString("gender");
                String cityNameNameOfEmployee = resultSet.getString("city_id");

                System.out.print("Имя: " + firstNameOfEmployee + ", ");
                System.out.print("Фамилия: " + lastNameOfEmployee + ", ");
                System.out.print("пол: " + genderNameOfEmployee + ", ");
                System.out.println("город проживания: " + cityNameNameOfEmployee);

            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List <Employee> employees = employeeDAO.getAllEmployee();

        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Имя: " + employee.getFirstName());
            System.out.println("Фамилия: " + employee.getLastName());
            System.out.println("Пол: " + employee.getAge());
        }

        employeeDAO.updateEmployee(new Employee(6, "Jon", "Martinez", "male", 26, 8));
        List<Employee> updateEmployee = employeeDAO.getAllEmployee();
        for (Employee employee: updateEmployee) {
            System.out.println(employee);
        }

        employeeDAO.createEmployee(new Employee(9,"Zlata","Pock","female",34,3));
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println(employeeDAO.getEmployeeById(2));

        employeeDAO.deleteEmployee(7);
        for (Employee employee: employees) {
            System.out.println(employee);
        }


    }
}
