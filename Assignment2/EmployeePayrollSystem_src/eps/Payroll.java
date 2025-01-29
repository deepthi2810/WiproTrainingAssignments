package eps;

import java.util.ArrayList;
import java.util.List;

public class Payroll {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        getEmployees().add(employee);
    }

    public void generateReport() {
        System.out.println("Employee Payroll Report:");
        for (Employee employee : getEmployees()) {
            System.out.println(employee);
        }
    }

    public double calculateSalary(Employee employee) {
        if (employee instanceof PermanentEmployee) {
            PermanentEmployee pe = (PermanentEmployee) employee;
            return pe.getBasicSalary() + pe.getBonus();
        } else if (employee instanceof ContractualEmployee) {
            return employee.getBasicSalary();
        }
        return 0.0;
    }

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
