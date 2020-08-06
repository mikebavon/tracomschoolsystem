package tracom.school.tutor;

import com.fasterxml.jackson.databind.ObjectMapper;
import tracom.academy.database.Database;
import tracom.school.student.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/tutor"})
public class TutorAction extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu","tracom", "password", true);
        int id = Integer.parseInt(request.getParameter("tid"));
        int payroll =Integer.parseInt(request.getParameter("tpayroll"));
        String name = request.getParameter("tname");
        String email = request.getParameter("temail");
        String department = request.getParameter("tdepartment");
        boolean dataSaved = false;
        PreparedStatement statement = null;
        try {
            String insertQuery = "INSERT INTO shule_yetu.tutors(TUTOR_ID, PAYROLL_NO, NAME, EMAIL, DEPARTMENT) VALUES (?,?,?,?,?)";
            statement = database.getDbConnection().prepareStatement(insertQuery);
            database.getDbConnection().setAutoCommit(false);
            database.getDbConnection().commit();
            statement.setInt(1, id);
            statement.setInt(2, payroll);
            statement.setString(3, name);
            statement.setString(4, email);
            statement.setString(5, department);
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
        String sql = "SELECT * FROM shule_yetu.tutors";
        List<Tutor> tutors= new ArrayList<Tutor>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = database.getDbConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("TUTOR_ID");
                int payroll = resultSet.getInt("PAYROLL_NO");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String department = resultSet.getString("DEPARTMENT");
                tutors.add(new Tutor(id, payroll, name, email, department));
            }
            ObjectMapper json = new ObjectMapper();
            response.getWriter().println(json.writeValueAsString(tutors));
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
}
