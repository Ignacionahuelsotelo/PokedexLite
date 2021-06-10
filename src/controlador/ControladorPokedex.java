package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import datos.GestorJSON;
import datos.PokemonesJSON;
import datos.PokemonesWikiJSON;
import logica.Evolucion;
import logica.Habilidad;
import logica.Pokedex;
import logica.Pokemon;
import logica.TipoDePokemon;
import logica.Usuario;

public class ControladorPokedex {
	
	public static Pokedex pokedex = new Pokedex("nacho");
	
	//agrega un pokemon a la pokedex y lo guarda en el HashMap de GestorJSON
	public static void agregarPokemon(Pokemon p, Usuario u) {
		cargarBase(u);
		pokedex.cargarPokemon(p,u);
		GestorJSON.agregarPokemon(pokedex.getPokemones());
		guardarPokemonesPokedex(u);
	}
	
	// Trae los datos de Pokemones.JSON a la pokedex
	private static void cargarDatosPokedex (String nombreDelArchivo, Usuario u) {
		PokemonesJSON pokemones = PokemonesJSON.leerJSON(nombreDelArchivo);
		if (pokemones != null) {
			HashMap<String , ArrayList<Pokemon>> cargaPokemones = pokemones.getPokemones();
			for(Entry <String , ArrayList<Pokemon>> entry : cargaPokemones.entrySet()) {
					pokedex.cargarPokedex(cargaPokemones);	
				}
			}
		}
	
	// Es el metodo con el q interactua el controlador
	private static void cargarBase(Usuario u) {
		cargarDatosPokedex("PokemonesUsuarios.JSON",u);
	}
	
	//el metodo que comunica el gestor de los JSON con el controlador para guardar los pokemones nuevos del usuario
	//pasado por parametro
	private static void guardarPokemonesPokedex(Usuario u) {
		GestorJSON.guardarPokemon();
	}
	

	public static String verPokemones(Usuario u) {
		
		HashMap<String, ArrayList<Pokemon>> listado  =  GestorJSON.getPokemones();
		
		for(Entry <String , ArrayList<Pokemon>> entry : listado.entrySet()) {
			if (entry.getKey().equals(u.getNombre())){
				return entry.getValue().toString();
			}
		}
		return null;
	}

	public static boolean verificarUsuario(String Usuario) {
		PokemonesJSON pokemones = PokemonesJSON.leerJSON("PokemonesUsuarios.JSON");
		HashMap<String, ArrayList<Pokemon>> listado  = pokemones.getPokemones();
		
		for(Entry <String , ArrayList<Pokemon>> entry : listado.entrySet()) {
			entry.getKey();
			if (entry.getKey().equals(Usuario)){
				return true;
			}
		}
		return false;
		
	}

	public static Usuario crearUsuario(String opcionUsuarioString) {
		return new Usuario(opcionUsuarioString);
	}

	public static Pokemon crearPokemon() {
		String nombrePokemon;
		ArrayList<Pokemon> wiki = new ArrayList<Pokemon>();
		Scanner entradaUsuario;
		
		System.out.println("Ingresa el nombre del Pokemon :");
		entradaUsuario = new Scanner (System.in);
		nombrePokemon = entradaUsuario.nextLine();

		wiki =ControladorWiki.getWiki();
		
		for (Pokemon p : wiki) {
			if (p.getNombre().equals(nombrePokemon)) {
				return new Pokemon(nombrePokemon, p.getTipo(), p.getNivel(), p.getEvoluciones(), p.getHabilidades());
			}
		}
		return null;
	}

}
