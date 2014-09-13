package bookticket;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

/**
 * Created by ee on 9/4/2014.
 */
public class MultiplexDetailsRepository implements Repository<MultiplexDetails,ObjectId> {

    private DBCollection collection;

    public MultiplexDetailsRepository(DB db){
        this.collection = db.getCollection("multiplexDetails");
    }
    @Override
    public MultiplexDetails findById(ObjectId objectId) {
        BasicDBObject dbObejct = new BasicDBObject();
        dbObejct.put("_id",objectId);
        DBObject multiplexDbObjects = collection.find(dbObejct).toArray().get(0);

        BasicDBList screensDbList = (BasicDBList)multiplexDbObjects.get("listOfScreens");
        List<BasicDBObject> basicDBObjectList= screensDbList.toArray();
        MultiplexDetails multiplexDetails = new MultiplexDetails(multiplexDbObjects.get("multiplexName").toString(),
                multiplexDbObjects.get("address").toString(),multiplexDbObjects.get("listOfScreens").);
        return null;
    }

    @Override
    public MultiplexDetails find(Map query) {
        return null;
    }

    @Override
    public void insert(List<MultiplexDetails> entities) {

    }

    @Override
    public ObjectId save(MultiplexDetails entity) {
        if(entity.getId()==null){
            entity.setId(createId());
        }

        try {
            collection.save(entity.toDbObject());
        } catch (MongoException.DuplicateKey e) {
            throw new RuntimeException("Attempting to store an entity that already exists", e);
        }
        return entity.getId();
    }

    @Override
    public void update(MultiplexDetails entity, Map forUpdate) {

    }

    private ObjectId createId(){
        return ObjectId.get();
    }

    class ScreenRepository implements Repository<MultiplexDetails.Screen,ObjectId> {

        private DBCollection collection;

        public ScreenRepository(DB db){
            this.collection = db.getCollection("screens");
        }

        @Override
        public MultiplexDetails.Screen findById(ObjectId objectId) {
            return null;
        }

        @Override
        public MultiplexDetails.Screen find(Map query) {
            return null;
        }

        @Override
        public void insert(List<MultiplexDetails.Screen> entities) {

        }

        @Override
        public ObjectId save(MultiplexDetails.Screen entity) {
            if(entity.getId()==null){
                entity.setId(createId());
            }

            try {
                collection.save(entity.toDbObject());
            }
            catch (MongoException.DuplicateKey e) {
                throw new RuntimeException("Attempting to store an entity that already exists", e);
            }
            return entity.getId();
        }

        @Override
        public void update(MultiplexDetails.Screen entity, Map forUpdate) {

        }

        private ObjectId createId(){
            return ObjectId.get();
        }
    }
}
