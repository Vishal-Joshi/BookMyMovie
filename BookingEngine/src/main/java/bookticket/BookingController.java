package bookticket;

import org.bson.types.ObjectId;

/**
 * Created by ee on 8/30/2014.
 */
public class BookingController {

    private BookingService bookingService;
    public BookingController(BookingServiceImpl bookingService){
        this.bookingService = bookingService;
    }

    public ObjectId bookTicket(BookingRequest bookingRequest){

        return bookingService.bookTicket(bookingRequest);
    }
}
