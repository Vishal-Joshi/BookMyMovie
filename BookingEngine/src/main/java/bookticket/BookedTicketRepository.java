package bookticket;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/**
 * Created by ee on 9/1/2014.
 */
@Repository
public class BookedTicketRepository implements bookticket.Repository<BookedTicket,ObjectId>{

    private DBCollection collection;

    public BookedTicketRepository(DB db){
        this.collection = db.getCollection("bookedTickets");
    }

    @Override
    public BookedTicket findById(ObjectId objectId) {
        return null;
    }

    @Override
    public BookedTicket find(Map query) {
        return null;
    }

    @Override
    public void insert(List<BookedTicket> entities) {

    }

    @Override
    public ObjectId save(BookedTicket entity) {
        if (entity.getBookingId()==null) {
            entity.setBookingId(createId());
        }
        try {
            collection.save(entity.toDbObject());
        } catch (MongoException.DuplicateKey e) {
            throw new RuntimeException("Attempting to store an entity that already exists", e);
        }

        return entity.getBookingId();
    }

    @Override
    public void update(BookedTicket entity, Map forUpdate) {

    }

    protected ObjectId createId() {
        return ObjectId.get();
    }

}
