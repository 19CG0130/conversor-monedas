import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BusquedaCambio {
    String address = "https://v6.exchangerate-api.com/v6/52310de60e4377a64aa7557a/pair/";

    TipoDeCambio currencyExchange(String fromCurrency, String toCurrency) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address + fromCurrency + "/" + toCurrency))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TipoDeCambio.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ocurrio un error");
        } finally {
            System.out.println("Finalizó!");
        }
    }
}
