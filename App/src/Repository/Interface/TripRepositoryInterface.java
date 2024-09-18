package Repository.Interface;

import Model.Trip;

import java.util.List;

public interface TripRepositoryInterface {
    public List<Trip> getAllTrips();
    public void displayAllTrips();
    public Trip getTripById(int id);
}
