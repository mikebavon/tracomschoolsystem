package tracom.school.unit;

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


@WebServlet(urlPatterns = {"/units"})
public class UnitAction extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String details = request.getParameter("details");

        Database database = new Database("jdbc:mysql://localhost:3306/", "shule_yetu","root", "Okello3477#*");
        database.executeQuery("insert into units(unit_id,name,code,details) values(" + (new Random()).nextInt(10000) + ",'" + name + "','" + code+ "','" + details+
                "')");

        response.getWriter().println("Saved");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        List<Unit> units = new ArrayList<Unit>();

        units.add(new Unit(1L, "MATHEMATICS", "0001", "MATHEMATICS"));
        units.add(new Unit(2L, "ENGLISH", "0002", "ENGLISH"));
        units.add(new Unit(3L, "KISWAHILI", "0003", "KISWAHILI"));
        units.add(new Unit(4L, "SCIENCE", "0004", "SCIENCE"));
        units.add(new Unit(5L, "GEOGRAPHY", "0005", "GEOGRAPHY"));

        ObjectMapper json = new ObjectMapper();
        response.getWriter().println(json.writeValueAsString(units));

    }
}
