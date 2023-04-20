import java.util.List;

public interface EmployeeDAO {
    /*
     * Создать в интерфейсе методы:
     *Создание (добавление) сущности Employee в таблицу.
     *Получение конкретного объекта Employee по id.
     *Получение списка всех объектов Employee из базы.
     *Изменение конкретного объекта Employee в базе по id.
     *Удаление конкретного объекта Employee из базы по id.
     */

    void createEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);
}
