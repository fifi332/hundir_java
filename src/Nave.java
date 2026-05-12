/**
 * Representa una nave del juego de hundir la flota.
 * Cada nave tiene un nombre, un tipo, una cantidad de vida
 * y un estado de hundimiento.
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Nave {

    /** Nombre identificativo de la nave. */
    private final String nombre;

    /** Tipo de la nave (portaaviones, fragata, submarino...). */
    private final String tipo;

    /** Puntos de vida restantes de la nave. */
    private int vida;

    /** Indica si la nave ha sido hundida. */
    private boolean hundido;

    /**
     * Constructor de la nave.
     *
     * @param nombre nombre identificativo de la nave.
     * @param tipo   tipo de la nave (portaaviones, fragata, submarino...).
     * @param vida   puntos de vida iniciales de la nave.
     */
    public Nave(String nombre, String tipo, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.hundido = false;
    }

    /**
     * Procesa un disparo recibido por la nave.
     * Si ya estaba hundida devuelve 2 directamente. Si no, resta un punto de vida
     * y comprueba si queda en 0 para marcarla como hundida.
     *
     * @return 2 si la nave estaba o queda hundida, 1 si ha sido tocada pero sigue activa.
     */
    public int recibirDisparo() {
        if (hundido) {
            return 2; // HUNDIDO
        }

        vida--;

        if (vida <= 0) {
            hundido = true;
            System.out.println(nombre + " hundido");
            return 2; // HUNDIDO
        } else {
            System.out.println(nombre + " tocado. Vida restante: " + vida);
            return 1; // TOCADO
        }
    }

    /**
     * Devuelve el nombre de la nave.
     *
     * @return nombre de la nave.
     */
    public String getNombre() { return nombre; }

    /**
     * Devuelve el tipo de la nave.
     *
     * @return tipo de la nave.
     */
    public String getTipo() { return tipo; }

    /**
     * Devuelve los puntos de vida actuales de la nave.
     *
     * @return vida restante de la nave.
     */
    public int getVida() { return vida; }
}