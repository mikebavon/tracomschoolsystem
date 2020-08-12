package tracom.school.student;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    public Student() { }

//    public Student(int id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

}
