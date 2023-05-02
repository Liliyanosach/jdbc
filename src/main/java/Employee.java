import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column (name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column (name = "gender", length = 6, nullable = false)
    private String gender;
    @Column (name = "age", nullable = false)
    private int age;
    @Column (name = "city_id")
    private Integer city;


    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String gender, int age, Integer city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", cityId=" + city +
                '}';
    }
}
