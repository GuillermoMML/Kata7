package com.mycompany.kata7;

import com.google.gson.Gson;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.flight;

/**
 *
 * @author Guillermo
 */
class FlightApp {

    static String url = "jdbc:sqlite:H:\\SQLiteDatabaseBrowserPortable\\Data\\flights.db";

    public FlightApp() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FlightApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        connect();
    }
  
    public static Connection connect() {
// SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public String getAll() {
        String sql = "SELECT * FROM flights";
        return this.getDataFromSql(sql);
    }

    public String getDay(String day) {
        String sql = "SELECT * FROM flights WHERE DAY_OF_WEEK=" + this.getNumberOfDay(day);
        return this.getDataFromSql(sql);
    }

    public String getBiggerDistance(String distance) {
        String sql = "SELECT * FROM flights WHERE DISTANCE >=" + distance;
        return this.getDataFromSql(sql);
    }

    public String getLowerDistance(String distance) {
        String sql = "SELECT * FROM flights WHERE DISTANCE <=" + distance;
        return this.getDataFromSql(sql);
    }

    public String getCancelled() {
        String sql = "SELECT * FROM flights WHERE CANCELLED =1";
        return this.getDataFromSql(sql);
    }

    public String getDiverted() {
        String sql = "SELECT * FROM flights WHERE DIVERTED=1";
        return this.getDataFromSql(sql);

    }

    public String getDataFromSql(String sql) {
        List<flight> flights = null;
        try (Connection conn = this.connect(); java.sql.Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            flights = this.resultSetToList(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return this.serializeList(flights);
    }

    private String serializeList(List<flight> flights) {
        return new Gson().toJson(flights);
    }

    private String getNumberOfDay(String day) {
        String sql = "SELECT * FROM flights WHERE DIVERTED=1";
        return this.getDataFromSql(sql);
    }

    private List<flight> resultSetToList(ResultSet rs) throws SQLException {
        List<flight> flights = new ArrayList<>();
        while (rs.next()) {
            flights.add(new flight(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getInt(9))
            );
        }
        return flights;
    }

}
