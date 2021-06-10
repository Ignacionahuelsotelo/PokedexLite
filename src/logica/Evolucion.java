package logica;

public class Evolucion {
	
	private String nombre;
	private String tipo;
	private Double nivelNecesario;
	
	public Evolucion(String nombre, String tipo, Double nivelNecesario) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.nivelNecesario = nivelNecesario;
		
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", tipo=" + tipo + ", nivelNecesario=" + nivelNecesario + "]";
	}
	
	
	
	
}
