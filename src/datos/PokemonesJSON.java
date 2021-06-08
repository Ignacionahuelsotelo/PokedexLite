package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.*;


import logica.Pokemon;

public class PokemonesJSON {
	private ArrayList<Pokemon> pokemones;

	public PokemonesJSON() {
		pokemones = new ArrayList<Pokemon>();
	}

	public void addPokemon(Pokemon p) {
		pokemones.add(p);
	}

	public int tamanio() {
		return pokemones.size();
	}

	public String generarJSONBasico() {
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(this);

		return json;
	}

	public String generarJSONPretty() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);

		return json;
	}

	public void guardarJSON(String jsonParaGuardar, String archivoDestino) {
		try {
			FileWriter writer = new FileWriter(archivoDestino);
			writer.write(jsonParaGuardar);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static PokemonesJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		PokemonesJSON ret = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, PokemonesJSON.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<String> getPokemonesString (){
		ArrayList<String> ret = new ArrayList<String>();
		for (int i = 0; i < this.pokemones.size(); i++) {
			ret.add(pokemones.get(i).toString());
		}
		return ret;
	}
	public ArrayList<Pokemon> getPokemones () {
		return pokemones;
	}
}
