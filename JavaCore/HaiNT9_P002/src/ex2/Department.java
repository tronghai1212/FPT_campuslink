package ex2;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String id;
    private List<Employee> employeeList = new ArrayList<Employee>();

    public Department() {

    }

    public Department(String id, List<Employee> employeeList) {
        this.id = id;
        this.employeeList = employeeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
