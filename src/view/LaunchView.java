package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Component;

public class LaunchView extends JFrame {

	private JButton comparar,buscar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra;
	private JLabel label_f1,label_f2,label_pal;
	private JCheckBox primera;
	
	private JPanel panel;
	private JButton copiar;
	private JPanel panelCrearLibro;
	private JTextField identificador;
	private JLabel id;
	public JTextField getIdentificador() {
		return identificador;
	}

	public void setIdentificador(JTextField identificador) {
		this.identificador = identificador;
	}

	public JTextField getTitulo() {
		return titulo;
	}

	public void setTitulo(JTextField titulo) {
		this.titulo = titulo;
	}

	public JTextField getAutor() {
		return autor;
	}

	public void setAutor(JTextField autor) {
		this.autor = autor;
	}

	public JTextField getAnyo() {
		return anyo;
	}

	public void setAnyo(JTextField anyo) {
		this.anyo = anyo;
	}

	public JTextField getEditor() {
		return editor;
	}

	public void setEditor(JTextField editor) {
		this.editor = editor;
	}

	public JTextField getPaginas() {
		return paginas;
	}

	public void setPaginas(JTextField paginas) {
		this.paginas = paginas;
	}

	public JButton getBtnCrearLibro() {
		return btnCrearLibro;
	}

	public void setBtnCrearLibro(JButton btnCrearLibro) {
		this.btnCrearLibro = btnCrearLibro;
	}

	private JLabel title;
	private JTextField titulo;
	private JLabel lblAutor;
	private JTextField autor;
	private JLabel lblAnyo;
	private JTextField anyo;
	private JLabel lblEditor;
	private JTextField editor;
	private JLabel lblPaginas;
	private JTextField paginas;
	private JButton btnCrearLibro;
	private Component horizontalStrut;
	private JButton btnRecuperar;
	private JButton btnListar;
	
	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		
		primera = new JCheckBox("Primera aparición");

		textArea = new JTextArea(20, 80);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		copiar = new JButton("Copiar origen a destino");
		
		panel.add(copiar);
		panel.add(comparar);
		panel.add(buscar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		panel.add(scroll);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);
        
        panelCrearLibro = new JPanel();
        getContentPane().add(panelCrearLibro, BorderLayout.SOUTH);
        
        id = new JLabel("ID:");
        panelCrearLibro.add(id);
        
        identificador = new JTextField();
        panelCrearLibro.add(identificador);
        identificador.setColumns(10);
        
        title = new JLabel("Titulo:");
        panelCrearLibro.add(title);
        
        titulo = new JTextField();
        panelCrearLibro.add(titulo);
        titulo.setColumns(10);
        
        lblAutor = new JLabel("Autor:");
        panelCrearLibro.add(lblAutor);
        
        autor = new JTextField();
        panelCrearLibro.add(autor);
        autor.setColumns(10);
        
        lblAnyo = new JLabel("Anyo:");
        panelCrearLibro.add(lblAnyo);
        
        anyo = new JTextField();
        panelCrearLibro.add(anyo);
        anyo.setColumns(10);
        
        lblEditor = new JLabel("Editor:");
        panelCrearLibro.add(lblEditor);
        
        editor = new JTextField();
        panelCrearLibro.add(editor);
        editor.setColumns(10);
        
        lblPaginas = new JLabel("Paginas:");
        panelCrearLibro.add(lblPaginas);
        
        paginas = new JTextField();
        panelCrearLibro.add(paginas);
        paginas.setColumns(10);
        
        horizontalStrut = Box.createHorizontalStrut(20);
        panelCrearLibro.add(horizontalStrut);
        
        btnCrearLibro = new JButton("Nuevo libro");
        panelCrearLibro.add(btnCrearLibro);
        
        btnRecuperar = new JButton("R.Libro");
        panelCrearLibro.add(btnRecuperar);
        
        btnListar = new JButton("Listar libros");
        panelCrearLibro.add(btnListar);
		
	}	
	
	public JButton getBtnListar() {
		return btnListar;
	}

	public void setBtnListar(JButton btnListar) {
		this.btnListar = btnListar;
	}

	public JButton getBtnRecuperar() {
		return btnRecuperar;
	}

	public void setBtnRecuperar(JButton btnRecuperar) {
		this.btnRecuperar = btnRecuperar;
	}

	public JButton getCopiar() {
		return copiar;
	}

	public void setCopiar(JButton copiar) {
		this.copiar = copiar;
	}

	public JCheckBox getPrimera() {
		return primera;
	}

	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}

	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}

	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}


}
