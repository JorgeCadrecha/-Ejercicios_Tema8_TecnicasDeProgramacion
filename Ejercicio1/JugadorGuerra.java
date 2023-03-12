
import java.util.Random;
import java.util.Scanner;

class Dado {
    private Random random;

    public Dado() {
        random = new Random();
    }

    public int lanzar() {
        return random.nextInt(6) + 1;
    }
}

class JugadorGuerra {
    private String nombre;
    private int fichas;
    private Dado dado;

    public JugadorGuerra(String nombre) {
        this.nombre = nombre;
        this.fichas = 10;
        this.dado = new Dado();
    }

    public String getNombre() {
        return nombre;
    }

    public int getFichas() {
        return fichas;
    }

    public int lanzarDado() {
        return dado.lanzar();
    }

    public void quitarFicha() {
        fichas--;
    }


    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);

        JugadorGuerra jugador1, jugador2;

        
        System.out.println("Nombre del jugador 1: ");
        String nombre1 = teclado.nextLine();
        jugador1= new JugadorGuerra(nombre1);
        System.out.println("Nombre del jugador 2: ");
        String nombre2 = teclado.nextLine();
        jugador2= new JugadorGuerra(nombre2);

        int marcador1 = 0, marcador2 = 0;

        System.out.println("Comienza la guerra de dados entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "\n");

        while (jugador1.getFichas() > 0 && jugador2.getFichas() > 0) {
            int resultado1 = jugador1.lanzarDado();
            int resultado2 = jugador2.lanzarDado();

            System.out.println(jugador1.getNombre() + " ha sacado un " + resultado1);
            System.out.println(jugador2.getNombre() + " ha sacado un " + resultado2);

            if (resultado1 > resultado2) {
                jugador1.quitarFicha();
                marcador1++;
                System.out.println(jugador1.getNombre() + " gana\n");
            } else if (resultado2 > resultado1) {
                jugador2.quitarFicha();
                marcador2++;
                System.out.println(jugador2.getNombre() + " gana\n");
            } else {
                System.out.println("Empate\n");
            }
        }

        if (jugador1.getFichas() == 0) {
            System.out.println(jugador2.getNombre() + " ha ganado");
        } else {
            System.out.println(jugador1.getNombre() + " ha ganado");
        }

        System.out.println("Marcador: " + jugador1.getNombre() + " " + marcador1 + " - " + jugador2.getNombre() + " " + marcador2);
    }
}
