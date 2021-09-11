package org.mygroup.currencyCalculator.springSecurity.dto.noCodeAPI;
/**
 * part of dto class for getting json representation of currency exchange at NoCodeApi.
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */
public class Info {

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    private String time;
    private Double rate;

}


