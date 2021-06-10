package logica;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.ResourceBundle.Control;

import controlador.ControladorPokedex;
import java.util.ArrayList;

public class Main {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoDePokemon tipo = new TipoDePokemon("tierra");
		
		Evolucion e = new Evolucion("Clefable", "Lineal " , 10.0);
		Evolucion e2 = new Evolucion("Primeape", "Lineal " , 10.0);
		Evolucion e3 = new Evolucion("Super Clefable", "Lineal " , 10.0);
		
		Habilidad h = new Habilidad("pegar fuerte");
		Habilidad h2 = new Habilidad("defenderse");
		
		ArrayList<Evolucion> evoluciones1 = new ArrayList<Evolucion>();
		ArrayList<Evolucion> evoluciones2 = new ArrayList<Evolucion>();
		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
		
		
		//modificar esto
		evoluciones1.add(e3);
		evoluciones1.add(e);
		
		
		evoluciones2.add(e2);
		habilidades.add(h);
		habilidades.add(h2);
		
		Pokemon pokemon1 = new Pokemon("charizard", tipo , 1, evoluciones1,habilidades);
		Pokemon pokemon2 = new Pokemon("Mankey", tipo , 1, evoluciones2,habilidades);
		Pokemon pokemonPrueba = new Pokemon ("Prueba2", tipo,1,evoluciones1,habilidades);
		
		
		
		Usuario usuarioNuevo = new Usuario("nacho");
		Usuario usuarioNuevo2 = new Usuario("ash");
		Usuario usuarioNuevo3 = new Usuario("jaimito");
		
	
//		ControladorPokedex.cargarBase(usuarioNuevo);
//		ControladorPokedex.cargarBase(usuarioNuevo2);
		
	
		
//		ControladorPokedex.agregarPokemon(pokemon1,usuarioNuevo);
//		ControladorPokedex.agregarPokemon(pokemon2,usuarioNuevo3);

		
		
//		Controlador.guardarPokemones(usuarioNuevo);
//		Controlador.guardarPokemones(usuarioNuevo2);
		
//		System.out.println("---------------DATOS POKEDEX----------------");
//		
//		System.out.println(Controlador.verPokemones(usuarioNuevo));
//		
//		System.out.println("---------------DATOS WIKI----------------");
		
		
//		Controlador.agregarPokemonWiki(pokemonPrueba);

//		System.out.println(Controlador.verInformacionPokemones(1));
//		System.out.println("------------------------");
		//Controlador.elminarPokemonWiki(pokemonPrueba);

//		System.out.println(Controlador.verInformacionPokemones(1));
		
		//Controlador.editarPokemonWiki(pokemonPrueba, 4);

		
//		System.out.println(Controlador.verInformacioPokemon(pokemon1,3));

//		for (Entry<String, ArrayList<Pokemon>> entry : Controlador.pokedex.getPokemones().entrySet()) {
//			//System.out.println(entry.getKey());
//		}
		
		
	
		
		
//		pokemon1.subirNivel();
//		pokemon1.subirNivel();
//		pokemon1.subirNivel();
//		pokemon1.subirNivel();
//		
//		pokemon1.evolucionar();
	}

}
