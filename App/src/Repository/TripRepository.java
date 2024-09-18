package Repository;

import Config.Dbconnexion;
import Model.Trip;
import Repository.Interface.TripRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripRepository implements TripRepositoryInterface {
    private static Connection conn = Dbconnexion.getConnection();

    public List<Trip> getAllTrips(){
        List<Trip> trips = new ArrayList<Trip>();
        conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from trips";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Trip trip = new Trip();
                trip.setId(rs.getInt("id"));
                trip.setFrom(rs.getString("t_from"));
                trip.setTo(rs.getString("t_to"));
                trips.add(trip);
            }
            return trips;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayAllTrips(){
        List<Trip> trips = getAllTrips();
        for(Trip trip : trips){
            System.out.println(trip);
        }
    }

    public Trip getTripById(int id){
        Trip trip = null;
        conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from trips where id = ?";
            ps  = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                trip = new Trip();
                trip.setId(rs.getInt("id"));
                trip.setFrom(rs.getString("t_from"));
                trip.setTo(rs.getString("t_to"));
                return trip;
            }else{
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
