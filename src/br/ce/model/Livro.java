package br.ce.model;

public class Livro {
	
	private int id;
	private String titulo;
	private String genero;
	private String autor;
	private int qtdDePaginas;
	private String comentarios;
	private String usuarioLogin;
	private Integer status;
	private String codigo;
	private Pontos ponto;
	
	
	public Pontos getPonto() {
		return ponto;
	}
	public void setPonto(Pontos ponto) {
		this.ponto = ponto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getQtdDePaginas() {
		return qtdDePaginas;
	}
	public void setQtdDePaginas(int qtdDePaginas) {
		this.qtdDePaginas = qtdDePaginas;
	}
	
	public String getUsuarioLogin() {
		return usuarioLogin;
	}
	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
  }
