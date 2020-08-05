package tracom.school.courses;

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

@WebServlet(urlPatterns = {"/courses"})
public class CoursesAction extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String courseName = request.getParameter("cname");
        String courseId = request.getParameter("cid");



        PrintWriter out = response.getWriter();
        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu", "tracom", "password",true);
        database.executeQuery("insert into courses(COURSE_ID,NAME,) values(" + (new Random()).nextInt(10000) + ",'" + courseName + "','" + courseId + "')");

        out.println("Saved");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //PrintWriter out = response.getWriter();
        List<Courses> courses = new ArrayList<>();
        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu", "tracom", "password",true);

        ResultSet rs = null;
        Statement statement = null;
        try {
            Connection dbConnection = database.getDbConnection();
            statement = dbConnection.createStatement();
            rs = statement.executeQuery("SELECT * FROM shule_yetu.courses");
            if (rs != null) {
                try {
                    while (rs.next()) {
                        courses.add(new Courses(
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
        String courseString  = json.writeValueAsString(courses);
        System.out.println(courseString);
        response.getWriter().println(courseString);

    }
}
