package bookticket;

import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.Mongo;
import junit.framework.TestCase;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MultiplexDetailsRepositoryTest {
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
        List<MultiplexDetails.Screen> listOfScreens = new ArrayList<MultiplexDetails.Screen>();
        MultiplexDetails multiplexDetails = new MultiplexDetails("Cinemax","In Orbit Mall",listOfScreens);
        MultiplexDetails.Screen screen = multiplexDetails.new Screen(50,"A1");
        listOfScreens.add(screen);
        MultiplexDetailsRepository repository = new MultiplexDetailsRepository(db);

        //When
        ObjectId multiplexId = repository.save(multiplexDetails);

        //Then
        Assert.assertNotNull(multiplexId);
    }

    @Test
    public void testFindById() throws Exception {
        //Given
        MultiplexDetailsRepository repository = new MultiplexDetailsRepository(db);


        MultiplexDetails multiplexDetails = repository.findById(ObjectId.get());

        //Then
        Assert.assertNotNull(multiplexDetails);
    }
}