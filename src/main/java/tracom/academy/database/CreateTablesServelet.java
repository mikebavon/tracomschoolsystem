
package tracom.academy.database;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet("/create-tables")
public class CreateTablesServelet extends HttpServlet{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Database database = new Database("jdbc:mysql://localhost:3306/", "shule_yetu","root", "");
        database.createDatabase();
        database.createTables();
       
    }
}


