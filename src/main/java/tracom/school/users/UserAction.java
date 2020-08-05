package tracom.school.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mindrot.jbcrypt.BCrypt;
import tracom.academy.database.Database;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = {"/users"})
public class UserAction extends HttpServlet {
    /**
     * Create new user
     * @param request
     * @param response
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Database database = new Database("jdbc:mysql://192.168.254.189:3306/", "shule_yetu","tracom", "password", true);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String password = "secret"; //TODO generate random password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        boolean isSaved = false;
        PreparedStatement statement = null;
        try{
            String insertQuery = "INSERT INTO shule_yetu.users(NAME, EMAIL, PASSWORD, ROLE) VALUES (?,?,?,?)";
            statement = database.getDbConnection().prepareStatement(insertQuery);
            database.getDbConnection().setAutoCommit(false);
            database.getDbConnection().commit();
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, hashedPassword);
            statement.setString(4, role);
            int rows = statement.executeUpdate();
            if(rows > 0) isSaved = true;
            database.getDbConnection().setAutoCommit(true);
        }catch (SQLException sqlException){
            //TODO handle exception properly
        }finally {
            try {
                if (statement != null) statement.close();
                if (database.getDbConnection() != null) database.getDbConnection().close();
                if(isSaved) response.getWriter().println("New user created");
                else response.getWriter().println("Failed to create user");
            } catch (Exception e) {
                e.printStackTrace();
                //TODO handle exception properly
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<User> users = new ArrayList<User>();
        users.add(new User(33116529, "Rufusy Idachi", "admin@app.com", "admin"));
        ObjectMapper json = new ObjectMapper();
        response.getWriter().println(json.writeValueAsString(users));
    }
}

