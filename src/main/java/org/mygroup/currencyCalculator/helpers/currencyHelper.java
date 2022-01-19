package org.mygroup.currencyCalculator.helpers;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.mygroup.currencyCalculator.enums.Currency;
import org.mygroup.currencyCalculator.models.currencyRate;
import org.mygroup.currencyCalculator.springSecurity.dto.noCodeAPI.noCodeAPIJSONResponseModel;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.*;

/**
 * This class contains static helper-methods for currency exchange calculating.
 *
 * @author  Samvel Ghazaryan
 * @version 1.0
 * */
public class currencyHelper
{
    public static Double getRateFromWeb(Currency base, Currency converting) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v1.nocodeapi.com/mnogolikyi/cx/YxUuTpAApONWfPQu/rates/convert?amount=5000&from=" + base.name() + "&to=" + converting.name()))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        noCodeAPIJSONResponseModel model = getParsedJsonObject(response.body());
        Double result = model.info.getRate();
        return result;
    }

    private static noCodeAPIJSONResponseModel getParsedJsonObject(String jsonString) {
        Gson g = new Gson();
        noCodeAPIJSONResponseModel model = new noCodeAPIJSONResponseModel();
        try {
            model = g.fromJson(jsonString, noCodeAPIJSONResponseModel.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return model;
    }

    public static List<currencyRate> getCurrencyRates() throws IOException, InterruptedException {

        List<currencyRate> currencyRates = new ArrayList<>();
        Currency[] currencies = Currency.values();
        Long id = 0L;
        for (int i = 0; i < currencies.length ; i++) {
            for (int j = 0; j < currencies.length; j++) {
                if (i==j)
                    continue;
                LocalDateTime dt = LocalDateTime.now();
                currencyRates.add(
                        new currencyRate(id++,currencies[i], currencies[j],getRateFromWeb(currencies[i], currencies[j]), dt));
            }
        }
        return currencyRates;

    }
}

