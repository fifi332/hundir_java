/**
 * Clase principal que controla el flujo del juego de hundir la flota.
 * Inicializa el tablero y gestiona los ataques y sus resultados.
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Juego {

    /** Tablero de juego sobre el que se realizan los ataques. */
    private final Tablero tablero;

    /**
     * Constructor del juego. Crea el tablero e inicia una serie de ataques de prueba.
     */
    public Juego() {
        tablero = new Tablero();

        // Ataques de prueba
        lanzarAtaque(1, 0);
        lanzarAtaque(1, 0);
        lanzarAtaque(1, 1);
        lanzarAtaque(1, 2);
        lanzarAtaque(1, 3);
        lanzarAtaque(1, 4);
    }

    /**
     * Lanza un ataque a una coordenada del tablero y muestra el resultado.
     *
     * @param x coordenada X (fila) del ataque.
     * @param y coordenada Y (columna) del ataque.
     */
    public void lanzarAtaque(int x, int y) {
        System.out.println("Ataque a " + x + "," + y);

        Casilla casilla = tablero.casillero[x][y];
        int resultado = casilla.recibirDisparo();

        mostrarResultado(resultado);
    }

    /**
     * Muestra por pantalla el resultado de un disparo.
     *
     * @param resultado valor numérico del resultado: 0 = agua, 1 = tocado, 2 = hundido.
     */
    private void mostrarResultado(int resultado) {
        switch (resultado) {
            case 0 -> System.out.println("Agua");
            case 1 -> System.out.println("Tocado");
            case 2 -> System.out.println("Hundido");
        }
    }

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        new Juego();
    }
}