import java.util.Date;

public class Employee {
    String name;
    Integer salary;
    String city;
    Date joinDate;
    String phoneNumber;

    public Employee(String name, Integer salary, String city, Date joinDate, String phoneNumber) {
        this.name = name;
        this.salary = salary;
        this.city = city;
        this.joinDate = joinDate;
        this.phoneNumber = phoneNumber;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", city='" + city + '\'' +
                ", joinDate=" + joinDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
