package bookticket;

import com.mongodb.BasicDBObject;

import java.util.Map;

/**
 * Created by ee on 9/1/2014.
 */
public interface DbEntity {

    BasicDBObject toDbObject();
    Map toDbMap();
}
