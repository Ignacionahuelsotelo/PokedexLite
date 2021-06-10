package logica;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;

import controlador.ControladorWiki;
import datos.PokemonesWikiJSON;



public class BaseDeDatosWikiTest {
	
	private ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
	private ArrayList<Evolucion> evoluciones = new ArrayList<Evolucion>();
	Pokemon pokemon1;
	Pokemon pokemonPrueba;
	
	

	@Before
	public void setUp () {
		habilidades.add(new Habilidad("ataque volador"));
		habilidades.add(new Habilidad("ataque encantador"));
		
		evoluciones.add(new Evolucion("Clefable", "Lineal", 10.0));
		
		pokemon1 = new Pokemon("Clefairy", new TipoDePokemon("hada") , 1.0,evoluciones, habilidades);
		
		
		 pokemon1 = new Pokemon("Clefairy", new TipoDePokemon("hada") , 1.0,evoluciones, habilidades);
		 pokemonPrueba = new Pokemon("PokemonTest",new TipoDePokemon("tipoTest"), 10.0, evoluciones, habilidades);
			
		ControladorWiki.elminarPokemonWiki(pokemonPrueba);
		
		
	}
	
	@Test
	public void JSONVacioTest () {
		//El JSON ya tiene datos dentro
		assertFalse(ControladorWiki.getWiki().size() == 0);
	}
	
	@Test
	public void buscarPokemonJSONTest() {
		ArrayList<Pokemon> esperado = new ArrayList<Pokemon>();
		Pokemon pokemonJSON = null;
		PokemonesWikiJSON cargaPokemones = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		esperado = cargaPokemones.getInformacionPokemones();
		
		for (Pokemon p: esperado) {
			if (p.equals(pokemon1)) {
				pokemonJSON=p;
			}
		}
		
		assertEquals(pokemonJSON, pokemon1);
	}
	
	@Test 
	public void agregarPokemonJSON () {
		ArrayList<Pokemon> inicial = new ArrayList<Pokemon>();
		PokemonesWikiJSON cargaPokemones = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		inicial = cargaPokemones.getInformacionPokemones();
		
		
		ControladorWiki.agregarPokemonWiki(pokemonPrueba);
		
		ArrayList<Pokemon> modificado = new ArrayList<Pokemon>();
		cargaPokemones = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		modificado = cargaPokemones.getInformacionPokemones();
		
		assertNotEquals(inicial.toString(),modificado.toString());
		
		
		
	}
	
	@Test 
	public void modificarPokemonJSON () {
		ArrayList<Pokemon> inicial = new ArrayList<Pokemon>();
		PokemonesWikiJSON cargaPokemones = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		inicial = cargaPokemones.getInformacionPokemones();
		
		for (Pokemon pokemon : inicial) {
			if (pokemon.getNombre().equals(pokemon1.getNombre())) {
					pokemon.setNombre("nuevoNombreTest");
				}
		}
		
		ArrayList<Pokemon> modificado = new ArrayList<Pokemon>();
		cargaPokemones = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		modificado = cargaPokemones.getInformacionPokemones();
		
		assertNotEquals(inicial.toString(),modificado.toString());
		
	}
	
	
	
}
