/**
 * Representa el tablero de juego de hundir la flota.
 * Gestiona la cuadrícula de casillas y la colocación de las naves.
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Tablero {

    /** Valor que indica que una casilla es agua. */
    public static final int AGUA = 0;

    /** Valor que indica que una nave ha sido tocada. */
    public static final int TOCADO = 1;

    /** Valor que indica que una nave ha sido hundida. */
    public static final int HUNDIDO = 2;

    /** Cuadrícula bidimensional que representa el tablero con sus casillas. */
    public final Casilla[][] casillero;

    /**
     * Constructor por defecto. Crea un tablero de 10x10.
     */
    public Tablero() {
        this(10);
    }

    /**
     * Constructor con tamaño personalizado.
     * Inicializa todas las casillas como agua y coloca las naves en sus posiciones.
     *
     * @param tamanho tamaño del lado del tablero cuadrado.
     */
    public Tablero(int tamanho) {
        casillero = new Casilla[tamanho][tamanho];

        // Crear naves
        Nave por1 = new Nave("pipi", "portaaviones", 5);
        Nave fra1 = new Nave("toto", "fragata", 3);
        Nave fra2 = new Nave("pata", "fragata", 3);
        Nave fra3 = new Nave("potete", "fragata", 3);
        Nave sub1 = new Nave("U-47", "submarino", 1);
        Nave sub2 = new Nave("U-96", "submarino", 1);
        Nave sub3 = new Nave("U-505", "submarino", 1);
        Nave sub4 = new Nave("U-534", "submarino", 1);

        // Inicializar todo como agua
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                casillero[i][j] = new Casilla("agua");
            }
        }

        // Colocar naves
        colocarNaveHorizontal(por1, 1, 0, 5);
        colocarNaveHorizontal(fra1, 3, 0, 3);
        colocarNaveHorizontal(fra2, 5, 0, 3);
        colocarNaveHorizontal(fra3, 7, 0, 3);

        casillero[4][4] = new Casilla(sub1);
        casillero[7][5] = new Casilla(sub3);
        casillero[9][4] = new Casilla(sub4);
        casillero[9][9] = new Casilla(sub2);
    }

    /**
     * Coloca una nave de forma horizontal en el tablero,
     * ocupando varias casillas consecutivas en la misma fila.
     *
     * @param nave     la nave a colocar.
     * @param fila     fila en la que se coloca la nave.
     * @param columna  columna de inicio.
     * @param longitud número de casillas que ocupa la nave.
     */
    private void colocarNaveHorizontal(Nave nave, int fila, int columna, int longitud) {
        for (int i = 0; i < longitud; i++) {
            casillero[fila][columna + i] = new Casilla(nave);
        }
    }
}