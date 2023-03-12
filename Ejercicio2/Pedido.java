
public class Pedido {

	public static final int MAX_OBRAS = 10;
	private Obra[] obrasPedidos = new Obra[MAX_OBRAS];
	private int numObras = 0;
	private Cliente cli;

	public Pedido(Cliente cli) {
		this.cli = cli;
	}

	public void agregar(Obra o) {
		this.obrasPedidos[this.numObras] = o;
		this.numObras++;
	}

	public String getInfo() {
		String lista_Pedidos = "Pedido de " + this.cli.getNombre() + ":\n" ;
		for (int i = 0; i < this.numObras; i++)
			lista_Pedidos += "    - " + this.obrasPedidos[i].informacion() + "\n";
		return lista_Pedidos;
	}

}
