import java.util.List;

public interface CityDAO {

    City addCity(City city);

    City getCityById(int id);

    List<City> getAllCity();

    City updateCity(City city);

    void deleteCity(City city);

}
