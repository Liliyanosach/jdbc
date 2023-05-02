import java.util.List;

public class Application {
    public static void main(String[] args) {

        CityDAO cityDAO = new CityDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        City city = new City("Tomsk");
        cityDAO.addCity(city);

        System.out.println("Города " + cityDAO.getAllCity().contains(city));

        Employee employee1 = new Employee("Petr","Petrov","male",32,city);
        Employee employee2 = new Employee("Irma","Trush", "female",18,city);

        city.setEmployees(List.of(employee1,employee2));

        City updateCity = cityDAO.updateCity(city);
        System.out.println(employeeDAO.getAllEmployee().containsAll(updateCity.getEmployees()));
        cityDAO.getCityById(updateCity.getCityId());
    }


}

