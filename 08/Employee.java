public class Employee {

    private static Long NEXT_ID = 0L;
    private final Long id;
    private final String name;
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
        id = ++NEXT_ID;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void incrementSalary(Double addition) {
        salary += addition;
    }

    @Override
    public String toString() {
        return name + ", salary: " + salary;
    }
}
