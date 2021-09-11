package org.mygroup.currencyCalculator.springSecurity.dto.noCodeAPI;
/**
 * part of dto class for getting json representation of currency exchange at NoCodeApi.
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */
public class Query {
    private String from;
    private String to;
    private Long amount;

    public String getForm() {
        return from;
    }

    public void setForm(String form) {
        this.from = form;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
