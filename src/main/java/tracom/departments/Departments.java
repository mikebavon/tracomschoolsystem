package tracom.departments;

public class Departments {
private int id;
private String dpname;
private String dpcode;




public Departments(){}

public Departments(int id, String dpname, String dpcode){
    this.id = id;
	this.dpname = dpname;
	this.dpcode = dpcode;
	
    
}




public String getDpcode() {
	return dpcode;
}

public void setDpcode(String dpcode) {
	this.dpcode = dpcode;
}

public String getDpname() {
	return dpname;
}

public void setDpname(String dpname) {
	this.dpname = dpname;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}





}

    
