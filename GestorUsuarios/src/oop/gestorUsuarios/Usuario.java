package oop.gestorUsuarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

	private int id;
	private String nombre;
	private String apellido;
	private String nombre_usuario;
	private String contraseña;
	private boolean activo;

	public Usuario() {

	}

//con parametros
	public Usuario(int id, String nombre, String apellido, String nombre_usuario, String contraseña, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombre_usuario = nombre_usuario;
		this.contraseña = contraseña;
		this.activo = activo;
	}

//sin parametroas
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreUsuario() {
		return nombre_usuario;
	}

	public void setNombreUsuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;

	}

	public String toString() {
		return this.id + "-" + this.nombre + "-" + this.apellido + "-" + this.nombre_usuario + "-" + this.contraseña
				+ "-" + boolToInt(this.activo);
	}

	public String paraFichero() {
		return this.id + ":" + this.nombre + ":" + this.apellido + ":" + this.nombre_usuario + ":" + this.contraseña
				+ ":" + boolToInt(this.activo);
	}

	public static ArrayList<Usuario> cargarDatos(String Nombre_fichero) throws FileNotFoundException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		File file = new File(Nombre_fichero);
		Scanner lectorFichero = new Scanner(file);
		String linea;
		String[] partes;

		while (lectorFichero.hasNext()) {
			linea = lectorFichero.nextLine();
			partes = linea.split(":");

			Usuario usuario_guardar = new Usuario(Integer.parseInt(partes[0]), (partes[1]), (partes[2]), (partes[3]),
					(partes[4]), (stringToBool(partes[5])));

			usuarios.add(usuario_guardar);

		}
		lectorFichero.close();
		return usuarios;

	}

	public static void guardarDatos(String Nombre_fichero, ArrayList<Usuario> usuarios) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(Nombre_fichero);
		for (int i = 0; i < usuarios.size(); i++) {

			writer.println(usuarios.get(i).paraFichero());

		}
		System.out.println("Los nuevos cambios han sido guardados con exito!!");
		writer.close();
	}

	public static int boolToInt(Boolean activo) {
		if (activo == true) {
			return 1;
		} else {
			return 0;
		}

	}

	public static boolean stringToBool(String activo) {
		int activo_int = Integer.parseInt(activo);
		if (activo_int == 0) {
			return false;
		} else {
			return true;
		}

	}
}
