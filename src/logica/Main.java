package logica;

import controlador.Controlador;

public class Main {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoDePokemon tipo = new TipoDePokemon("fuego");
		Pokemon pokemon1 = new Pokemon("Charizard", tipo , 1);
		//Pokedex pokedex = new Pokedex("ash");
		
		
		
		
		Controlador.agregarPokemon(pokemon1.getNombre(), pokemon1.getTipo(), pokemon1.getNivel());
		
		Controlador.cargarDatosPokedex("Pokemones.JSON");
		
		Controlador.guardarPokemones();
		
		for (Pokemon p : Controlador.pokedex.getPokemones()) {
			System.out.println(p.toString());
		}
	
		
		
//		pokemon1.subirNivel();
//		pokemon1.subirNivel();
//		pokemon1.subirNivel();
//		pokemon1.subirNivel();
//		
//		pokemon1.evolucionar();
	}

}
