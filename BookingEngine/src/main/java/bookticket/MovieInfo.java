package bookticket;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ee on 8/31/2014.
 */
public class MovieInfo implements DbEntity {
    ObjectId movieId;
    private String movieName;
    private MultiplexDetails multiplexDetails;
    private DateTime movieShowTime;

    public MovieInfo(String movieName, MultiplexDetails multiplexDetails,DateTime movieShowTime){
        this.movieName = movieName;
        this.multiplexDetails = multiplexDetails;
        this.movieShowTime = movieShowTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public BasicDBObject toDbObject() {
        return new BasicDBObject(toDbMap());
    }

    @Override
    public Map toDbMap() {
        Map dbMappings = new HashMap();
        dbMappings.put("_id",movieId);
        dbMappings.put("movieName",movieName);
        dbMappings.put("movieShowTime",movieShowTime.toString());
        dbMappings.put("multiplexDetails",multiplexDetails.toDbObject());
        return dbMappings;
    }

    public MultiplexDetails getMultiplexDetails() {
        return multiplexDetails;
    }

    public void setMultiplexDetails(MultiplexDetails multiplexDetails) {
        this.multiplexDetails = multiplexDetails;
    }

    public DateTime getMovieShowTime() {
        return movieShowTime;
    }

    public void setMovieShowTime(DateTime movieShowTime) {
        this.movieShowTime = movieShowTime;
    }
}
