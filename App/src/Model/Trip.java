package Model;

public class Trip {
    private int id;
    private String from;
    private String to;

    public Trip() {

    }

    public Trip(int id, String from, String to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }

    public String toString() {
        return "Trip [id=" + id + ", from=" + from + ", to=" + to + "]";
    }

}
