package Service;

import Model.Trip;
import Repository.TripRepository;

public class TripService {
    private static TripRepository tripRepository = new TripRepository();

    public void displayAllTrips() {
        tripRepository.displayAllTrips();
    }

    public Trip getTripById(int id) {
        return tripRepository.getTripById(id);
    }

}
