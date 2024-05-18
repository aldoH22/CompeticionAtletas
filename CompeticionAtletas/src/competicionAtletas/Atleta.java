package competicionAtletas;

public class Atleta {
	
	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public double getTiempo() {
		return tiempo;
	}

	public Atleta(int numero, String nombre, double tiempo) {
		this.numero = numero;
		this.nombre = nombre;
		this.tiempo = tiempo;
	}

	private int numero;
	
	private String nombre;
	
	private double tiempo;
	
}
