package tracom.school.unit;

public class Unit {

    private int id;

    private String name;

    private String code;

    private String details;

    public Unit(){}

    public Unit(int id, String name, String code, String details){
        this.id = id;
        this.code = code;
        this.name = name;
        this.details = details;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
