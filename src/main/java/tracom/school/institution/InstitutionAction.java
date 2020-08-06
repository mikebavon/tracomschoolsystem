package tracom.school.institution;

import com.fasterxml.jackson.databind.ObjectMapper;
import tracom.academy.database.Database;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


@WebServlet(urlPatterns = {"/institutions"})
public class InstitutionAction extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String location = request.getParameter("location");
        String type = request.getParameter("type");

        try {
            Database DB = new Database("jdbc:mysql://192.168.254.189:3306:3306/", "shule_yetu","tracom", "password", true);
            Connection conn = DB.connect();
            String sql = "insert into institutions set name=?, address=?, location=?, type =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, location);
            stmt.setString(4, type);
            stmt.executeUpdate();

            System.out.println("saved to DB");
        } catch (SQLException e) {
            System.err.println(e);
        }

        response.getWriter().println("Saved");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Institution> institutions = new ArrayList<>();

        ResultSet result = null;
        try {
            Database DB = new Database("jdbc:mysql://192.168.254.189:3306:3306/", "shule_yetu","tracom", "password", true);
            Connection conn = DB.connect();
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery("select * from shule_yetu.institutions");
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result != null) {
          try {
            while (result.next()) {
              institutions.add(
                  new Institution(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("address"),
                    result.getString("location"),
                    result.getString("type")
                    )
                  );
            }
          } catch (SQLException err) {
              err.printStackTrace();
          }
        }

        ObjectMapper json = new ObjectMapper();
        response.getWriter().println(json.writeValueAsString(institutions));

    }
}
