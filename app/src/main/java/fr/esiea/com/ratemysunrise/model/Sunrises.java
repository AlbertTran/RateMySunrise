package fr.esiea.com.ratemysunrise.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by albert on 04/11/14.
 */
public class Sunrises {

    private static Sunrises instance;
    public static Sunrises getInstance() {
        if (instance == null) {
            instance = new Sunrises();
            instance.init();
        }
        return instance;
    }

    Map<String,Sunrise> lstPhotos = new HashMap<String,Sunrise>();
    private Sunrises(){

    }

    public void addSunrise (Sunrise photo){
        if (!lstPhotos.containsKey(photo.getId())){
            lstPhotos.put(photo.getId(), photo);
        }
    }

    public ArrayList<Sunrise> getlstPhotos(){
        return new ArrayList(lstPhotos.values());
    }

    public Sunrise getSunriseById (String id){
        return lstPhotos.get(id);
    }

    private void init(){
        addSunrise(new Sunrise("1","http://google.fr",new Date(),"Paris", "France"));

    }

}
