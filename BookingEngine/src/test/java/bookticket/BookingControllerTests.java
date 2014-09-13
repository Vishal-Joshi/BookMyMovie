package bookticket;

import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.net.UnknownHostException;


/**
 * Created by ee on 9/1/2014.
 */
public class BookingControllerTests {

    @Test
    public void testShouldBookTicketForABookingRequest(){
        //Given
        Mongo mongo = null;
        try {
            mongo = new Mongo(new DBAddress("127.0.0.1", 27017,"MovieBookings"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DB db = mongo.getDB( "MovieBookings" );
        BookingRequest bookingRequest = new BookingRequest(2, new DateTime(2014,10,01,0,0,0));
        BookingController bookingController = new BookingController(new BookingServiceImpl(bookingRequest,
                                                                                           new BookedTicketRepository(db),
                                                                                           new MultiplexDetailsRepository(db)));

        //When
        ObjectId bookedTicket = bookingController.bookTicket(bookingRequest);

        //Then
        Assert.assertNotNull(bookedTicket);
    }

}
