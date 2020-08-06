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
            Database DB = new Database("jdbc:mysql://192.168.254.189:3306:3306/", "shule_yetu","tracom", "password", true);
            Connection conn = DB.connect();
            String sql = "insert into faculties set title=?, name=?, institution=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, name);
            stmt.setString(3, institution);
            stmt.executeUpdate();
            System.out.println("saved to DB");

        } catch (SQLException e) {
            System.err.println(e);
        }




//        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu","tracom", "");
//        database.executeQuery("insert into institutions (name, address, location, type) values("
//                + ",'" + name + "','" + address + "','" + location + "','" + type +
//                "')");

        response.getWriter().println("Saved");
        response.getWriter().println(title);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu","tracom", "");
//        database.executeQuery("insert into institutions (name, address, location, type) values("
//                + ",'" + name + "','" + address + "','" + location + "','" + type +
//                "')");

        List<Faculty>faculties = new ArrayList<Faculty>();

        faculties.add(new Faculty(1L, "ITMO1", "1523 HK", "Hong Kong"));
        faculties.add(new Faculty(2L, "ITMO1", "1523 HK", "Hong Kong"));
        faculties.add(new Faculty(3L, "ITMO1", "1523 HK", "Hong Kong"));
        faculties.add(new Faculty(4L, "ITMO1", "1523 HK", "Hong Kong"));

        ResultSet result = null;
        try {
            Database DB = new Database("jdbc:mysql://192.168.254.189:3306:3306/", "shule_yetu","tracom", "password", true);
            Connection conn = DB.connect();
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery("select * from shule_yetu.faculties");
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result != null) {
          try {
            while (result.next()) {
              faculties.add(
                  new Faculty(
                    result.getInt("id"),
                    result.getString("title"),
                    result.getString("name"),
                    result.getString("institution")
                    )
                  );
            }
          } catch (SQLException err) {
              err.printStackTrace();
          }
        }

        ObjectMapper json = new ObjectMapper();
        response.getWriter().println(json.writeValueAsString(faculties));

    }
}
