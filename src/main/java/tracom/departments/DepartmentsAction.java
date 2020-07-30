package tracom.departments;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.PreparableStatement;

import tracom.academy.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns = {"/departments"})
public class DepartmentsAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final String name = request.getParameter("dpname");
        final String code = request.getParameter("dpcode");
       

       

        final Database database = new Database("jdbc:mysql://127.0.0.1:3306/", "tracom","root", "ngechumunga");
        
        database.executeQuery("insert into departments(DEPT_ID,NAME,HOD) values(" + (new Random()).nextInt(10000) + ",'" + name + "','" + code + "')");

        response.getWriter().println("Saved");
        
        

    }

    // 192.168.254.189:3306
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException{
        final Database database = new Database("jdbc:mysql://127.0.0.1:3306/", "tracom","root", "ngechumunga");
        //final Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu","tracom", "password");

        final List<Departments> departments = new ArrayList<>();


        ResultSet data=null;
        
        try {
            Connection connection=database.connect();
            Statement stmt=connection.createStatement();
			data=stmt.executeQuery("SELECT * FROM tracom.departments");
		} catch (SQLException e) {
            
            
			e.printStackTrace();
        }



        if(data!=null){
            try{
                while(data.next()){
                    departments.add(new Departments(
                        data.getInt("DEPT_ID"),
                        data.getString("NAME"),
                        data.getString("HOD")
                        ));
                }
            }catch(SQLException e){

                System.out.println(e.getMessage());
            }
        }
        
        




        final ObjectMapper json = new ObjectMapper();
        response.getWriter().println(json.writeValueAsString(departments));



    }
@Override
protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        final Database database = new Database("jdbc:mysql://127.0.0.1:3306/", "tracom","root", "ngechumunga");
        final String id = req.getParameter("id");

        //Delete the selected id from Database
       try {
            Connection connection=database.connect();
           
            String sql="DELETE FROM tracom.departments WHERE DEPT_ID=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(id));
            pstmt.executeUpdate();

            resp.getWriter().println("Deleted Successfully");


			
		} catch (SQLException e) {
            
            
			e.printStackTrace();
        }

        
    
}

}

