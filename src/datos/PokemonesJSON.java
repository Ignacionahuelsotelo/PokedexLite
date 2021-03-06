package datos;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.*;


import logica.Pokemon;
import logica.Usuario;

public class PokemonesJSON {
	private HashMap<String , ArrayList<Pokemon>> pokemones;

	public PokemonesJSON() {
		pokemones = new HashMap<String , ArrayList<Pokemon>>();
	}


	public void addPokemon(HashMap<String, ArrayList<Pokemon>> pokemones2) {
		pokemones=pokemones2;
	}

	public int tamanio() {
		return pokemones.size();
	}

	//genera un JSON en un formato mas amigable
	public String generarJSONPretty() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);

		return json;
	}
	
	//escribi en el JSON destino el JSON con nueva informacion
	public void guardarJSON(String jsonParaGuardar, String archivoDestino) {
		try {
			FileWriter writer = new FileWriter(archivoDestino);
			writer.write(jsonParaGuardar);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	//lee el contenido del JSON 
	public static PokemonesJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		PokemonesJSON ret = null;
		try {	
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, PokemonesJSON.class);
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		} 
		catch (IOException e) {
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
	
	public HashMap<String, ArrayList<Pokemon>> getPokemones () {
		return pokemones;
	}

	@Override
	public String toString() {
		return "PokemonesJSON [pokemones=" + pokemones.toString() + "]";
	}

	

	
}
