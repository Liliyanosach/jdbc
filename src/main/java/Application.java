import java.sql.*;

public class Application {
    public static void main(String[] args) {

        final String user = "postgres";
        final String password = "Nosachsech1@";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection =
                DriverManager.getConnection(url, user, password);
        PreparedStatement statement =
                connection.prepareStatement("SELECT * FROM employee WHERE id=2")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                System.out.println("ID книги: " + idOfEmployee);

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                String cityId = resultSet.getString("city_id");


                System.out.println("Имя " + firstName);
                System.out.println("Фамилия " + lastName);
                System.out.println("Пол " + gender);
                System.out.println("Город " + cityId);
            }

            System.out.println("Соединение установлено!");

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }

    }
}
