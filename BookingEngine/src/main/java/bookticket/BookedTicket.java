package bookticket;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ee on 8/31/2014.
 */
public class BookedTicket implements DbEntity {
    private ObjectId bookingId;
    private DateTime bookingDateTime;
    private MovieInfo movieInfo;

    private int numberOfSeats;

    BookedTicket(DateTime bookingDateTime,MovieInfo movieInfo,int numberOfSeats){
        this.bookingDateTime=bookingDateTime;
        this.movieInfo=movieInfo;
        this.numberOfSeats=numberOfSeats;
    }

    public ObjectId getBookingId() {
        return bookingId;
    }

    public void setBookingId(ObjectId bookingId) {
        this.bookingId = bookingId;
    }

    public DateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(DateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public Map toDbMap() {
        Map dbMappings = new HashMap();
        dbMappings.put("_id",bookingId);
        dbMappings.put("bookingDateTime",bookingDateTime.toString());
        dbMappings.put("movieInfo",movieInfo.toDbObject());
        return dbMappings;
    }


    @Override
    public BasicDBObject toDbObject() {
        return new BasicDBObject(toDbMap());
    }
}
