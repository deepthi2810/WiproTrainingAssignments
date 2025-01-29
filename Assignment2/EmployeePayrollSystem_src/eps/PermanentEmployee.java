package eps;

public class PermanentEmployee extends Employee {
    private double bonus;

    public PermanentEmployee(int employeeId, String name, String department, double basicSalary, double bonus) {
        super(employeeId, name, department, basicSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Bonus=" + bonus;
    }
}



