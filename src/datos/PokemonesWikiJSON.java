package datos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import logica.Pokemon;

public class PokemonesWikiJSON {
	// esta clase sera la encargada de implementar los metodos JSON
	private ArrayList<Pokemon> pokemones;
	
	public PokemonesWikiJSON() {
		pokemones = new ArrayList<Pokemon>();
		
	}

	
	public void addPokemon(ArrayList<Pokemon> p) {
		pokemones = p;
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
	public static PokemonesWikiJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		PokemonesWikiJSON ret = null;
		try {	
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, PokemonesWikiJSON.class);
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<Pokemon> getInformacionPokemones() {
		return pokemones;
	}

	@Override
	public String toString() {
		return "PokemonesWikiJSON [pokemones=" + pokemones.toString() + "]";
	}


}
