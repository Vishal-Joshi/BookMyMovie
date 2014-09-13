package bookticket;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ee on 9/1/2014.
 */
public class BookingServiceImpl implements BookingService {

    private BookingRequest bookingRequest;
    private BookedTicketRepository bookingRepository;
    private MultiplexDetailsRepository multiplexDetailsRepository;

    BookingServiceImpl(BookingRequest bookingRequest,
                       BookedTicketRepository bookingRepository,
                       MultiplexDetailsRepository multiplexDetailsRepository) {
        this.bookingRequest = bookingRequest;
        this.bookingRepository = bookingRepository;
        this.multiplexDetailsRepository = multiplexDetailsRepository;
    }

    @Override
    public ObjectId bookTicket(BookingRequest bookingRequest) {
        List<MultiplexDetails.Screen> listOfScreens = new ArrayList<MultiplexDetails.Screen>();
        MultiplexDetails multiplexDetails = new MultiplexDetails("PVR","Phoenix Mall",listOfScreens);
        MultiplexDetails.Screen screenAlpha = multiplexDetails.new Screen(50,"Alpha");

        listOfScreens.add(screenAlpha);
        return bookingRepository.save(new BookedTicket(bookingRequest.getShowTime(),
                                                       new MovieInfo(bookingRequest.getMovieName(),
                                                                     multiplexDetails,
                                                                     bookingRequest.getShowTime()),
                                                       2));
    }
}
