/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee_with_bugs;

/**
 *
 * @author oborrego
 */
public class EmployeeImpl implements Employee {

    protected String name;
    protected String id; //must be dddddddd-X
    protected double salary;
    protected ProfessionalGroup group;
    protected boolean isWorking;

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeeImpl(String name, String id, double salary, ProfessionalGroup group) {
        this.name = name;
        try {
            checkId(id);
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println("The id format is not valid");
        }
        
        this.group = ProfessionalGroup.GROUP_10;
        this.salary = salary;
        this.isWorking = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(String id) {
        try {
            checkId(id);
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println("The id format is not valid");
        }
    }

    @Override
    public void setGroup(ProfessionalGroup group) {
        this.group = group;
    }

    @Override
    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }


    @Override
    public String getId() {
        return id;
    }
    @Override
     public boolean equals(Object o) {
        boolean b = false;
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            b = this.id.equals(employee.getId());
        }
        return b;
    }
     
    public static void checkId(String ID) throws IllegalArgumentException {
        String idPattern = "\\d{8}-[A-Z]";
        if (!ID.matches(idPattern)) {
            throw new IllegalArgumentException("El formato del ID no es válido");
        }
    }

    @Override
    public String getSalaryRange() {
        String value = "";
        
        switch(this.group){
            case GROUP_1, GROUP_2:
                value = "SUPER_HIGH";
            case GROUP_3:
                value = "HIGH";
            case GROUP_10, GROUP_11:
                value = "LOW";
            default:
                value= "NORMAL";
        } 
        return value;
    }

}
