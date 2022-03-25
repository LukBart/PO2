import java.util.*;

public class EmployeeService {

    private final Map<Long, Employee> employeeMap;

    public EmployeeService() {
        employeeMap = new HashMap<>();
        List<Employee> employeeList = List.of(
                new Employee("Jeff Bezos", 100000.0),
                new Employee("Bill Gates", 200000.0),
                new Employee("Mark Zuckerberg", 300000.0));
        employeeList.forEach(employee -> employeeMap.put(employee.getId(), employee));
    }

    public List<Employee> getEmployeeList() {
        return new ArrayList<>(employeeMap.values());
    }

    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    public Employee findById(Long id) {
        return employeeMap.get(id);
    }
}
