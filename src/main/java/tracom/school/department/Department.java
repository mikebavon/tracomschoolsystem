package tracom.school.department;

public class Department {

        private int id;

        private String dpname;

        private String headofde;


    public Department(int id, String dpname, String headofde){
        this.id = id;
        this.dpname = dpname;
        this.headofde = headofde;

    }

    public String getHeadofde() {
        return headofde;
    }

    public void setHeadofde(String headofde) {
        this.headofde = headofde;
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




    }


