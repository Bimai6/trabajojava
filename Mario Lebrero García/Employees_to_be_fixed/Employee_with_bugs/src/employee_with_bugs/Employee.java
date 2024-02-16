/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package employee_with_bugs;

/**
 *
 * @author oborrego
 */
public interface Employee {
    
    boolean equals(Object o);

    String getId();

    String getName();

    double getSalary();

    String getSalaryRange();

    void setGroup(ProfessionalGroup group);

    void setId(String id);

    void setIsWorking(boolean isWorking);

    void setName(String name);

    void setSalary(double salary);
    
}
