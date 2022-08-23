package fa.training.ex2;

import java.util.List;

public class Department {
    private String name;
    private String location;
    private List<Employee> listEmployee;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public Department(){

    }

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Department(String name, String location, List<Employee> listEmployee) {
        this.name = name;
        this.location = location;
        this.listEmployee = listEmployee;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", listEmployee=" + listEmployee.toString();
    }
}
