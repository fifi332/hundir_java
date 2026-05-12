/**
 * Representa una casilla del tablero de juego.
 * Cada casilla puede contener agua o una nave, y puede haber sido disparada o no.
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Casilla {

    /** Contenido de la casilla: una {@link Nave} o el String "agua". */
    private final Object contenido;

    /** Indica si esta casilla ya ha recibido un disparo. */
    private boolean disparada = false;

    /**
     * Constructor de la casilla.
     *
     * @param contenido el contenido de la casilla, puede ser una {@link Nave} o el String "agua".
     */
    public Casilla(Object contenido) {
        this.contenido = contenido;
    }

    /**
     * Procesa el disparo recibido en esta casilla.
     * Si la casilla ya fue disparada anteriormente, muestra información sobre su estado actual
     * sin modificarlo. Si es el primer disparo, marca la casilla como disparada y
     * delega en la nave si la hubiera.
     *
     * @return 0 si es agua o casilla repetida de agua,
     *         1 si hay una nave tocada (o casilla repetida con nave),
     *         2 si la nave queda hundida.
     */
    public int recibirDisparo() {
        if (disparada) {
            if (contenido instanceof Nave nave) {
                System.out.println("Casilla ya disparada con " + nave.getNombre() +
                        ", tipo " + nave.getTipo() + ", con " + nave.getVida() + " vidas");
            } else {
                System.out.println("Casilla ya disparada es de agua");
            }
            return contenido instanceof Nave ? 1 : 0;
        }

        disparada = true;

        if (contenido.equals("agua")) {
            return 0; // AGUA
        } else if (contenido instanceof Nave nave) {
            return nave.recibirDisparo();
        }

        return 0;
    }
}