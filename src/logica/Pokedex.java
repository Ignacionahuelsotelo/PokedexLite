package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Pokedex {

	private String dueño;
	private HashMap<String , ArrayList<Pokemon>> contenido;
	private ArrayList<Pokemon> pokemones;
	
	public Pokedex(String dueño) {
		
		this.dueño = dueño;
		this.pokemones = new ArrayList<Pokemon>();
		this.contenido = new HashMap<String,ArrayList<Pokemon>>();
	}
	
	public void subirNivel (Pokemon p) {
		//deberia buscar el id en el hash 
		p.aumentarNivel(5);
	}
	
	public void editarInformacion () {
		return ;
	}
	
	//agrega un pokemon con un usuario asociado a la pokedex
	public void agregarPokemon(Pokemon p, Usuario u) {
		if (!contenido.containsKey(u.getNombre())) {
			ArrayList<Pokemon> pokemonesNuevos = new ArrayList<>();
			pokemonesNuevos.add(p);
			contenido.put(u.getNombre(), pokemonesNuevos);
		}
		for (Entry<String, ArrayList<Pokemon>> entry : contenido.entrySet() ) {
			if(entry.getKey().equals(u.getNombre())) {;
				if (!entry.getValue().contains(p)) {	
					entry.getValue().add(p);
				}
			}
		}
	}
	
	//carga la informacion de los usuarios y sus respectivas pokedex
	public void cargarPokedex (HashMap<String , ArrayList<Pokemon>> pokemonesCargados) {
		contenido = pokemonesCargados;
	}
	
	
	public void cargarPokemon (	Pokemon p, Usuario u) {
		agregarPokemon(p,u);
	}
	
	public HashMap<String , ArrayList<Pokemon>>  getPokemones () {
		return contenido;
	}
}
