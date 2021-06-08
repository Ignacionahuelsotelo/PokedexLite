package logica;

import java.util.ArrayList;
import java.util.HashMap;

public class Pokedex {

	private String dueño;
	private HashMap<String , Pokemon> contenido;
	private ArrayList<Pokemon> pokemones;
	
	public Pokedex(String dueño) {
		
		this.dueño = dueño;
		this.contenido = contenido;
		this.pokemones = new ArrayList<Pokemon>();
	}
	
	public void subirNivel (Pokemon p) {
		//deberia buscar el id en el hash 
		p.aumentarNivel(5);
	}
	
	public void editarInformacion () {
		return ;
	}
	
	public void agregarPokemon (Pokemon p) {
		if (p == null)
			throw new NullPointerException("No se puede agregar una persona null");

		if (!pokemones.contains(p)) {
			pokemones.add(p);
		}
	}
	
	public void cargarPokemon (String nombre, TipoDePokemon tipo, double nivel) {
		Pokemon p = new Pokemon(nombre, tipo, nivel);
		agregarPokemon(p);
	}
	
	public ArrayList<Pokemon>  getPokemones () {
		return pokemones;
	}
}
