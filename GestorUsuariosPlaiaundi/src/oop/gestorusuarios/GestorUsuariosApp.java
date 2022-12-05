/**
 * 
 */
package oop.gestorusuarios;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/**
 * @author Eñaut Agirre
 *
 */
public class GestorUsuariosApp {
	
	private static final int SALIR = 0;
	private static final int CREATE = 1;
	private static final int READ = 2;
	private static final int UPDATE = 3;
	private static final int DELETE = 4;

	final String NOMBRE_FICHERO = "resources/usuarios.txt";
	Scanner teclado = new Scanner(System.in);
	
	public void run() throws FileNotFoundException {
	
		ArrayList<Usuario> usuarios = Usuario.cargarUsuarios(NOMBRE_FICHERO);
		
		int aukera;

		do {
			menuPrincipal();
			aukera = Integer.parseInt(teclado.nextLine());

			switch (aukera) {
			case CREATE:
				crearUsuario(usuarios);
				break;
			case DELETE:
				eliminarUsuario(usuarios);
				break;
			case READ:
				mostrarUsuarios(usuarios);
				break;
			case UPDATE:
				modificarUsuario(usuarios);
			case SALIR:
				agurra();
				break;
			

			default:
				break;
			}

		} while (aukera != SALIR);
		Usuario.guardarUsuarios(NOMBRE_FICHERO, usuarios);
		
	}
	
	
	/**
	 * @param usuarios
	 */
	private void modificarUsuario(ArrayList<Usuario> usuarios) {
		System.out.println("Introduce el nombre de usuarios para modificar");
		String nombreUsuario = teclado.nextLine();
		int indiceUsuario = -1;

		boolean encontrado = false;
		for (int i = 0; i < usuarios.size() && !encontrado; i++) {
			if(usuarios.get(i).getNombreUsuario().equals(nombreUsuario)) {
				encontrado = true;
				System.out.println(usuarios.get(i));
				indiceUsuario = i;
				
			}
		}
		
		if(encontrado) {
			System.out.println("Introduce la id nueva");
			int id = Integer.parseInt(teclado.nextLine());
			
			System.out.println("Nombre nuevo:");
			String nombre = teclado.nextLine();
			
			System.out.println("Apellido nuevo:");
			String apellido = teclado.nextLine();
			
			System.out.println("nombre de usuario nuevo:");
			nombreUsuario = teclado.nextLine();
			
			System.out.println("contrasenia nueva:");
			String contrasenia = teclado.nextLine();
			
			System.out.println("activo 0 / 1:");
			String activo = teclado.nextLine();
			
			
			
			usuarios.get(indiceUsuario).setId(id);
			usuarios.get(indiceUsuario).setNombre(nombre);
			usuarios.get(indiceUsuario).setApellido(apellido);
			usuarios.get(indiceUsuario).setNombreUsuario(nombreUsuario);
			usuarios.get(indiceUsuario).setContrasenia(contrasenia);
			usuarios.get(indiceUsuario).setActivo(activo);
			
			
			System.out.println("Usuario modificado");
		}else {
			System.out.println("Usuario no encontrado");
		}
	}


	/**
	 * @param usuarios
	 */
	private void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
	}


	/**
	 * se pedira un nombre de usuario por pantalla y 
	 * si existe se eliminará de la lista
	 * 
	 * @param usuarios la lista de usuarios
	 */
	private void eliminarUsuario(ArrayList<Usuario> usuarios) {
		System.out.println("Introduce el nombre de usuario que quieres eliminar");
		String nombreUsuario = teclado.nextLine();
		
		boolean eliminado = false;
		Iterator<Usuario> it = usuarios.iterator();
		while(it.hasNext() && !eliminado) {
			Usuario usuario = it.next();
			if(usuario.getNombreUsuario().equals(nombreUsuario)) {
				it.remove();
				eliminado = true;
				System.out.println("Usuario " + nombreUsuario + " eliminado.");
			}
		}
		if(!eliminado) {
			System.out.println(nombreUsuario + " no existe");
		}
		
		
	}


	/**
	 * @param usuarios
	 */
	private void crearUsuario(ArrayList<Usuario> usuarios) {
		System.out.println("Introduce la id");
		int id = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Nombre:");
		String nombre = teclado.nextLine();
		
		System.out.println("Apellido:");
		String apellido = teclado.nextLine();
		
		System.out.println("nombre de usuario:");
		String nombreUsuario = teclado.nextLine();
		
		System.out.println("contrasenia:");
		String contrasenia = teclado.nextLine();
		
		System.out.println("activo 0 / 1:");
		String activo = teclado.nextLine();
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setContrasenia(contrasenia);
		usuario.setActivo(activo);
		
		usuarios.add(usuario);
		System.out.println("Usuario anadido a la lista.");
		
	}


	private void menuPrincipal() {
		System.out.println(CREATE + "- sortu");
		System.out.println(READ + "- kontsultak");
		System.out.println(UPDATE + "- aldaketak");
		System.out.println(DELETE + "- ezabatu");
		System.out.println(SALIR + "- irten");

	}
	
	private void agurra() {
		System.out.println("Cerrando .....");

	}

}
