public class Juego {

    private final Tablero tablero;

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

    public void lanzarAtaque(int x, int y) {
        System.out.println("Ataque a " + x + "," + y);

        Casilla casilla = tablero.casillero[x][y];
        int resultado = casilla.recibirDisparo();

        mostrarResultado(resultado);
    }

    private void mostrarResultado(int resultado) {
        switch (resultado) {
            case 0 -> System.out.println("Agua");
            case 1 -> System.out.println("Tocado");
            case 2 -> System.out.println("Hundido");
        }
    }

    public static void main(String[] args) {
        new Juego();
    }
}