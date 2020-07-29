package tracom.school.tutor;

public class Tutor {

    private int id;
    private int payroll;
    private String name;
    private String email;
    private String department;

    public Tutor() { }

    public Tutor(int id, int payroll, String name, String email, String department) {
        this.id = id;
        this.payroll = payroll;
        this.department =department;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) { this.id = id; }

    public int getPayroll() {
        return this.payroll;
    }
    public void setPayroll(int payroll) { this.payroll = payroll; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email;}

    public String getDepartment() { return this.department; }
    public void setDepartment(String department) { this.department = department;}
}
