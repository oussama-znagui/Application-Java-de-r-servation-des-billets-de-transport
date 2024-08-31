package Config;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dbconnexion {
    public static Connection con = null;
    public static void Dbconnexion() {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/travel_reservation";
        String username = "postgres";
        String password = "Azerty";




        try {
            Class.forName("org.postgresql.Driver");

             con = DriverManager.getConnection(jdbcUrl, username, password);

            if (con != null) {
                System.out.println("bravoo.");
            } else {
                System.out.println("nooo");
            }

        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.getMessage());

        }
    }

    public static  Connection getConnection() {
        if (con == null) {
            Dbconnexion();
            return con;
        }else {
            return con;
        }
    }
}

