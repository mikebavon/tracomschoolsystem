package tracom.school.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import tracom.academy.database.Database;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@WebServlet(urlPatterns = {"/student"})
public class StudentAction extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu","tracom", "password", true);
        int id = Integer.parseInt(request.getParameter("sid"));
        String name = request.getParameter("sname");
        String email = request.getParameter("semail");
        boolean dataSaved = false;
        PreparedStatement statement = null;
        try {
            String insertQuery = "INSERT INTO shule_yetu.students (STUDENT_ID, NAME, EMAIL) VALUES (?,?,?)";
            statement = database.getDbConnection().prepareStatement(insertQuery);
            database.getDbConnection().setAutoCommit(false);
            database.getDbConnection().commit();
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            int rows = statement.executeUpdate();
            if(rows > 0) dataSaved = true;
            database.getDbConnection().setAutoCommit(true);
        }catch (SQLException sqlException){
            dataSaved = false;
            //TODO handle exception properly
        }finally {
            try {
                if (statement != null) statement.close();
                if (database.getDbConnection() != null) database.getDbConnection().close();
                if(dataSaved) response.getWriter().println("Saved");
                else response.getWriter().println("OK");
            } catch (Exception e) {
                e.printStackTrace();
                //TODO handle exception properly
            }
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu","tracom", "password", true);
        String sql = "SELECT * FROM shule_yetu.students";
        List<Student> students = new ArrayList<Student>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = database.getDbConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("STUDENT_ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                students.add(new Student(id, name, email));
            }
            ObjectMapper json = new ObjectMapper();
            response.getWriter().println(json.writeValueAsString(students));
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            //TODO handle exception properly
        }finally {
            try {
                if (statement != null) statement.close();
                if (database.getDbConnection() != null) database.getDbConnection().close();
            } catch (Exception e) {
                e.printStackTrace();
                //TODO handle exception properly
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu", "tracom", "password",
                true);
    // Delete item by id in the database
        final String id = req.getParameter("id");
        try {
            Connection connection = database.connect();
            String deleteQuery = "DELETE FROM shule_yetu.students WHERE STUDENT_ID=?";
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, Integer.parseInt(id));
            statement.executeUpdate();

            resp.getWriter().println("Deleted Successfully");

        } catch (SQLException e) {

            e.getMessage();
        }
    }
}