package datos;

import logica.Pokemon;

public class GestorJSON {
	public static PokemonesJSON losPokemones = new PokemonesJSON();

	public static void agregarPokemon(Pokemon p) {
		losPokemones.addPokemon(p);
	}

	public static void guardarPokemon() {
		String jsonPretty = losPokemones.generarJSONPretty();
		losPokemones.guardarJSON(jsonPretty, "pokemones.JSON");
	}

}
