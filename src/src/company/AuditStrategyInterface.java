package src.company;

public interface AuditStrategyInterface {
	/*
	 * Defining an interface for creating audit reports. Audit should include
	 * company name, employees, responsibility, all clients, their responsibilities,
	 * or costs if they are an employee.
	 */

	// Strategy Pattern
	public void execute();
}