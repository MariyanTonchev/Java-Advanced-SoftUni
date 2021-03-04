package bakery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bakery {
    private String name;
    HashMap<String, List<Employee>> bakeries;
    private int capacity;

    public Bakery(String name, int capacity) {
        bakeries = new HashMap<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee){
        bakeries.putIfAbsent(name, new ArrayList<>());
        bakeries.get(name).add(employee);
    }

    public boolean remove(String name){
        if (bakeries.containsKey(name)){
            bakeries.remove(name);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int oldest = Integer.MIN_VALUE;
        Employee oldestEmployee = null;
        for(Map.Entry<String, List <Employee>> bakery : bakeries.entrySet()){
            for (Employee employee : bakery.getValue()) {
                if(employee.getAge() > oldest){
                    oldest = employee.getAge();
                    oldestEmployee = employee;
                }
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        for(Map.Entry<String, List <Employee>> bakery : bakeries.entrySet()){
            for (Employee employee : bakery.getValue()) {
                if(employee.getName().equals(name)){
                    return employee;
                }
            }
        }
        return null;
    }

    public int count() {
        int countOfEmployees = 0;
        for(Map.Entry<String, List <Employee>> bakery : bakeries.entrySet()){
            for (int i = 0; i < bakery.getValue().size(); i++) {
                countOfEmployees++;
            }
        }
        return countOfEmployees;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, List <Employee>> bakery : bakeries.entrySet()){
           sb.append("Employees working at Bakery ").append(bakery.getKey()).append(":").append(System.lineSeparator());
            for (Employee employee : bakery.getValue()) {
                sb.append(employee).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
