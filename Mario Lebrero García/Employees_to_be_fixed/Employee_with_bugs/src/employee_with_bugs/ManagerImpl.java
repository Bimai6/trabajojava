/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee_with_bugs;

/**
 *
 * @author oborrego
 */
public class ManagerImpl extends EmployeeImpl implements Manager {

    private String department;

    public ManagerImpl(String name, String id, double salary, ProfessionalGroup group, String department) {
        super(name, id, salary, group);
        this.department = department;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public String getsalaryRange() {
        String value = "";
        switch (this.group) {
            case GROUP_1, GROUP_2:
                if (this.isWorking) {
                    value = "SUPER_HIGH";
                } else {
                    value = "HIGH";
                }
            case GROUP_3:
                if (this.isWorking) {
                    value = "HIGH";
                } else {
                    value = "LOW";
                }
            case GROUP_10, GROUP_11:
                if (this.isWorking) {
                    value = "LOW";
                } else {
                    value = "NORMAL";
                }
        }
        return value;
    }

}
