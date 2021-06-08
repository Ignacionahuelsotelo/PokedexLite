package logica;

public class Pokemon {
	
	private String nombre;
	private TipoDePokemon tipo;
	private Double nivel;
	
	public Pokemon(String nombre, TipoDePokemon tipo, double nivel) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.nivel = nivel;
	}

	
	
	public String getNombre() {
		return nombre;
	}

	public TipoDePokemon getTipo() {
		return tipo;
	}

	public Double getNivel() {
		return nivel;
	}
	
	public void evolucionar () {
		if ( this.nivel >= 16 ) {
			System.out.print("Evolucione!!");
		}
		return ;
	}

	public void aumentarNivel (int exp) {
		nivel = nivel + exp; 
	}



	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", tipo=" + tipo + ", nivel=" + nivel + "]";
	}
	
	
	
	
	
	
}
