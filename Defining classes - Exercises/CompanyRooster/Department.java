package CompanyRooster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> list;

    public Department() {
        this.list = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.list.add(employee);
    }

    public List<Employee> getList() {
        return Collections.unmodifiableList(this.list);
    }

    public double getAverageSalary() {
        double average = 0.0;
        for (Employee employee : this.list) {
            average += employee.getSalary();
        }
        return average / this.list.size();
    }
}