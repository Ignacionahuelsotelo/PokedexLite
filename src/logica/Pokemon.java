package logica;

import java.util.ArrayList;
import java.util.Set;

public class Pokemon {
	
	private String nombre;
	private TipoDePokemon tipo;
	private Double nivel;
	private ArrayList<Evolucion> evoluciones;
	private ArrayList<Habilidad> habilidades;
	
	public Pokemon(String nombre, TipoDePokemon tipo, double nivel,ArrayList<Evolucion> evoluciones,ArrayList<Habilidad> habilidades) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.nivel = nivel;
		this.evoluciones = evoluciones;
		this.habilidades = habilidades;
		
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

	public void aumentarNivel (double exp) {
		nivel = nivel + exp; 
	}
	public void aumentarNivelRapido (double exp) {
		nivel = exp;
	}
	
	public ArrayList<Evolucion> getEvoluciones() {
		return evoluciones;
	}
	
	public ArrayList<Habilidad> getHabilidades(){
		return habilidades;
	}

	//tiene varios toString para el metodo que muestra la informacion especifica de un pokemon
	public String toStringPokemon() {
		return "Pokemon [nombre=" + nombre + ", tipo=" + tipo.toString() + ", nivel=" + nivel + "]\n";
	}
	
	public String toStringNombre() {
		return "Pokemon [nombre=" + nombre + "]\n";
	}
	
	public String toStringHabilidadesEvoluciones() {
		return "Pokemon [nombre=" + nombre + ", evoluciones =" + evoluciones.toString() + ", habilidades=" + habilidades.toString() + "]\n";
	}
	
	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + "]\n";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(TipoDePokemon tipo) {
		this.tipo = tipo;
	}

	public void setNivel(Double nivel) {
		this.nivel = nivel;
	}

	public void setEvoluciones(Evolucion e) {
		this.evoluciones.add(e);
	}

	public void setHabilidades(Habilidad h) {
		this.habilidades.add(h);
	}




	
	
	
	
	
	
}
