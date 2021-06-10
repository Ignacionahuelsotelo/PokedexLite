package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import datos.GestorJSON;
import datos.PokemonesWikiJSON;
import logica.Evolucion;
import logica.Habilidad;
import logica.Pokemon;
import logica.TipoDePokemon;

public class ControladorWiki {

	public static ArrayList<Pokemon> getWiki() {
		PokemonesWikiJSON wiki = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		ArrayList<Pokemon> cargaPokemones = wiki.getInformacionPokemones();
		return cargaPokemones;
	}
	//agrega un pokemon nuevo a PokemonesWiki.JSON
	public static void agregarPokemonWiki(Pokemon pokemon1) {
		PokemonesWikiJSON wiki = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		ArrayList<Pokemon> cargaPokemones = wiki.getInformacionPokemones();
		if (cargaPokemones.contains(pokemon1)) {
			System.out.println("ya hay este pokemon");
		}
		else {
			cargaPokemones.add(pokemon1);
			GestorJSON.agregarPokemonWiki(cargaPokemones);
			guardarPokemonesWiki();
		}
	}
	
	public static void agregarPokemonWiki() {
		PokemonesWikiJSON wiki = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		ArrayList<Pokemon> cargaPokemones = wiki.getInformacionPokemones();
		Pokemon pokemon;
		double nivel;
		String tipo;
		String nombrePokemon;
		String nombreEv = " ";
		Scanner entrada;
		int cantidadEv;
		String habilidad1;
		String habilidad2;
		boolean acumulador = false;
		
		System.out.println("Ingrese el nombre del Pokemon : \n");
		entrada = new Scanner (System.in);
		nombrePokemon= entrada.nextLine();
		
		System.out.println("Ingrese el tipo del Pokemon : \n");
		entrada = new Scanner (System.in);
		tipo = entrada.nextLine();
		TipoDePokemon tipoP = new TipoDePokemon(tipo);
		
		System.out.println("Ingrese el nivel del Pokemon : \n");
		entrada = new Scanner (System.in);
		nivel = entrada.nextDouble();
		
		System.out.println("Ingrese la cantidad de evoluciones del Pokemon : \n");
		entrada = new Scanner (System.in);
		cantidadEv = entrada.nextInt();
		for (int i =0; i < cantidadEv;i++) {
			System.out.println("Ingrese el nombre de la evolucion :  \n");
			entrada = new Scanner (System.in);
			nombreEv = entrada.nextLine();
			System.out.println("Ingrese el tipo de la evolucion :  \n");
			entrada = new Scanner (System.in);
			tipo = entrada.nextLine();
			System.out.println("Ingrese el nivel requerido para esta evolucion :  \n");
			entrada = new Scanner (System.in);
			nivel = entrada.nextDouble();
			
		}
		
		ArrayList<Evolucion> evoluciones = new ArrayList<Evolucion>();
		Evolucion nuevaE;
		nuevaE = new Evolucion (nombreEv,tipo,nivel);
		evoluciones.add(nuevaE);
		
		System.out.println("Ingrese la primer habilidad : \n");
		entrada = new Scanner (System.in);
		habilidad1 = entrada.nextLine();
		System.out.println("Ingrese la otra habilidad : \n");
		entrada = new Scanner (System.in);
		habilidad2 = entrada.nextLine();
		
		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
		Habilidad nuevaH = new Habilidad(habilidad1);
		habilidades.add(nuevaH);
		nuevaH = new Habilidad(habilidad2);
		habilidades.add(nuevaH);
		
		pokemon = new Pokemon(nombrePokemon, tipoP, nivel, evoluciones, habilidades);
		
		for (Pokemon pokemon2 : cargaPokemones) {
			if (!pokemon2.getNombre().equals(nombrePokemon)) {
				acumulador = true;
			}
		}
		if (acumulador) {
			
			agregarPokemonWiki(pokemon);
		}
	}
	
	//elimina un pokemon de PokemonesWiki.JSON
	public static void elminarPokemonWiki (Pokemon p) {
		PokemonesWikiJSON wiki = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		ArrayList<Pokemon> cargaPokemones = wiki.getInformacionPokemones();
		if (cargaPokemones.contains(p)) {
			cargaPokemones.remove(p);
			GestorJSON.actualizar(cargaPokemones);
			guardarPokemonesWiki();
		}
		else {
			System.out.println("este pokemon no esta en la wiki");
		}
	}
	
	public static void eliminarPokemonWiki() {
		Scanner entrada;
		String nombrePokemon;
		
		System.out.println("Ingrese el nombre del Pokemon : \n");
		entrada = new Scanner (System.in);
		nombrePokemon= entrada.nextLine();
		
		PokemonesWikiJSON wiki = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		ArrayList<Pokemon> cargaPokemones = wiki.getInformacionPokemones();
		
		for (Pokemon p : cargaPokemones) {
			if (p.getNombre().equals(nombrePokemon)) {
				elminarPokemonWiki(p);
			}
		}
	}
	
