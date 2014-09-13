package bookticket;

import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.Mongo;
import junit.framework.TestCase;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class BookedTicketRepositoryTest {
    private DB db;

    @Before
    public void setUp() throws Exception {
        Mongo mongo;
        try {
            mongo = new Mongo(new DBAddress("127.0.0.1", 27017,"MovieBookings"));
            db = mongo.getDB( "MovieBookings" );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSave() throws Exception {
        //Given
        BookedTicketRepository bookedTicketRepository = new BookedTicketRepository(db);
        DateTime movieTime = new DateTime(2014,9,2,12,0,0,0);
        List<MultiplexDetails.Screen> listOfScreens = new ArrayList<MultiplexDetails.Screen>();
        MultiplexDetails multiplexDetails = new MultiplexDetails("PVR","Phoenix Mall",listOfScreens);
        MultiplexDetails.Screen screenAlpha = multiplexDetails.new Screen(50,"Alpha");

        listOfScreens.add(screenAlpha);
        MovieInfo movieInfo = new MovieInfo("Hangover",multiplexDetails,movieTime);
        int numberOfSeats = 2;
        BookedTicket bookedTicket = new BookedTicket(movieTime,movieInfo,numberOfSeats);

        //When
        ObjectId bookedTicketId = bookedTicketRepository.save(bookedTicket);

        //Then
        Assert.assertNotNull(bookedTicketId);


    }
}