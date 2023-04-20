import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "Nosachsech1@";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void createEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE employeelist SET id=?, firs_name =?,last_name=?,gender=?,age=?, id_city=? WHERE id =?")) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getCityId());
            statement.setInt(7, employee.getId());
            int resultSet = statement.executeUpdate();
            System.out.println("Раюотник обновлен");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }


    @Override
    public Employee getEmployeeById(int id) {

        Employee employee = null;
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employeelist WHERE id=" + id)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String firsNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_Name");
                String genderNameOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");
                int cityNameOfEmployee = resultSet.getInt("city_id");
                employee = new Employee(idOfEmployee, firsNameOfEmployee, lastNameOfEmployee, genderNameOfEmployee, ageOfEmployee, cityNameOfEmployee);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");
                int cityNameOfEmployee = resultSet.getInt("city_id");

                employees.add(new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderOfEmployee, ageOfEmployee, cityNameOfEmployee));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO employee( id, firs_name, last_name, gender, age, city_id) VALUES (?,?,?,?,?,?)")) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getCityId());

            System.out.println("работник добавлен");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM employeelist WHERE id = " + id)) {
            int resultSet = statement.executeUpdate();
            System.out.println(" сотрудник удален");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();

        }
    }
}
