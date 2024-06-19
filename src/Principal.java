import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<Cambio> cambios = new ArrayList<>();
        int exit = 0;
        Scanner scanner = new Scanner(System.in);

        while (exit != 1) {
            String menu = """
                    *****************************************
                    Sea bienvenido/a al Conversor de Moneda
                                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    Elija una opción válida:
                    *****************************************
                    """;
            System.out.println(menu);

            try {
                int exchangeOption = Integer.parseInt(scanner.nextLine());

                String fromCurrency;
                String toCurrency;
                switch (exchangeOption) {
                    case 1:
                        fromCurrency = "USD";
                        toCurrency = "ARS";
                        break;
                    case 2:
                        fromCurrency = "ARS";
                        toCurrency = "USD";
                        break;
                    case 3:
                        fromCurrency = "USD";
                        toCurrency = "BRL";
                        break;
                    case 4:
                        fromCurrency = "BRL";
                        toCurrency = "USD";
                        break;
                    case 5:
                        fromCurrency = "USD";
                        toCurrency = "COP";
                        break;
                    case 6:
                        fromCurrency = "COP";
                        toCurrency = "USD";
                        break;
                    case 7:
                        exit = 1;
                        fromCurrency = null;
                        toCurrency = null;
                        break;
                    default:
                        fromCurrency = null;
                        toCurrency = null;
                        break;
                }

                if (exchangeOption >=1 && exchangeOption <= 6) {
                    BusquedaCambio request = new BusquedaCambio();
                    TipoDeCambio exchangeRate = request.currencyExchange(fromCurrency, toCurrency);

                    System.out.println("El tipo de cambio actual es: " + exchangeRate.conversion_rate());

                    System.out.println("Ingrese el valor que deseas convertir: ");
                    Double total = Double.valueOf(scanner.nextLine());

                    double newTotal = total * exchangeRate.conversion_rate();

                    System.out.println("El cambio " +
                            total +
                            " [" + fromCurrency + "]" +
                            " corresponde al valor final de =>>> " +
                            newTotal +
                            " [" + toCurrency + "]");

                    Cambio cambio = new Cambio(fromCurrency,toCurrency,total,newTotal);
                    cambios.add(cambio);
                } else if (exchangeOption == 7) {
                    System.out.println("Gracias por usar nuestro sistema de cambio!\n");
                } else {
                    System.out.println("La opcion (" + exchangeOption + ") es invalida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("La opcion " + e.getMessage().toLowerCase() + ", es invalida!");
            }
        }
    }
}
