package tracom.school.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import tracom.academy.database.Database;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@WebServlet(urlPatterns = {"/student"})
public class StudentAction extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        //String details = request.getParameter("details");

        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu","tracom", "password");
        database.executeQuery("insert into students(name,email) values(" + name + "','" + email+ "')");


        // try {
        // Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.254.189:3306/shule_yetu","tracom", "password");
        //     String insertQuery = "INSERT INTO students (NAME,EMAIL) VALUES (?,?)";
        //     PreparedStatement statement = connection.prepareStatement(insertQuery);
        //     connection.setAutoCommit(false);
        //     connection.commit();
        //     statement.setString(1, name);
        //     statement.setString(2, email);
        //     //int rows = statement.executeUpdate();
        //     // if(rows > 0)
        //     //     messageSaved = true;
        //     connection.setAutoCommit(true);
        // }catch (SQLException sqlException){
        //     //messageSaved = false;
        //     System.out.println("message has been saved");
        // }
        //return messageSaved;

        response.getWriter().println("Saved");

    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        List<Student> students = new ArrayList<Student>();

        students.add(new Student(1L, "MATHEMATICS", "0001", "MATHEMATICS"));
        students.add(new Student(2L, "ENGLISH", "0002", "ENGLISH"));
        // units.add(new Unit(3L, "KISWAHILI", "0003", "KISWAHILI"));
        // units.add(new Unit(4L, "SCIENCE", "0004", "SCIENCE"));
        // units.add(new Unit(5L, "GEOGRAPHY", "0005", "GEOGRAPHY"));

        ObjectMapper json = new ObjectMapper();
        response.getWriter().println(json.writeValueAsString(students));

    }
}