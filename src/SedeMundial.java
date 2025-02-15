import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SedeMundial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int votosTotales;

        while (true) {
            try {
                votosTotales = Integer.parseInt(sc.nextLine());

                if (votosTotales == 0) {
                    break;
                }

                String paisesTotales = sc.nextLine();

                if (paisesTotales.trim().isEmpty()) {
                    System.out.println("No se han ingresado países. Intenta nuevamente.");
                    continue;
                }

                String[] paises = paisesTotales.split(" ");


                Map<String, Integer> mapaPaises = new LinkedHashMap<>();

                for (String paise : paises) {
                    if (!mapaPaises.containsKey(paise)) {
                        mapaPaises.put(paise, 1);
                    } else{
                        mapaPaises.put(paise, mapaPaises.get(paise) + 1);
                    }
                }


                String paisMaxVoto = "";
                int maxVoto = -1;
                boolean empate = false;

                for (Map.Entry<String, Integer> entry : mapaPaises.entrySet()) {
                    if (entry.getValue() > maxVoto) {
                        maxVoto = entry.getValue();
                        paisMaxVoto = entry.getKey();
                        empate = false;
                    } else if (entry.getValue() == maxVoto) {
                        empate = true;
                    }
                }


                if (empate) {
                    System.out.println("EMPATE");
                } else {
                    System.out.println(paisMaxVoto);
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida para el número de votos. Intenta nuevamente.");
            }
        }
        sc.close();
    }
}
