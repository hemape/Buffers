package model;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import packageLibro.Libro;
import view.LaunchView;

public class GestionDatos {
	private LaunchView view;

	FileInputStream fis = null;
	FileOutputStream fos = null;
	int numBytes;

	public void intentarCerrar(Closeable c) {

		try {
			c.close();
		} catch (IOException e) {

		}

	}

	public GestionDatos() {

	}

	// TODO: Implementa una función para abrir ficheros
	public BufferedReader abrirFichero(String fichero) {

		try {
			// comparar
			FileReader fr1 = new FileReader(fichero);
			BufferedReader bf1 = new BufferedReader(fr1);
			return bf1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	// TODO: Implementa una función para cerrar ficheros
	public void cerrarFichero(BufferedReader archivo) {
		try {
			archivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean compararContenido(String fichero1, String fichero2) throws FileNotFoundException, IOException {
		//
		String cadena;
		String cadena2;
		BufferedReader bf1 = abrirFichero(fichero1);
		BufferedReader bf2 = abrirFichero(fichero2);
		cadena = bf1.readLine();
		System.out.println(cadena);
		cadena2 = bf2.readLine();

		while ((cadena != null) && (cadena2 != null)) {
			if (!cadena.equals(cadena2)) {
				return false;
			}
			cadena = bf1.readLine();
			cadena2 = bf2.readLine();

		}

		cerrarFichero(bf1);
		cerrarFichero(bf2);
		return true;
	}

	public int buscarPalabra(String fichero1, String palabra, boolean primera_aparicion)
			throws IOException, FileNotFoundException {
		// TODO: Implementa la función
		String cadena;
		int contador = 0;
		BufferedReader b = abrirFichero(fichero1);
		if (!palabra.isEmpty()) {
			if (primera_aparicion == true) {
				while ((cadena = b.readLine()) != null) {
					contador++;
					if (cadena.equals(palabra)) {
						cerrarFichero(b);
						return contador;
					}
				}
			} else {
				int ultima = -1;
				while ((cadena = b.readLine()) != null) {
					contador++;
					if (cadena.equals(palabra)) {
						ultima = contador;

					}
				}
				return ultima;
			}
		}
		cerrarFichero(b);
		return -1;

	}

	public int call_copiarFichero(String fichero1, String fichero2) throws FileNotFoundException, IOException {
		try {

			fis = new FileInputStream(fichero1); // inFile -> Archivo a copiar
			fos = new FileOutputStream(fichero2); // outFile -> Copia del
													// archivo
			byte[] buffer = new byte[1024];
			int cont;
			fis.read(buffer);
			fos.write(buffer);

			while ((cont = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, cont);
				numBytes = numBytes + 1024;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException fnf) {
			fnf.printStackTrace();
		} finally {
			intentarCerrar(fis);
			intentarCerrar(fos);
		}
		return numBytes;
	}

	public int guardar_libro(Libro libro) throws IOException {

		File ficheroLibro = new File("Libro" + libro.getId_libro() + ".txt");
		if (ficheroLibro.exists()) {
			view.getTextArea().setText("El fichero ya existe");
		} else {

			ficheroLibro.createNewFile();

			ObjectOutputStream objetoFile = new ObjectOutputStream(new FileOutputStream(ficheroLibro));

			objetoFile.writeObject(libro);

		}
		return 1;

	}

	public Libro recuperar_libro(String identificador) throws FileNotFoundException, IOException {
		File archiu = new File("Libro" + identificador + ".txt");
		if (!archiu.exists()) {
			return null;
		}

		ObjectInputStream leer = new ObjectInputStream(new FileInputStream(archiu));
		Libro recuperado;

		try {
			recuperado = (Libro) leer.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("El libro no se lee");
			return null;
		}
		return recuperado;
	}

	public ArrayList<Libro> recuperar_todos() throws FileNotFoundException, IOException {

		ArrayList<Libro> lista = new ArrayList<Libro>();
		// el . es para trabajar en el directorio actual
		File carpeta = new File(".");
		String[] archives = carpeta.list();

		for (int i = 0; i < archives.length; i++) {
			if (archives[i].startsWith("Libro")) {

				String id = archives[i].substring(5, archives[i].length() - 4);
				Libro lb = recuperar_libro(id);
			
				
				lista.add(lb);
				
					}

		}

		return lista;

	}
}
