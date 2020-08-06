package tracom.school.faculty;

public class Faculty{

    private int id;

    private String title;

    private String name;

    private String institution;

    public Faculty(int id, String title, String name, String institution) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.institution = institution;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}