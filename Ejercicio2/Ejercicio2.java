
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		final int MAX = 20;
		Cliente[] clientes = new Cliente[MAX];
		Obra[] obras = new Obra[MAX];
		Pedido[] pedidos = new Pedido[MAX];
		int numero_de_Obras = 0;
		int numero_de_Pedidos = 0;
		int opcion;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("-- Menú --");
			System.out.println("1 - Mostrar los clientes");
			System.out.println("2 - Crear un cliente");
			System.out.println("3 - Crear una obra");
			System.out.println("4 - Crear una pedido");
			System.out.println("5 - Mostrar los pedidos");
			System.out.println("6 - Salir");
			opcion = sc.nextInt();
			sc.nextLine();

			int numero_de_Clientes = Cliente.getNumerosClientes();

			switch (opcion) {
			case 1:
				System.out.println("-- Clientes --");
				for (int i = 0; i < numero_de_Clientes; i++)
					System.out.println(clientes[i].toString());
				break;
			case 2:
				System.out.println("¿Nombre?");
				String nombre = sc.nextLine();
				clientes[numero_de_Clientes] = new Cliente(nombre);
				System.out.println(clientes[numero_de_Clientes].toString() + " agregado");
				break;
			case 3:
				System.out.println("¿Tipo?");
				System.out.println("1 - Libro");
				System.out.println("2 - Vídeo");
				int tipo = sc.nextInt();
				sc.nextLine();

				System.out.println("¿Título?");
				String titulo = sc.nextLine();
				System.out.println("¿Autor?");
				String autor = sc.nextLine();

				if (tipo == 1) {
					System.out.println("¿Número de páginas?");
					int numPaginas = sc.nextInt();
					sc.nextLine();
					obras[numero_de_Obras] = new Libro(titulo, autor, numPaginas);
				} else {
					System.out.println("¿Duración (minutos)?");
					int duracion = sc.nextInt();
					sc.nextLine();
					obras[numero_de_Obras] = new Video(titulo, autor, duracion);
				}
				System.out.println(obras[numero_de_Obras].informacion() + " añadido");
				numero_de_Obras++;
				break;
			case 4:
				System.out.println("¿Para qué cliente?");
				for (int i = 0; i < numero_de_Clientes; i++)
					System.out.println(i + 1 + " - " + clientes[i].getNombre());
				int introducirCliente = sc.nextInt() - 1;
				sc.nextLine();
				Pedido com = new Pedido(clientes[introducirCliente]);
				int introducirObra;
				do {
					System.out.println("¿Qué  obra agregar al pedido?");
					for (int i = 0; i < numero_de_Obras; i++)
						System.out.println(i + 1 + " - " + obras[i].informacion());
					System.out.println(numero_de_Obras + 1 + " - Terminar el pedido");
					introducirObra = sc.nextInt() - 1;
					sc.nextLine();
					if (0 <= introducirObra && introducirObra < numero_de_Obras)
						com.agregar(obras[introducirObra]);
				} while (introducirObra != numero_de_Obras);
				pedidos[numero_de_Pedidos] = com;
				numero_de_Pedidos++;
				break;
			case 5:
				System.out.println("-- Pedidos --");
				for (int i = 0; i < numero_de_Pedidos; i++)
					System.out.println(" * " + pedidos[i].getInfo());
				break;
			case 6:
				System.out.println("Adiós 🖐 ️");
				break;
			default:
				System.out.println("La opción no es valida");
			}
		} while (opcion != 6);
		sc.close();
	}

}
