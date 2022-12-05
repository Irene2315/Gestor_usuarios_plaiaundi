package oop.gestorusuarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String contrasenia;
	private boolean activo;
	
	
	
	public Usuario() {
	}

	public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contrasenia, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.activo = activo;
	}
	

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
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void setActivo(int activo) {
		if(activo == 0) {
			this.activo = false;
		}else {
			this.activo = true;
		}
	}
	
	public void setActivo(String activo) {
		if(activo.equals("0")) {
			this.activo = false;
		}else {
			this.activo = true;
		}
	}


	public static void guardarUsuarios(String nombrefichero, ArrayList<Usuario> usuarios) throws FileNotFoundException{
		
		PrintWriter writer = new PrintWriter(nombrefichero);
		
		for (Usuario usuario : usuarios) {
			writer.println(usuario.enFormatoFichero());
		}
		
		writer.close();
		
		
	}
	
	/**
	 * 
	 * @return String todos los datos del usuario en formato para guardarlo en el fichero
	 * ej: 1:unnombre:unapellido:unNombreDeUsuario:unpassword:0
	 */
	private String enFormatoFichero() {
		String activoString;
		if(this.activo) {
			activoString = "1";
		}else {
			activoString = "0";
		}
		return this.id + ":" + this.nombre + ":" + this.apellido + ":" + this.nombreUsuario + ":" + this.contrasenia + ":" + activoString;
	}

	
	
	public static ArrayList<Usuario> cargarUsuarios(String nombrefichero) throws FileNotFoundException{
		ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		
		File f = new File(nombrefichero);
		Scanner scan = new Scanner(f);
		
		String linea;
		String[] partes;
		Usuario usuario;
		while(scan.hasNext()) {
			linea = scan.nextLine();
			partes = linea.split(":");
			
			usuario = new Usuario();
			usuario.setId(Integer.parseInt(partes[0]));
			usuario.setNombre(partes[1]);
			usuario.setApellido(partes[2]);
			usuario.setNombreUsuario(partes[3]);
			usuario.setContrasenia(partes[4]);
			
			boolean activo;
			if(partes[5].equals("0")) {
				activo = false;
			}else {
				activo = true;
			}
			usuario.setActivo(activo);
			
			listaDeUsuarios.add(usuario);
				
		}
		scan.close();
		
		
		
		return listaDeUsuarios;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario="
				+ nombreUsuario + ", contrasenia=" + "*********" + ", activo=" + activo + "]";
	}
}
