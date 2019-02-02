package com.amqp.consumer.smarthome.smar_db;

import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class myEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    int typeID;
    LocalDate Timestamp;
    double humidity;
    double temperature;
    String motion;

    public myEntity() {
    }

    public myEntity(int typeID, LocalDate timestamp, double humidity, double temperature, String motion) {
        this.typeID = typeID;
        Timestamp = timestamp;
        this.humidity = humidity;
        this.temperature = temperature;
        this.motion = motion;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public LocalDate getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        Timestamp = timestamp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getMotion() {
        return motion;
    }

    public void setMotion(String motion) {
        this.motion = motion;
    }
}
