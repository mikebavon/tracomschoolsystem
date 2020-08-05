package tracom.school.courses;

public class Courses {

    private int id;

    private String cname;

    private String courseid;




    public Courses(int id, String cname, String courseid){
        this.id = id;
        this.cname = cname;
        this.courseid = courseid;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }


}


