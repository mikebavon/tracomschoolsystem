package tracom.school.student;

import tracom.academy.database.HibernateHelper;
import org.hibernate.Transaction;
import org.hibernate.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = { "/student" })
public class StudentAction extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            Student student = new Student();
            int id = Integer.parseInt(request.getParameter("sid"));
            String name = request.getParameter("sname");
            String email = request.getParameter("semail");
            student.setId(id);
            student.setName(name);
            student.setEmail(email);
            session.save(student);
            response.getWriter().println("Data saved successfully!!");
            tx.commit();
        }catch (Exception e){
            // TODO: handle exception properly
            response.getWriter().println("An error has occurred");
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            List<Student> students = session.createQuery("From Student r").getResultList();
            //List<Student> students = session.createCriteria(Student.class).list();
            ObjectMapper json = new ObjectMapper();
            response.getWriter().println(json.writeValueAsString(students));
            tx.commit();
        }catch (Exception e){
            // TODO: handle exception properly
            response.getWriter().println("An error has occurred");
            e.printStackTrace();
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            Student student = session.get(Student.class, Integer.parseInt(id));
            session.delete(student);
            response.getWriter().println("Data deleted Successfully!!");
            tx.commit();
        }catch (Exception e){
            // TODO: handle exception properly
            response.getWriter().println("An error has occurred");
            e.printStackTrace();
        }
    }
}
