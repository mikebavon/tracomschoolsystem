
package tracom.academy.database;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet("/create-tables")
public class CreateTablesServelet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Database database = new Database("jdbc:mysql://localhost:3306/", "shule_yetu","root", "Okello3477#*");
        database.createDatabase();
        database.createTables();
        //TODO redirect to index with SUCCESS/FAILURE message
    }
}


