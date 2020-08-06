package tracom.school.department;

import com.fasterxml.jackson.databind.ObjectMapper;
import tracom.academy.database.Database;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns = {"/departments"})
public class DepartmentAction extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String depname = request.getParameter("dpname");
        String headOf = request.getParameter("headofde");





        PrintWriter out = response.getWriter();
        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu", "tracom", "password",true);
        database.executeQuery("insert into departments(DEPT_ID,NAME,HOD) values(" + (new Random()).nextInt(10000) + ",'" + depname + "','" + headOf + "')");

        out.println("Saved");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //PrintWriter out = response.getWriter();
        List<Department> departments = new ArrayList<>();
        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu", "tracom", "password",true);

        ResultSet rs = null;
        Statement statement = null;
        try {
            Connection dbConnection = database.getDbConnection();
            statement = dbConnection.createStatement();
            rs = statement.executeQuery("SELECT * FROM shule_yetu.departments");
            if (rs != null) {
                try {
                    while (rs.next()) {
                        departments.add(new Department(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3)));
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }else {
                System.out.println("Empty");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //TODO handle exception properly
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
                e.printStackTrace();
                //TODO handle exception properly
            }
        }

        ObjectMapper json = new ObjectMapper();
        String departmentString  = json.writeValueAsString(departments);
        System.out.println(departmentString);
        response.getWriter().println(departmentString);

    }
}



