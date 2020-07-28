package tracom.academy.database;

import java.sql.*;

/**
 * Connect to the database, create tables and handle CRUD operations.
 */
public class Database {
    private String url;
    private String database;
    private String userName;
    private String password;
    private Connection dbConnection;

    /** SQL statements to create tables */
    private final String CREATE_TABLE_STUDENTS_SQL="CREATE TABLE students ("
            + "STUDENT_ID int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "EMAIL VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (STUDENT_ID))";

    private final String CREATE_TABLE_TUTORS_SQL="CREATE TABLE tutors ("
            + "TUTOR_ID int(11) NOT NULL,"
            + "PAYROLL_NO int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "EMAIL VARCHAR(45) NOT NULL,"
            + "DEPARTMENT VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (TUTOR_ID))";

    private final String CREATE_TABLE_COURSES_SQL="CREATE TABLE courses ("
            + "COURSE_ID int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (COURSE_ID))";

    private final String CREATE_TABLE_DEPARTMENTS_SQL="CREATE TABLE departments ("
            + "DEPT_ID int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "HOD VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (DEPT_ID))";

    private final String CREATE_TABLE_INSTITUTIONS_SQL="CREATE TABLE institutions ("
            + "INSTITUTION_ID int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "ADDRESS VARCHAR(45) NOT NULL,"
            + "LOCATION VARCHAR(45) NOT NULL,"
            + "TYPE VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (INSTITUTION_ID))";

    private final String CREATE_TABLE_FACULTY_SQL="CREATE TABLE faculties ("
            + "FACULTY_ID int(11) NOT NULL,"
            + "TITLE VARCHAR(45) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "INSTITUTION VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (FACULTY_ID))";

    private final String[] createTablesSql= {
            this.CREATE_TABLE_COURSES_SQL,
            this.CREATE_TABLE_DEPARTMENTS_SQL,
            this.CREATE_TABLE_FACULTY_SQL,
            this.CREATE_TABLE_INSTITUTIONS_SQL,
            this.CREATE_TABLE_STUDENTS_SQL,
            this.CREATE_TABLE_TUTORS_SQL
    };


    /**
     * Connect to the database
     * @param url
     * @param database
     * @param userName
     * @param password
     */
    public Database(String url, String database, String userName, String password) {
        this.url = url;
        this.database = database;
        this.userName = userName;
        this.password = password;


    }
    public void createDatabase(){
        try{
            Connection dbConnection = DriverManager.getConnection(this.url, this.userName, this.password);
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate("create database if not exists " + this.database);

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            //TODO handle exception properly
        }
    }


    /**
     * @return database connection.
     */
    public Connection getDbConnection(){
        return this.dbConnection;
    }


    /**
     * Create tables in the database.
     */
    public void createTables() {
        PreparedStatement statement = null;
        try {
            for (String sql : this.createTablesSql) {
                statement = this.dbConnection.prepareStatement(sql);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO handle exception properly
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
                e.printStackTrace();
                //TODO handle exception properly
            }
        }
    }

}


