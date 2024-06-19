import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cambio {
    private String fromCurrency;
    private String toCurrency;
    private Double total;
    private Double newTotal;
    private String localDate;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
    public Cambio(String fromCurrency, String toCurrency, Double total, Double newTotal) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.total = total;
        this.newTotal = newTotal;
        localDate = LocalDateTime.now().format(dtf);
    }

    @Override
    public String toString() {
        return localDate + "\t\t" + String.format("%.2f", total) + " [" + fromCurrency + "] " +
                "--> " + String.format("%.2f",newTotal) + " [" + toCurrency + "]";
    }
}
