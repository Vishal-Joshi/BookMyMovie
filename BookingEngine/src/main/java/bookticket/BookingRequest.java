package bookticket;

import org.joda.time.DateTime;

/**
 * Created by ee on 8/31/2014.
 */
public class BookingRequest {
    private int numberOfSeats;
    private DateTime showTime;
    private String movieName;
    private String multiplexName;

    public BookingRequest(int numberOfSeats, DateTime showTime){
        this.numberOfSeats=numberOfSeats;
        this.showTime=showTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public DateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(DateTime showTime) {
        this.showTime = showTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMultiplexName() {
        return multiplexName;
    }

    public void setMultiplexName(String multiplexName) {
        this.multiplexName = multiplexName;
    }
}
