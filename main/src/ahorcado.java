import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class ahorcado {
    //Metodo para trycatch
    public static char trycatch() {
        char letra='a';
        Scanner sc = new Scanner(System.in);
        boolean trycat = true;
        while (trycat) {
            try {
                letra = sc.next().charAt(0);
                if (!((int) letra>=65 && (int) letra<=90 || (int)letra>=97 && (int)letra<=122 )){
                    throw new Exception("Error, ingresa una letra");
                }
                trycat=false;
            } catch (Exception e) {
              System.out.println(e);
            }
        }
        return letra;
    }
    public static boolean ganaste(char charpalabra[], char ahorcado[], String s) {
        boolean ganaste=true;
    for (int i = 0; i < s.length(); i++) {
        if (ahorcado[i] != charpalabra[i]) {
            ganaste = false;
            break;
        }
    }
    return ganaste;
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
                letra= trycatch();
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
                boolean ganaste = ganaste( charpalabra, ahorcado, s);
                if (ganaste) {
                    System.out.println("\nGANASTE");
                }
                if (vida <= 0) {
                    partida = false;
                    System.out.println("\nTe quedaste sin vidas, GAME OVER");
                }
            }
        }

    }
}

