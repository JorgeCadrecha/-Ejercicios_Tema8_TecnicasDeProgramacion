
public class Cliente {
	private String nombre;
	private int numeroCliente;

	private static int numerosClientes = 0;

	public Cliente(String nombre) {
		this.nombre = nombre;
		Cliente.numerosClientes++;
		this.numeroCliente = Cliente.numerosClientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public static int getNumerosClientes() {
		return Cliente.numerosClientes;
	}

	public static void setNumerosClientes(int numerosClientes) {
		Cliente.numerosClientes = numerosClientes;
	}

	public String toString() {
		return "Cliente n.°" + this.numeroCliente + " [" + this.nombre + "]";
	}
}
