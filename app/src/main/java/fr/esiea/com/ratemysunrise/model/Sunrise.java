package fr.esiea.com.ratemysunrise.model;

import java.util.Date;

/**
 * Created by albert on 04/11/14.
 */
public class Sunrise {

    String id;
    String imageUrl;
    Date dateUpload;
    String city;
    String country;

    public Sunrise(String id, String imageUrl, Date dateUpload, String city, String country) {
        this.country = country;
        this.id = id;
        this.imageUrl = imageUrl;
        this.dateUpload = dateUpload;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(Date dateUpload) {
        this.dateUpload = dateUpload;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Sunrise{" +
                "id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", dateUpload=" + dateUpload +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
