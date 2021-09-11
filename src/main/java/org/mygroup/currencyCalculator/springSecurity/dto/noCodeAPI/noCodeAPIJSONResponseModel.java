package org.mygroup.currencyCalculator.springSecurity.dto.noCodeAPI;
/**
 * part of dto class for getting json representation of currency exchange at NoCodeApi.
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */
public class noCodeAPIJSONResponseModel {

    public Info info;
    public Query query;
    private Double result;
    private String text;

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
