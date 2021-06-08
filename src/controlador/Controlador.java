package controlador;

import java.util.ArrayList;

import datos.GestorJSON;
import datos.PokemonesJSON;
import logica.Pokedex;
import logica.Pokemon;
import logica.TipoDePokemon;

public class Controlador {
	
	public static Pokedex pokedex = new Pokedex("Ash");
	
	public static void agregarPokemon(String nombre, TipoDePokemon tipo, double 	nivel) {
		pokedex.cargarPokemon(nombre, tipo, nivel);
		Pokemon p = new Pokemon(nombre, tipo, nivel);
		GestorJSON.agregarPokemon(p);
	}
	
	public static void cargarDatosPokedex (String nombreDelArchivo) {
		PokemonesJSON pokemones = PokemonesJSON.leerJSON(nombreDelArchivo);
		ArrayList<Pokemon> cargaPokemones = pokemones.getPokemones();
		for (Pokemon p : cargaPokemones) {
			pokedex.agregarPokemon(p);
		}
	}
	
	public static void cargarBase() {
		cargarDatosPokedex("Pokemones.JSON");
		
	}
	
	public static void cargarActual () {
		cargarDatosPokedex("Usuarios.JSON");
	}
	
	public static void guardarPokemones() {
		GestorJSON.guardarPokemon();
	}
	
	
}
