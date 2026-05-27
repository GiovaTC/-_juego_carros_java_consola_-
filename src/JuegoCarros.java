import java.util.Random;
import java.util.Scanner;

public class JuegoCarros {

    static final int ANCHO = 20;
    static final int ALTO = 15;

    static int carroX = ANCHO / 2;
    static int obstaculoX;
    static int obstaculoY = 0;

    static int puntaje = 0;
    static boolean juegoActivo = true;

    static Random random = new Random();

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        generarObstaculo();

        while (juegoActivo) {

            limpiarPantalla();

            dibujar();

            System.out.println("\nPUNTAJE: " + puntaje);
            System.out.println("Controles: A=Izquierda D=Derecha Q=Salir");

            // entrada del jugador
            if (System.in.available() > 0) {

                String input = scanner.nextLine().toUpperCase();

                switch (input) {

                    case "A":
                        if (carroX > 1)
                            carroX--;
                        break;

                    case "D":
                        if (carroX < ANCHO - 2)
                            carroX++;
                        break;

                    case "Q":
                        juegoActivo = false;
                        break;
                }
            }

            moverObstaculo();
            verificarColision();

            Thread.sleep(200);
        }

        System.out.println("\n================================");
        System.out.println(" GAME OVER ");
        System.out.println(" Puntaje Final: " + puntaje);
        System.out.println("================================");
    }

    private static void limpiarPantalla() {
    }

    private static void verificarColision() {
        
    }

    private static void moverObstaculo() {
        
    }

    static void dibujar() {
        for ( int y = 0; y < ALTO; y++ ) {

            for ( int x = 0; x < ANCHO; x++ ) {

                // bordes
                if (x == 0 || x == ANCHO - 1){
                    System.out.print("|");
                }

                //obstaculo .
                else if (x == obstaculoX && y == obstaculoY) {
                    System.out.print("X");
                }

                // carro jugador .
                else if (x == carroX && y == ALTO - 1) {
                    System.out.print("A");
                }

                else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    private static void generarObstaculo() {
    }
}