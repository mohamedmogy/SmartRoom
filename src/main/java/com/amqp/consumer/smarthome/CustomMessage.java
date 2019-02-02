package com.amqp.consumer.smarthome;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;

import java.sql.Timestamp;
import java.util.Date;

public class CustomMessage {
    int typeID;
    LocalDate Timestamp;
    double humidity;
    double temperature;
    String motion;

    public CustomMessage(int typeID, LocalDate timestamp, double humidity, double temperature, String motion) {
        this.typeID = typeID;
        Timestamp = timestamp;
        this.humidity = humidity;
        this.temperature = temperature;
        this.motion = motion;
    }

    public CustomMessage() {
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

    @Override
    public String toString() {
        return "CustomMessage{" +
                "typeID=" + typeID +
                ", Timestamp=" + Timestamp +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                ", motion='" + motion + '\'' +
                '}';
    }
}

