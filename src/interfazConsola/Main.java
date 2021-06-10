package interfazConsola;

import java.util.Scanner;

import controlador.ControladorPokedex;
import controlador.ControladorWiki;

public class Main {

	public static void main(String[] args) {
		
		
			mostrarInicio();	
				
				
			
		}
		

		

	private static void mostrarInicio () {
		int opcionUsuario = 0;
		String opcionUsuarioString;
		Scanner entradaUsuario;
		boolean reinicio = false;
	
		while (opcionUsuario == 0 || reinicio == true) {
			System.out.println("-----------------Bienvenid@ a POKEDEX-LIE-----------------\n"
					+ "Seleccione una opcion : \n"
					+ "1) Ya soy un maestro Pokemon \n"
					+ "2) Quiero ser un maestro Pokemon \n"
					+ "3) Salir \n");
			entradaUsuario = new Scanner (System.in);
			opcionUsuario = entradaUsuario.nextInt();
		}
		
		if (opcionUsuario == 1) {
			System.out.println("Ingresa tu nombre ");
			entradaUsuario = new Scanner (System.in);
			opcionUsuarioString = entradaUsuario.nextLine();
			if (ControladorPokedex.verificarUsuario(opcionUsuarioString)) {
				mostrarMenuMaestroPokemon(opcionUsuarioString);
			}
			else {
				System.out.println("Este usuario no existe :(");
				reinicio = true;
			}
		
	}
		if (opcionUsuario == 2) {
			System.out.println("Ingresa tu nombre ");
			entradaUsuario = new Scanner (System.in);
			opcionUsuarioString = entradaUsuario.nextLine();
			if (!ControladorPokedex.verificarUsuario(opcionUsuarioString)) {
				System.out.println("Te regalamos un pokemon de la wiki, eleji el que quieras ! :");	
				ControladorPokedex.agregarPokemon(ControladorPokedex.crearPokemon(), ControladorPokedex.crearUsuario(opcionUsuarioString));
			}
			else {
				System.out.println("Este usuario ya esta registrado");
			}
	
		}
	}
	private static void mostrarMenuMaestroPokemon(String usuario) {
		int opcionUsuario = 0;
		Scanner entradaUsuario;
		boolean reinicio = true;
		
		System.out.println("-----------------¡Hola de vuelta "+ usuario + "!-----------------\n"
				+ "Seleccione una opcion : \n"
				+ "1) Ver mi Pokedex \n"
				+ "2) Ver la Wiki de Pokemones \n"
				+ "3) Salir \n");
		entradaUsuario = new Scanner (System.in);
		opcionUsuario = entradaUsuario.nextInt();
		
		while (reinicio == true) {
			
			if (opcionUsuario == 1) {
				mostrarOpcionesPokedex(usuario);
			}
			if (opcionUsuario == 2) {
				mostrarOpcionesWiki(usuario);
			}
			if (opcionUsuario == 3) {
				System.out.println("Hasta pronto !");
				System.exit(0);
			}
				
//			
//				System.out.println("Opcion invalida !");
//				reinicio = true;
			
		}
		}
	
	

	private static void mostrarMenuUsuarioNuevo() {
		
	}
	
