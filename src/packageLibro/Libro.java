package packageLibro;

import java.io.Serializable;

public class Libro implements Serializable{
	
	private String id_libro;
	private String titulo;
	private String autor;
	private String a�o_publicacion;
	private String editor;
	private String num_paginas;
	
	public Libro(){
		
	}
	
	public Libro(String id,String t,String a,String p, String e, String n){
		id_libro=id;
		titulo=t;
		autor=a;
		a�o_publicacion=p;
		editor=e;
		num_paginas=n;
	}
	
	public String mostrarDatos(){
		String datos = " ";
		datos+=("Identificador: "+ this.id_libro +"\n");
		datos+=("Titulo: "+ this.titulo +"\n");
		datos+=("Autor: "+ this.autor +"\n");
		datos+=("A�o publicacion: "+ this.a�o_publicacion +"\n");
		datos+=("Editor: "+ this.editor +"\n");
		datos+=("Paginas: "+ this.num_paginas +"\n\n");
	
		
		return datos;
	}

	public String getId_libro() {
		return id_libro;
	}

	public void setId_libro(String id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getA�o_publicacion() {
		return a�o_publicacion;
	}

	public void setA�o_publicacion(String a�o_publicacion) {
		this.a�o_publicacion = a�o_publicacion;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getNum_paginas() {
		return num_paginas;
	}

	public void setNum_paginas(String num_paginas) {
		this.num_paginas = num_paginas;
	}
}