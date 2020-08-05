package tracom.school.department;

public class Department {

        private int id;

        private String dpname;

        private String HOD;




        public Department(int id, String dpname, String HOD){
            this.id = id;
            this.dpname = dpname;
            this.HOD = HOD;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDpname() {
            return dpname;
        }

        public void setDpname(String dpname) {
            this.dpname = dpname;
        }

        public String getHOD() {
            return HOD;
        }

        public void setHOD(String HOD) {
            this.HOD = HOD;
        }


    }


