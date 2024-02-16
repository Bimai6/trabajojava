/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee_with_bugs;

import Exceptions.EmployeeListException;

/**
 *
 * @author oborrego
 */
public interface EmployeeList {

    // Método para agregar un empleado a la lista
    int addEmployee(Employee employee) throws EmployeeListException;

    // Método para contar el número de empleados en la lista
    int countEmployees();

    int countManagersBySalaryRange(String salaryRange);

    // Método para encontrar un empleado por su ID
    Employee findEmployeeById(String id);

    Employee findEmployeeWithHighestSalary();

    // Método para eliminar un empleado de la lista
    int removeEmployee(Employee employee);
    
}
