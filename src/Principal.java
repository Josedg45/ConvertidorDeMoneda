
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("""
                    ****************************
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    ****************************
                    Elija una opción válida:
                    """);

            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                double valor = scanner.nextDouble();


                Moneda moneda = consulta.BuscaMoneda("USD");
                Map<String, Double> tasas = moneda.conversion_rates();

                double resultado = 0;

                switch (opcion) {
                    case 1 -> resultado = valor * tasas.get("ARS");  // USD a ARS
                    case 2 -> resultado = valor / tasas.get("ARS");  // ARS a USD
                    case 3 -> resultado = valor * tasas.get("BRL");  // USD a BRL
                    case 4 -> resultado = valor / tasas.get("BRL");  // BRL a USD
                    case 5 -> resultado = valor * tasas.get("COP");  // USD a COP
                    case 6 -> resultado = valor / tasas.get("COP");  // COP a USD
                }

                System.out.println("Resultado: " + resultado);
            } else if (opcion == 7) {
                System.out.println("Gracias por usar el conversor.");
            } else {
                System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}

