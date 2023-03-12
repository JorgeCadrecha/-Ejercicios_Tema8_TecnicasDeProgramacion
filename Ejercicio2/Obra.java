
public class Obra {
	protected String titulo;
	protected String autor;

	public Obra(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String informacion() {
		return this.titulo + " de " + this.autor;
	}
}