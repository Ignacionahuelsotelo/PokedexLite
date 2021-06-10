package datos;

import java.util.ArrayList;
import java.util.HashMap;

import logica.Pokemon;
import logica.Usuario;

public class GestorJSON {
	//esta clase sera la encargada de gestionar los metodos y la informacion relacionado con los JSON 
	public static PokemonesJSON losPokemones = new PokemonesJSON();
	public static PokemonesWikiJSON losPokemonesWiki = new PokemonesWikiJSON();
	

	//guarda los pokemones nuevos en el JSON de usuarios
	public static void guardarPokemon() {
		String jsonPretty = losPokemones.generarJSONPretty();
		losPokemones.guardarJSON(jsonPretty, "PokemonesUsuarios.JSON");
	}
	
	//agrega los pokemones nuevos asociados a un usuario en el JSON
	public static void agregarPokemon(HashMap<String, ArrayList<Pokemon>> pokemones) {
		losPokemones.addPokemon(pokemones);
	}
	
	
	public static HashMap<String, ArrayList<Pokemon>> getPokemones(){
		HashMap<String, ArrayList<Pokemon>> ret = losPokemones.getPokemones();
		return ret;
	}

	//agrega el pokemon en el JSON de la wiki
	public static void agregarPokemonWiki(ArrayList<Pokemon> p) {
		losPokemonesWiki.addPokemon(p);

	}
	//guarda el pokemon en el JSON de la wiki
	public static void guardarPokemonWiki() {
		String jsonPretty = losPokemonesWiki.generarJSONPretty();
		losPokemonesWiki.guardarJSON(jsonPretty, "PokemonesWiki.JSON");
	}
	
	//actualiza la lista de pokemones en el JSON de la wiki
	public static void actualizar(ArrayList<Pokemon> cargaPokemones) {
		losPokemonesWiki.addPokemon(cargaPokemones);
	}
	


}
