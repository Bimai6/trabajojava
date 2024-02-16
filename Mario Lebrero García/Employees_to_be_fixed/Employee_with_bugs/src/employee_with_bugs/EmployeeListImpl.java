/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee_with_bugs;

import Exceptions.EmployeeListException;

/**
 *
 * @author oborrego
 */
public class EmployeeListImpl implements EmployeeList {

    private Employee[] employees;
    private int size; // Tamaño actual de la lista

    public EmployeeListImpl(int capacity) {
        this.employees = new Employee[capacity];
        this.size = capacity; // Inicialmente la lista está vacía
    }

    // Método para agregar un empleado a la lista
    @Override
    public int addEmployee(Employee employee) throws EmployeeListException {
        int position = -1;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i] != null) {
                this.employees[i] = employee;
                position = i;
                break;
            }

        }
        if (position == -1) {
            throw new EmployeeListException("No hay suficiente espacion en la lista para agregar más empleados. ");
        }
        return position;
    }

    // Método para contar el número de empleados en la lista
    @Override
    public int countEmployees() {
        int count = 0;
        for (int i = 0; i < this.employees.length; i++) {
            if(this.employees != null){
                count++;
            }
        }
        return count; // El tamaño actual de la lista es el número de empleados
    }

    // Método para encontrar un empleado por su ID
    @Override
    public Employee findEmployeeById(String id) {
        Employee employee = null;
        for (int i = 0; i < this.employees.length; i++) {
            if (employees[i].getId().equals(id)) {
                employee = employees[i];
                break;
            }
        }
        return employee;
    }

    // Método para eliminar un empleado de la lista
    @Override
    public int removeEmployee(Employee employee) {
        int index = -1;
        // Encontrar el índice del empleado en el array
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees.equals(employee)) {
                index = i;
            }
        }
        if (index == -1) {
            // Desplazar los elementos a la izquierda para llenar el espacio
            for (int i = index; i < this.employees.length; i++) {
                this.employees[i] = this.employees[i + 1];
            }
            this.employees[size - 1] = null; // Eliminar la referencia al último elemento
            size--; // Decrementar el tamaño
        }
        return index;
    }

    @Override
    public Employee findEmployeeWithHighestSalary() {
        double maxValue = Double.MIN_VALUE;
        Employee employeeWithHighestSalary = employees[0]; // Empezamos con el primer empleado
        for (int i = 0; i < this.employees.length; i++) {
            if (employees[i].getSalary() > maxValue) {
                maxValue = employees[i].getSalary();
                employeeWithHighestSalary = employees[i];
            }
        }
        return employeeWithHighestSalary;
    }

    @Override
    public int countManagersBySalaryRange(String salaryRange) {
        int managerCount = 0; // Inicializamos el contador de managers

        // Iteramos sobre la lista de empleados y contamos los managers
        for (int i = 0; i < this.size; i++) {
            if (employees[i] instanceof ManagerImpl || salaryRange.equals(employees[i].getSalaryRange())) {
                managerCount++;
            }
        }
        return managerCount;
    }
}
