package bookticket;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ee on 8/31/2014.
 */
public class MultiplexDetails implements DbEntity{
    private ObjectId id;
    private String multiplexName;
    private String address;
    private List<Screen> listOfScreens;

    public MultiplexDetails(String multiplexName,String address, List<Screen> listOfScreens){
        this.multiplexName = multiplexName;
        this.address = address;
        this.listOfScreens = listOfScreens;
    }

    public String getMultiplexName() {
        return multiplexName;
    }

    public void setMultiplexName(String multiplexName) {
        this.multiplexName = multiplexName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Screen> getListOfScreens() {
        return listOfScreens;
    }

    public void setListOfScreens(List<Screen> listOfScreens) {
        this.listOfScreens = listOfScreens;
    }

    @Override
    public BasicDBObject toDbObject() {
        return new BasicDBObject(toDbMap());
    }

    @Override
    public Map toDbMap() {
        Map dbMappings = new HashMap();
        dbMappings.put("_id",id);
        dbMappings.put("multiplexName",multiplexName);
        dbMappings.put("address",address);
        dbMappings.put("listOfScreens",getDBListOfScreens());
        return dbMappings;
    }

    private BasicDBList getDBListOfScreens(){
        BasicDBList dbListOfScreens = new BasicDBList();
        for (int i=0;i<listOfScreens.size();i++) {
            dbListOfScreens.put(String.valueOf(i),listOfScreens.get(i).toDbMap());
        }
        return dbListOfScreens;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId(){
        return id;
    }

    class Screen implements DbEntity {
        private ObjectId id;
        private int totalNumberOfSeats;
        private List<Integer> bookedSeats;
        private String screenName;

        Screen(int totalNumberOfSeats, String screenName){
            this.totalNumberOfSeats = totalNumberOfSeats;
            this.screenName = screenName;
        }

        public int getTotalNumberOfSeats() {
            return totalNumberOfSeats;
        }

        public void setTotalNumberOfSeats(int totalNumberOfSeats) {
            this.totalNumberOfSeats = totalNumberOfSeats;
        }

        public String getScreenName() {
            return screenName;
        }

        public void setScreenName(String screenName) {
            this.screenName = screenName;
        }

        public List<Integer> getBookedSeats() {
            return bookedSeats;
        }

        public void setBookedSeats(List<Integer> bookedSeats) {
            this.bookedSeats = bookedSeats;
        }

        @Override
        public BasicDBObject toDbObject() {
            return new BasicDBObject(toDbMap());
        }

        @Override
        public Map toDbMap() {
            Map dbMap= new HashMap();
            dbMap.put("id",id);
            dbMap.put("totalNumberOfSeats",totalNumberOfSeats);
            dbMap.put("screenName",screenName);
            dbMap.put("bookedSeats",bookedSeats);
            return dbMap;
        }

        private BasicDBList getDbListOfBookedLists(){
            BasicDBList dbListOfBookedSeats= new BasicDBList();
            for(int index=0;index<bookedSeats.size();index++){
                dbListOfBookedSeats.put(String.valueOf(index),bookedSeats.get(index));
            }
            return dbListOfBookedSeats;
        }

        public ObjectId getId() {
            return id;
        }

        public void setId(ObjectId id) {
            this.id = id;
        }
    }
}

