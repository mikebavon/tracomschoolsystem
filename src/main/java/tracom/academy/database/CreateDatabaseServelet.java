package tracom.academy.database;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-db")
public class CreateDatabaseServelet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Database database = new Database("jdbc:mysql://localhost:3306/","shule_yetu","root", "password1234", false);
        database.createDatabase();
        //TODO redirect to index with SUCCESS/FAILURE message
    }
}


