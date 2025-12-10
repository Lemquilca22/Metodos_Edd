import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class ahorcado {
    //Metodo para trycatch
    public static void trycatch(char letra) {
        Scanner sc = new Scanner(System.in);
        boolean trycat = true;
        while (trycat) {
            try {
                letra = sc.next().charAt(0);

            } catch (Exception e) {

            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String [] palabra = {"ballena","ornitorrinco","guepardo","gacela","elefante","jirafa","hiena"};
        char letra;
        boolean main = true;

        while (main) {
            int vida = 5;
            int numaleatorio = random.nextInt(7);
            System.out.println("Bienvenido a ahorcado, vamos a jugar!");
            System.out.println("Tienes " + vida + " vidas");
            String s = palabra[numaleatorio];
            char[] charpalabra = s.toCharArray();
            char[] ahorcado = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                ahorcado[i] = '_';
                System.out.print(ahorcado[i]);
            }
            boolean partida = true;
            while (partida) {
                int frecuencia = 0;
                System.out.println();
                System.out.println("Ingresa una letra: ");
                letra = sc.next().charAt(0);

                for (int i = 0; i < s.length(); i++) {

                    if (letra == charpalabra[i]) {
                        char remplazo = charpalabra[i];
                        ahorcado[i] = remplazo;
                        frecuencia++;
                    }
                }
                if (frecuencia > 0) {
                    System.out.println("Bien hecho");
                } else {
                    vida--;
                    System.out.println("Te restan " + vida + " vidas");
                }
                for (int j = 0; j < s.length(); j++) {
                    System.out.print(ahorcado[j]);
                }
                boolean ganaste = true;
                for (int i = 0; i < s.length(); i++) {
                    if (ahorcado[i] != charpalabra[i]) {
                        ganaste = false;
                        break;
                    }
                }
                if (ganaste == true) {
                    System.out.println();
                    System.out.println("GANASTE");
                    partida = false;
                }
                if (vida <= 0) {
                    partida = false;
                    System.out.println();
                    System.out.println("Te quedaste sin vidas, GAME OVER");
                }
            }
        }

    }
}

