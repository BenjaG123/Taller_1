package org.example;
import java.util.Scanner;


public class JuegoCartas {

    public static void main(String[] args) {
        inicializarCartasJuego();
        ejecutarMenu();

    }

    public static String[][] crearMatrizCartas() {
        return new String[12][2];
    }

    public static void inicializarCartasJuego() {
        String [][] cartas = crearMatrizCartas();
        agregarCartas(cartas,"Carta 2","2");
        agregarCartas(cartas,"Carta 3","3");
        agregarCartas(cartas,"Carta 4","4");
        agregarCartas(cartas,"Carta 5","5");
        agregarCartas(cartas,"Carta 6","6");
        agregarCartas(cartas,"Carta 7","7");
        agregarCartas(cartas,"Carta 8","8");
        agregarCartas(cartas,"Carta 9","9");
        agregarCartas(cartas,"Carta J","10");
        agregarCartas(cartas,"Carta Q","10");
        agregarCartas(cartas,"Carta K","10");
        agregarCartas(cartas,"Carta A","11");
    }

    public static String[][] agregarCartas(String[][] matriz, String nombreCarta, String puntaje) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null) {
                matriz[i][0] = nombreCarta;
                matriz[i][1] = puntaje;
                break;
            }
        }
        return matriz;
    }



    public static void mostrarMenu() {
        System.out.println("\n----Juego de Cartas----");
        System.out.println("1.- Jugar");
        System.out.println("2.- Salir");
        System.out.print("Elija una opcion: ");

    }

    public static int pedirOpcion (){
        int opcion = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >=1 && opcion <= 2) {
                    break;
                } else {
                    System.out.println("Opcion invalida.");
                }
            } else {
                System.out.println("Opcion invalida.");
                scanner.nextLine();
            }
        }
        return opcion;
    }

    public static void ejecutarOpcion(int opcion, String[][] matriz) {
        switch (opcion) {
            case 1:
                jugar();

            case 2:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }



    public static void ejecutarMenu() {
        int opcion;
        do{
            mostrarMenu();
            opcion = pedirOpcion();
            ejecutarOpcion(opcion, crearMatrizCartas());
        } while (opcion !=2);
    }

    public static void jugar(String[][] matriz) {
        int puntosJugador1 = 0;
        int puntosJugador2 = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Repartiendo cartas...");
        String[][] cartasJugador1 = repartirCartas(matriz);
        String[][] cartasJugador2 = repartirCartas(matriz);

        System.out.println("\nCartas del Jugador 1:");
        for (String[] carta : cartasJugador1) {
            System.out.println(carta[0] + " con puntaje: " + carta[1]);
            puntosJugador1 += Integer.parseInt(carta[1]);
        }
        System.out.println("Puntos totales del Jugador 1: " + puntosJugador1);

        System.out.println("\nCartas del Jugador 2:");
        for (String[] carta : cartasJugador2) {
            System.out.println(carta[0] + " con puntaje: " + carta[1]);
            puntosJugador2 += Integer.parseInt(carta[1]);
        }
        System.out.println("Puntos totales del Jugador 2: " + puntosJugador2);

        ganadorJuego(puntosJugador1, puntosJugador2);
    }

    public static String[][] repartirCartas(String[][] matriz) {
        String[][] cartasRepartidas = new String[3][2];
        for (int i = 0; i < 3; i++) {
            cartasRepartidas[i] = obtenerCarta(matriz);
        }
        return cartasRepartidas;
    }

    public static void ganadorJuego(int puntosJugador1, int puntosJugador2) {
        if (puntosJugador1 > puntosJugador2) {
            System.out.println("Jugador 1 gana con " + puntosJugador1 + " puntos!");
        } else if (puntosJugador2 > puntosJugador1) {
            System.out.println("Jugador 2 gana con " + puntosJugador2 + " puntos!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }

    public static String[] obtenerCarta(String[][] matriz) {
       int cartaRandom = (int)(Math.random() * matriz.length);
        return new String[] {matriz[cartaRandom][0], matriz[cartaRandom][1]};

    }
}