package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import Enum.TripStatus;

public class FullTrip {
    private int id;
    private LocalDate tripDate;
    private TripStatus status;

    public FullTrip() {

    }

    public FullTrip(int id, LocalDate tripDate, TripStatus status) {
        this.id = id;
        this.tripDate = tripDate;
        this.status = status;

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getTripDate() {
        return tripDate;
    }
    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }
    public TripStatus getStatus() {
        return status;
    }
    public void setStatus(TripStatus status) {
        this.status = status;
    }


}
