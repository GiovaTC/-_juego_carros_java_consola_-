# -_juego_carros_java_consola_- :.
# Juego de Carros en Java (Consola):
```
=========================
      RACER CONSOLE
=========================
        ______
   ____/[] [] \____
  O--------------O
=========================
```

```

## IntelliJ IDEA + Java 21:
Este proyecto crea un pequeño juego de carreras en consola donde:
- El jugador controla un carro.
- Debe esquivar obstáculos.
- El puntaje aumenta mientras sobrevive.
- Se utiliza teclado:
  - `A` → izquierda
  - `D` → derecha
  - `Q` → salir

---

# Características

- Juego tipo arcade en consola
- Movimiento lateral
- Obstáculos aleatorios
- Sistema de puntaje
- Interfaz ASCII
- Compatible con IntelliJ IDEA

---

# Estructura del Proyecto

```text
JuegoCarros/
│
├── src/
│   └── JuegoCarros.java
│
└── README.md
```

---

# Código Completo

```java
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

            // Entrada del jugador
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

    static void dibujar() {

        for (int y = 0; y < ALTO; y++) {

            for (int x = 0; x < ANCHO; x++) {

                // Bordes
                if (x == 0 || x == ANCHO - 1) {
                    System.out.print("|");
                }

                // Obstáculo
                else if (x == obstaculoX && y == obstaculoY) {
                    System.out.print("X");
                }

                // Carro jugador
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

    static void moverObstaculo() {

        obstaculoY++;

        if (obstaculoY >= ALTO) {

            puntaje++;

            obstaculoY = 0;

            generarObstaculo();
        }
    }

    static void generarObstaculo() {

        obstaculoX = random.nextInt(ANCHO - 2) + 1;
    }

    static void verificarColision() {

        if (obstaculoY == ALTO - 1 && obstaculoX == carroX) {

            juegoActivo = false;
        }
    }

    static void limpiarPantalla() {

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}
```

---

# Cómo Ejecutarlo en IntelliJ IDEA
## 1. Crear Proyecto
Abrir:

```text
IntelliJ IDEA
```

Luego:

```text
New Project → Java
```

---

## 2. Crear Clase
Crear archivo:

```text
JuegoCarros.java
```

---

## 4. Ejecutar
Presionar:

```text
Shift + F10
```

o botón:

```text
Run
```

---

# Ejemplo Visual

```text
|                  |
|                  |
|        X         |
|                  |
|                  |
|                  |
|                  |
|                  |
|                  |
|                  |
|                  |
|                  |
|                  |
|                  |
|         A        |

PUNTAJE: 5
```

---

```

# Posibles Mejoras

Puedes agregar:

- Varios obstáculos
- Velocidad progresiva
- Nitro
- Combustible
- Carros enemigos
- Niveles
- Música
- Guardado de récords
- Base de datos Oracle 19c
- Interfaz gráfica con Swing

---

# Versión Mejorada (Ideas)

## Tecnologías posibles

- Java Swing
- JavaFX
- JDBC
- Oracle Database 19c

---

# Requisitos

- Java 21
- IntelliJ IDEA
- Consola compatible con Java

---

# Autor

Proyecto educativo desarrollado en Java para práctica de:

- Programación orientada a objetos
- Lógica de videojuegos
- Manejo de consola
- Control de flujo
- Eventos de teclado
:. . / .
