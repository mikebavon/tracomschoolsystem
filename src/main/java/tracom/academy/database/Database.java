package tracom.academy.database;

import java.sql.*;
import java.util.ArrayList;


/**
 * Connect to the database, create database/tables and handle CRUD operations.
 */
public class Database {
    private String url;
    private String database;
    private String userName;
    private String password;
    private boolean dbExists;
    private Connection dbConnection;
    private ArrayList<String> stringData=new ArrayList<String>();
    private ArrayList<Integer> integerData = new ArrayList<Integer>();

    /** SQL statements to create tables */
    private final String CREATE_TABLE_STUDENTS_SQL="CREATE TABLE IF NOT EXISTS students ("
            + "STUDENT_ID int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "EMAIL VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (STUDENT_ID))";

    private final String CREATE_TABLE_TUTORS_SQL="CREATE TABLE IF NOT EXISTS tutors ("
            + "TUTOR_ID int(11) NOT NULL,"
            + "PAYROLL_NO int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "EMAIL VARCHAR(45) NOT NULL,"
            + "DEPARTMENT VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (TUTOR_ID))";

    private final String CREATE_TABLE_COURSES_SQL="CREATE TABLE IF NOT EXISTS courses ("
            + "COURSE_ID int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (COURSE_ID))";

    private final String CREATE_TABLE_UNITS_SQL = "CREATE TABLE IF NOT EXISTS units ("
            + "UNIT_ID int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "CODE VARCHAR(45) NOT NULL,"
            + "DETAILS VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (UNIT_ID))";

    private final String CREATE_TABLE_DEPARTMENTS_SQL="CREATE TABLE IF NOT EXISTS departments ("
            + "DEPT_ID int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "HOD VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (DEPT_ID))";

    private final String CREATE_TABLE_INSTITUTIONS_SQL="CREATE TABLE IF NOT EXISTS institutions ("
            + "INSTITUTION_ID int(11) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "ADDRESS VARCHAR(45) NOT NULL,"
            + "LOCATION VARCHAR(45) NOT NULL,"
            + "TYPE VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (INSTITUTION_ID))";

    private final String CREATE_TABLE_FACULTY_SQL="CREATE TABLE IF NOT EXISTS faculties ("
            + "FACULTY_ID int(11) NOT NULL,"
            + "TITLE VARCHAR(45) NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "INSTITUTION VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (FACULTY_ID))";

    private final String CREATE_TABLE_USERS_SQL="CREATE TABLE IF NOT EXISTS users ("
            + "USER_ID int(11) NOT NULL AUTO_INCREMENT,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "EMAIL VARCHAR(45) NOT NULL,"
            + "PASSWORD VARCHAR(255) NOT NULL,"
            + "ROLE VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (USER_ID))";

    private final String[] createTablesSql= {
            this.CREATE_TABLE_COURSES_SQL,
            this.CREATE_TABLE_UNITS_SQL,
            this.CREATE_TABLE_DEPARTMENTS_SQL,
            this.CREATE_TABLE_FACULTY_SQL,
            this.CREATE_TABLE_INSTITUTIONS_SQL,
            this.CREATE_TABLE_STUDENTS_SQL,
            this.CREATE_TABLE_TUTORS_SQL,
            this.CREATE_TABLE_USERS_SQL
    };

    /**
     * Establish the connection to the database server/database.
     * Set @param dbExists to TRUE if connecting to an existing database on the server,
     * Set to FALSE if connecting to the server to create a new database.
     * @param url
     * @param database database name to be created
     * @param userName database server user name
     * @param password database server user password
     * @param dbExists TRUE if database exists. Else FALSE
     */
    public Database(String url, String database, String userName, String password, boolean dbExists) {
        this.url = url;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.dbExists = dbExists;
        try {
            if(this.dbExists)
                this.dbConnection = DriverManager.getConnection(this.url + this.database, this.userName, this.password);
            else
                this.dbConnection = DriverManager.getConnection(this.url , this.userName, this.password);
        } catch (SQLException sqlException) {
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
     * Create a new database.
     */
    public void createDatabase(){
        PreparedStatement statement = null;
        try{
            statement = this.dbConnection.prepareStatement("CREATE DATABASE IF NOT EXISTS " + this.database);
            statement.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            //TODO handle exception properly
        }finally {
            try {
                if (statement != null) statement.close();
                if (this.dbConnection != null) this.dbConnection.close();
            } catch (Exception e) {
                e.printStackTrace();
                //TODO handle exception properly
            }
        }
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
                if (this.dbConnection != null) this.dbConnection.close();
            } catch (Exception e) {
                e.printStackTrace();
                //TODO handle exception properly
            }
        }
    }

    public void executeQuery(String sql){

        PreparedStatement statement = null;
        try {
            Connection dbConnection = DriverManager.getConnection(this.url + this.database, this.userName, this.password);
            statement = dbConnection.prepareStatement(sql);
            statement.executeUpdate();


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

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.url+this.database, this.userName, this.password);
            System.out.println("Connected to the DB server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Exiting...");
        }
        return conn;
    }
}