	//edita la informacion del pokemon pasado por parametro en PokemonesWiki.JSON donde referencia es el valor
	//que indica que caracteristica del pokemon se quiere modificar
	public static void editarPokemonWiki (String p, int referencia) {
		PokemonesWikiJSON wiki = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		ArrayList<Pokemon> cargaPokemones = wiki.getInformacionPokemones();
		
		double nivelNuevo;
		String tipoNuevo;
		String nombreNuevo;
		
		for (Pokemon pokemon : cargaPokemones) {
			if (pokemon.getNombre().equals(p)) {
				if (referencia == 1) {
					System.out.println("Ingrese el nombre nuevo : \n");
					Scanner entrada = new Scanner (System.in);
					nombreNuevo = entrada.nextLine();
					pokemon.setNombre(nombreNuevo);
				}
				if(referencia == 2) {
					System.out.println("Ingrese el tipo nuevo : \n");
					Scanner entrada = new Scanner (System.in);
					tipoNuevo = entrada.nextLine();
					TipoDePokemon tipo = new TipoDePokemon(tipoNuevo);
					pokemon.setTipo(tipo);
				}
				if (referencia == 3) {
					System.out.println("Ingrese el nivel nuevo : \n");
					Scanner entrada = new Scanner (System.in);
					nivelNuevo = entrada.nextDouble();
					pokemon.setNivel(nivelNuevo);
				}
				if (referencia == 4) {
					ArrayList<Evolucion> nuevaEvolucion = new ArrayList<Evolucion>();
					Evolucion nueva;
					
					System.out.println("Ingrese el nombre de la evolucion :  \n");
					Scanner entrada = new Scanner (System.in);
					nombreNuevo = entrada.nextLine();
					System.out.println("Ingrese el tipo de la evolucion :  \n");
					Scanner entrada2 = new Scanner (System.in);
					tipoNuevo = entrada2.nextLine();
					System.out.println("Ingrese el nivel requerido para esta evolucion :  \n");
					Scanner entrada3 = new Scanner (System.in);
					nivelNuevo = entrada3.nextDouble();
	
					nueva = new Evolucion (nombreNuevo,tipoNuevo,nivelNuevo);
					nuevaEvolucion.add(nueva);
					pokemon.setEvoluciones(nueva);
	
				}
				if (referencia == 5) {
					ArrayList<Habilidad> nuevaHabilidad = new ArrayList<Habilidad>();
					Habilidad nueva;
					
					System.out.println("Ingrese el nombre de la habilidad :  \n");
					Scanner entrada = new Scanner (System.in);
					nombreNuevo = entrada.nextLine();
					
					nueva = new Habilidad(nombreNuevo);
					nuevaHabilidad.add(nueva);
					pokemon.setHabilidades(nueva);
				}
			}
			
		}
		GestorJSON.actualizar(cargaPokemones);
		guardarPokemonesWiki();
	}
	//muestra todos los pokemones segun la carateristica que quiera saber el usuario.  
	public static String verInformacionPokemones(int referencia) {
		PokemonesWikiJSON pokemonesInfoJSON = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		ArrayList<Pokemon> pokemonesInfo = pokemonesInfoJSON.getInformacionPokemones();
		String acumulador = "";
		for (Pokemon p : pokemonesInfo) {
			if (referencia == 1) {
				acumulador = acumulador + p.toStringNombre();
			}
			if(referencia == 2) {
				acumulador = acumulador + p.toStringPokemon();
			}
			if (referencia == 3) {
				acumulador = acumulador + p.toStringHabilidadesEvoluciones();
			}	
		}
		return acumulador;
	}
	
	//muestra la caracteristica especifica del pokemon pasado por parametro
	public static String verInformacioPokemon (Pokemon p, int referencia) {
		PokemonesWikiJSON pokemonesInfoJSON = PokemonesWikiJSON.leerJSON("PokemonesWiki.JSON");
		ArrayList<Pokemon> pokemonesInfo = pokemonesInfoJSON.getInformacionPokemones();
		String acumulador = "";
		for (Pokemon pokemon : pokemonesInfo) {
			if (pokemon.getNombre().equals(p.getNombre())) {
				if (referencia == 1) {
					acumulador = acumulador + p.toStringNombre();
				}
				if(referencia == 2) {
					acumulador = acumulador + p.toStringPokemon();
				}
				if (referencia == 3) {
					acumulador = acumulador + p.toStringHabilidadesEvoluciones();
				}
			}
		}
		return acumulador;
	}
	
	//el metodo que comunica el gestor de los JSON con el controlador para guardar los pokemones nuevos agregados
	//a la Wiki
	private static void guardarPokemonesWiki() {
		GestorJSON.guardarPokemonWiki();
	}
	
	public static Pokemon getPokemon() {
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
	
	public static int getReferencia () {
		int opcionUsuario = 0;
		Scanner entradaUsuario;
		System.out.println("-----------------PokeWiki-----------------\n"
				+ "Seleccione una opcion : \n"
				+ "1) Nombre del Pokemon \n"
				+ "2) Informacion del Pokemon \n"
				+ "3) Informacion de las evolucions y habilidades del Pokemon \n");
		
		entradaUsuario = new Scanner (System.in);
		opcionUsuario = entradaUsuario.nextInt();
		
		return opcionUsuario;
		
		
	}
		
}
