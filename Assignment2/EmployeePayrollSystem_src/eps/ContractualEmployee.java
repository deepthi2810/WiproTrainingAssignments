package eps;

public class ContractualEmployee extends Employee {
    private int contractDuration; // in months

    public ContractualEmployee(int employeeId, String name, String department, double basicSalary, int contractDuration) {
        super(employeeId, name, department, basicSalary);
        this.contractDuration = contractDuration;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    @Override
    public String toString() {
        return super.toString() + ", Contract Duration=" + contractDuration + " months";
    }
}
