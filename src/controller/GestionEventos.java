package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import packageLibro.*;
import model.*;
import view.*;

public class GestionEventos {

	
	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_copiar, actionListener_crear,
			actionListener_recuperarLibro, actionListener_listar;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				try {
					call_compararContenido();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_copiar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				try {
					call_copiarFichero();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		view.getCopiar().addActionListener(actionListener_copiar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				try {
					call_buscarPalabra();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);

		actionListener_crear = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				try {
					call_crearLibro();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.getBtnCrearLibro().addActionListener(actionListener_crear);

		actionListener_recuperarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				try {
					recuperarLibro();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		//
		view.getBtnRecuperar().addActionListener(actionListener_recuperarLibro);

		actionListener_listar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					listarLibro();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.getBtnListar().addActionListener(actionListener_listar);
	}

	private int call_compararContenido() throws FileNotFoundException, IOException {
		// TODO: Gestionar excepciones
		// TODO: Llamar a la función compararContenido de GestionDatos
		boolean coincide = model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());
		if (coincide == true) {
			view.getTextArea().setText("Los ficheros tienen el mismo contenido");
		} else {
			view.getTextArea().setText("Los ficheros no tienen el mismo contenido");

		}

		return 1;
	}

	private int call_buscarPalabra() throws FileNotFoundException, IOException {
		// TODO: Llamar a la función buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		int coincide = model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(),
				view.getPrimera().isSelected());
		if (coincide != -1) {
			view.getTextArea().setText("La palabra buscada se encuentra en el fichero");
		} else {
			view.getTextArea().setText("La palabra buscada no se encuentra en el fichero");

		}

		return 1;
	}

	// metodo para copiar ficheros
	private int call_copiarFichero() throws FileNotFoundException, IOException {

		int bytes = model.call_copiarFichero(view.getFichero1().getText(), view.getFichero2().getText());
		if (bytes != -1) {
			view.getTextArea().setText("Se ha copiado el contenido del fichero y ocupa " + bytes);
		} else {
			view.getTextArea().setText("No se ha podido copiar");

		}
		return 1;

	}

	// metodo para crear libro
	private void call_crearLibro() throws IOException {

		if (view.getIdentificador().getText().isEmpty() || view.getTitulo().getText().isEmpty()
				|| view.getTitulo().getText().isEmpty() || view.getAnyo().getText().isEmpty()
				|| view.getEditor().getText().isEmpty() || view.getPaginas().getText().isEmpty()) {
			view.getTextArea().setText("Se deben rellenar todos los campos para crear un libro.");
		} else {
			Libro llibre = new Libro(view.getIdentificador().getText(), view.getTitulo().getText(),
					view.getTitulo().getText(), view.getAnyo().getText(), view.getEditor().getText(),
					view.getPaginas().getText());
			int estado = model.guardar_libro(llibre);

			// Esto mete el libro que has creado en

			// libros.add(llibre);
		}

	}

	// Este metodo sirve para recuperar un libro mediante su ID

	private int recuperarLibro() throws IOException {
		Libro librito = model.recuperar_libro(view.getIdentificador().getText());

		if (librito != null) {

			view.getTextArea().setText(librito.mostrarDatos());
		}
		return 0;
	}

	private int listarLibro() throws IOException {
		ArrayList<Libro> listado = null;
		try{
			listado = model.recuperar_todos();
		}catch (Exception e) {
			System.out.println("asdasad");		
						
		}
			if (listado.size() != 0) {
				String pantalla = "Se ha encontroado " + listado.size() + " libros.\n";
				for (int i = 0; i < listado.size(); i++) {
					pantalla += listado.get(i).mostrarDatos();
				}

				view.getTextArea().setText(pantalla);

			}
	
		
		return 0;
	}

}
