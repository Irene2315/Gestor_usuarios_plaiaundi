package oop.gestorUsuarios;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestionDeUsuarios {
	private static Scanner Scanner;

	public static void main(String[] args) throws FileNotFoundException {

		final String Nombre_fichero = ("recursos/usuarios");

		ArrayList<Usuario> usuarios = Usuario.cargarDatos(Nombre_fichero);

		// declaracion de constantes (final) para las opciones

		Scanner teclado = new Scanner(System.in);
		final int MOSTRAR_USUARIOS = 1;
		final int ELIMINAR_USUARIO = 2;
		final int CREAR_USUARIO = 3;
		final int MODIFICAR_USUARIO = 4;
		final int SALIR = 0;
		int opcion_menu;

		do {
			System.out.println("------MENU-------");
			System.out.println(MOSTRAR_USUARIOS + ". Mostrar usuarios");
			System.out.println(ELIMINAR_USUARIO + ". Eliminar usuarios");
			System.out.println(CREAR_USUARIO + ". Crear usuarios");
			System.out.println(MODIFICAR_USUARIO + ". Modificar usuarios");
			System.out.println(SALIR + ". Salir");
			System.out.println("Elije una de las opciones");
			opcion_menu = teclado.nextInt();

			switch (opcion_menu) {
			case MOSTRAR_USUARIOS:
				Usuario.guardarDatos(Nombre_fichero, usuarios);
				mostrar_usuarios(usuarios);

				break;
			case ELIMINAR_USUARIO:
				eliminarUsuario(usuarios);
				break;
			case CREAR_USUARIO:
				crearUsuario(usuarios);
				break;
			case MODIFICAR_USUARIO:
				modificarUsuario(usuarios);
				break;
			case SALIR:
				System.out.println("ADIOS");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}
			System.out.println("");
		} while (opcion_menu != SALIR);
		Usuario.guardarDatos(Nombre_fichero, usuarios);
		teclado.close();

	}

	public static void mostrar_usuarios(ArrayList<Usuario> usuarios) {
		for (int i = 0; i < usuarios.size(); i++) {

			System.out.println(usuarios.get(i));
		}
	}

	public static void eliminarUsuario(ArrayList<Usuario> usuarios) {

		Scanner = new Scanner(System.in);
		int IDusuarioEliminar;

		System.out.println("Introduzca el id de usuario que quiera eliminar");
		IDusuarioEliminar = Scanner.nextInt();

		Iterator<Usuario> it = usuarios.iterator();
		while (it.hasNext()) {
			Usuario usuario = it.next();
			if (IDusuarioEliminar == usuario.getId()) {
				it.remove();
				System.out.println("Usuario eliminado con exito");

			}
			
		}
	}

	public static void crearUsuario(ArrayList<Usuario> usuarios) {
		Scanner = new Scanner(System.in);
		int idUsuario;
		String nombreUsuario;
		String apellidoUsuario;
		String nombreUsuarioUsuario;
		String contraseñaUsuario;
		String activoUsuario;

		System.out.println("Introduce los datos que quieras añadir:");
		System.out.println("ID ");
		idUsuario = Scanner.nextInt();
		Scanner.nextLine();
		System.out.println("Nombre ");
		nombreUsuario = Scanner.nextLine();
		System.out.println("Apellido ");
		apellidoUsuario = Scanner.nextLine();
		System.out.println("Nombre de usuario");
		nombreUsuarioUsuario = Scanner.nextLine();
		System.out.println("Contraseña");
		contraseñaUsuario = Scanner.nextLine();
		System.out.println("Estado ");

		activoUsuario = Scanner.nextLine();
		while (!activoUsuario.equals("0") && !activoUsuario.equals("1")) {
			System.out.println("Estado ");
			activoUsuario = Scanner.nextLine();
		}

		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setId(idUsuario);
		usuarioNuevo.setNombre(nombreUsuario);
		usuarioNuevo.setApellido(apellidoUsuario);
		usuarioNuevo.setNombreUsuario(nombreUsuarioUsuario);
		usuarioNuevo.setContraseña(contraseñaUsuario);
		usuarioNuevo.setActivo(Usuario.stringToBool((activoUsuario)));
		usuarios.add(usuarioNuevo);
	}

	public static void modificarUsuario(ArrayList<Usuario> usuarios) {
		Scanner = new Scanner(System.in);
		int id_usuario;

		System.out.println("Introduzca el id de usuario que quiere modificar ");
		id_usuario = Scanner.nextInt();
		Iterator<Usuario> it = usuarios.iterator();
		while (it.hasNext()) {
			Usuario usuario = it.next();
			if (id_usuario == usuario.getId()) {
				final int NOMBRE = 1;
				final int APELLIDO = 2;
				final int NOMBRE_USUARIO = 3;
				final int CONTRASEÑA = 4;
				final int ESTADO=5;
				final int SALIR = 0;
				int opcion_menu;
				String nuevo_nombre;
				String nuevo_apellido;
				String nuevo_nombre_usuario;
				String nueva_contraseña;
				String nuevo_estado;

				do {
					System.out.println("------Que quieres MODIFICAR -------");
					System.out.println(NOMBRE + ". Nombre");
					System.out.println(APELLIDO + ". Apellido");
					System.out.println(NOMBRE_USUARIO + ". Nombre_usuario");
					System.out.println(CONTRASEÑA + ". Contraseña");
					System.out.println(ESTADO + ". Estado");
					System.out.println(SALIR + ". Terminar modificaciones");

					System.out.println("Elije una de las opciones");
					opcion_menu = Scanner.nextInt();
					Scanner.nextLine();
					switch (opcion_menu) {
					case NOMBRE:
						System.out.println("Introduce el nuevo Nombre");
						nuevo_nombre = Scanner.nextLine();
						usuario.setNombre(nuevo_nombre);

						break;
					case APELLIDO:
						System.out.println("Introduce el nuevo Apellido");
						nuevo_apellido = Scanner.nextLine();
						usuario.setApellido(nuevo_apellido);
						break;
					case NOMBRE_USUARIO:
						System.out.println("Introduce el nuevo nombre de usuario");
						nuevo_nombre_usuario = Scanner.nextLine();
						usuario.setNombreUsuario(nuevo_nombre_usuario);
						break;
					case CONTRASEÑA:
						System.out.println("Introduce la contraseña");
						nueva_contraseña = Scanner.nextLine();
						usuario.setContraseña(nueva_contraseña);
						break;
					case ESTADO:
						System.out.println("Introduce el estado");
						nuevo_estado = Scanner.nextLine();
						usuario.setActivo(Usuario.stringToBool(nuevo_estado));
						break;
					case SALIR:
						System.out.println("Fin de las modificaciones");
						break;
					default:
						System.out.println("Opcion incorrecta!");
					}
					System.out.println("");
				} while (opcion_menu != SALIR);

			}

		}

	}

}
