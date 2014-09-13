package bookticket;

import org.bson.types.ObjectId;

/**
 * Created by ee on 9/1/2014.
 */
public interface BookingService {

    ObjectId bookTicket(BookingRequest bookingRequest);
}
