package tracom.school.institution;

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
import java.sql.*;


@WebServlet(urlPatterns = {"/institutions"})
public class InstitutionAction extends HttpServlet {
    List<Institution> institutions = new ArrayList<>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String location = request.getParameter("location");
        String type = request.getParameter("type");


        /*
        try {
            Database DB = new Database("jdbc:mysql://localhost:3306/", "shule_yetu","root", "desiderata");
            Connection conn = DB.connect();
            Statement stmt = conn.createStatement();
            stmt.executeQuery("insert into institutions (name, address, location, type) values("
                    + ",'" + name + "','" + address + "','" + location + "','" + type +
                    "')");
            System.out.println("saved to DB");
        } catch (SQLException e) {
            System.err.println(e);
        }
        */

        institutions.add(new Institution(
              (new Random()).nextInt(1000), name, address, location, type));

//        Database database = new Database("jdbc:mysql://localhost:3306/", "shule_yetu","root", "");
//        database.executeQuery("insert into institutions (name, address, location, type) values("
//                + ",'" + name + "','" + address + "','" + location + "','" + type +
//                "')");

        response.getWriter().println("Saved");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      /* Get data from the database */

//        Database database = new Database("jdbc:mysql://localhost:3306/", "shule_yetu","root", "");
//        database.executeQuery("select * from shule_yetu.institutions")

      /*
        institutions.add(new Institution(1L, "ITMO1", "1523 HK", "Hong Kong", "University"));
        institutions.add(new Institution(2L, "ITMO2", "1523 HK", "Hong Kong", "University"));
        institutions.add(new Institution(3L, "ITMO3", "1523 HK", "Hong Kong", "University"));
        institutions.add(new Institution(4L, "ITMO4", "1523 HK", "Hong Kong", "University"));
        */

        ObjectMapper json = new ObjectMapper();
        response.getWriter().println(json.writeValueAsString(institutions));

    }
}
