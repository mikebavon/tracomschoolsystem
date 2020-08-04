package tracom.school.faculty;


import com.fasterxml.jackson.databind.ObjectMapper;
import tracom.academy.database.Database;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.*;
import java.sql.*;


@WebServlet(urlPatterns = {"/faculties"})
public class FacultyAction extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        String institution = request.getParameter("institution");

        try {
            Database DB = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu","tracom", "password", true);
            Connection conn = DB.getDbConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into faculties(title,name,institution ) values('" + title + "','" + name + "','" + institution +
                    "')");
            System.out.println("saved to DB");
        } catch (SQLException e) {
            System.err.println(e);
        }




//        Database database = new Database("jdbc:mysql://localhost:3306/", "shule_yetu","root", "");
//        database.executeQuery("insert into institutions (name, address, location, type) values("
//                + ",'" + name + "','" + address + "','" + location + "','" + type +
//                "')");

        response.getWriter().println("Saved");
        response.getWriter().println(title);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        Database database = new Database("jdbc:mysql://localhost:3306/", "shule_yetu","root", "");
//        database.executeQuery("insert into institutions (name, address, location, type) values("
//                + ",'" + name + "','" + address + "','" + location + "','" + type +
//                "')");

        List<Faculty>faculties = new ArrayList<Faculty>();

        faculties.add(new Faculty(1L, "ITMO1", "1523 HK", "Hong Kong"));
        faculties.add(new Faculty(2L, "ITMO1", "1523 HK", "Hong Kong"));
        faculties.add(new Faculty(3L, "ITMO1", "1523 HK", "Hong Kong"));
        faculties.add(new Faculty(4L, "ITMO1", "1523 HK", "Hong Kong"));



        ObjectMapper json = new ObjectMapper();
        response.getWriter().println(json.writeValueAsString(faculties));

    }
}