	private static void mostrarOpcionesPokedex(String usuario) {
		int opcionUsuario = 0;
		Scanner entradaUsuario;
		boolean reinicio = true;
		int seleccion = 0;
		System.out.println("-----------------MI POKEDEX-----------------\n"
				+ "Seleccione una opcion : \n"
				+ "1) Agregar Pokemon \n"
				+ "2) Eliminar Pokemon \n"
				+ "3) Editar Informacion \n"
				+ "4) Volver atras");
		
		entradaUsuario = new Scanner (System.in);
		opcionUsuario = entradaUsuario.nextInt();
		
		while (reinicio == true) {
			if (seleccion == 1) {
				entradaUsuario = new Scanner (System.in);
				opcionUsuario = entradaUsuario.nextInt();
				seleccion = 0;
			}
			if (opcionUsuario == 1) {
				ControladorPokedex.agregarPokemon(ControladorPokedex.crearPokemon(),ControladorPokedex.crearUsuario(usuario) );
				seleccion = 1;
			}
			if (opcionUsuario == 2) {
				System.out.println("Proximamente ..");		
				seleccion = 1;
						}
			if (opcionUsuario == 3) {
				System.out.println("Proximamente ..");
				seleccion = 1;
			}
			if (opcionUsuario == 4) {
				mostrarMenuMaestroPokemon(usuario);
			}
		}
		
		
		
	}
	private static void mostrarOpcionesWiki(String usuario) {
		int opcionUsuario = 0;
		Scanner entradaUsuario;
		boolean reinicio = true;
		
		System.out.println("-----------------PokeWiki-----------------\n"
				+ "Seleccione una opcion : \n"
				+ "1) Agregar Pokemon a la Wiki \n"
				+ "2) Eliminar Pokemon de la Wiki \n"
				+ "3) Editar Informacion de un Pokemon de la Wiki \n"
				+ "4) Ver listado de todos los Pokemones \n"
				+ "5) Ver informacon de un Pokemon en especifico \n"
				+ "6) Volver atras \n");
		
		entradaUsuario = new Scanner (System.in);
		opcionUsuario = entradaUsuario.nextInt();
		
		while (reinicio == true ) {
			
			if (opcionUsuario == 1) {
				reinicio = false;
				ControladorWiki.agregarPokemonWiki();
			}
			if (opcionUsuario == 2) {
				reinicio = false;
				ControladorWiki.eliminarPokemonWiki();	
			}
			if (opcionUsuario == 3) {
				reinicio = false;
				mostrarOpcionesEditarWiki(usuario);
			}
			if (opcionUsuario == 4) {
				System.out.println(ControladorWiki.getWiki());
				reinicio = false;
			}
			if (opcionUsuario == 5) {
				System.out.println(ControladorWiki.verInformacioPokemon(ControladorWiki.getPokemon(), ControladorWiki.getReferencia()));
				reinicio = false;
			}
			if (opcionUsuario == 6) {
				reinicio = false;
				mostrarMenuMaestroPokemon(usuario);
			}
			
		}
		
	}

	private static void mostrarOpcionesEditarWiki(String usuario) {
		int opcionUsuario = 0;
		Scanner entradaUsuario;
		boolean reinicio = true;
		String nombrePokemon;
		
		System.out.println("-----------------PokeWiki-----------------\n"
				+ "Seleccione una opcion : \n"
				+ "1) Editar nombre \n"
				+ "2) Editar tipo \n"
				+ "3) Editar nivel \n"
				+ "4) Editar evoluciones \n"
				+ "5) Editar habilidades \n"
				+ "6) Volver atras  \n");
		
		entradaUsuario = new Scanner (System.in);
		opcionUsuario = entradaUsuario.nextInt();
		
		
		
		while (reinicio == true ) {
			
			System.out.println("Ingresa el nombre del Pokemon que queres editar : \n");
			entradaUsuario = new Scanner (System.in);
			nombrePokemon = entradaUsuario.nextLine();
			
				if (opcionUsuario == 1) {
					ControladorWiki.editarPokemonWiki(nombrePokemon, 1);
					reinicio = false;
				}
				
				if (opcionUsuario == 2) {
					ControladorWiki.editarPokemonWiki(nombrePokemon, 2);
					reinicio = false;
				}
				if (opcionUsuario == 3) {
					reinicio = false;
					ControladorWiki.editarPokemonWiki(nombrePokemon, 3);
					
				}
				
				if (opcionUsuario == 4) {
					ControladorWiki.editarPokemonWiki(nombrePokemon, 4);
					reinicio = false;
				}
				
				if (opcionUsuario == 5) {
					ControladorWiki.editarPokemonWiki(nombrePokemon, 5);
					reinicio = false;
				}
				
				if (opcionUsuario == 6) {
					return;
					//mostrarOpcionesWiki(usuario);
					//reinicio = false;
				}
				
		}	
	}
}
