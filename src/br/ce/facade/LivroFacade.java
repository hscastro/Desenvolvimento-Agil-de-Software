package br.ce.facade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ce.conn.Conexao;
import br.ce.dao.LivroDAO;
import br.ce.model.Livro;


public class LivroFacade implements LivroDAO {
	private Connection conn;
	private Conexao conexao = new Conexao();
	private List<Livro> lista = new ArrayList<Livro>();

	public LivroFacade() {		
		this.conn = conexao.openConexao();
	}
		
		
	@Override
	public List<Livro> listarTodos() {
		
		String sql = "SELECT * FROM tb_livros LEFT JOIN tb_generos ON genero_id = id_genero";
				
		try {
			PreparedStatement pstm = this.conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			Livro liv = null;
			
			while(rs.next()){
				liv = new Livro();
				liv.setId(Integer.parseInt(rs.getString("id_livro")));
				liv.setTitulo(rs.getString("titulo"));
				liv.setGenero(rs.getString("genero"));
				liv.setAutor(rs.getString("autor"));				
				liv.setQtdDePaginas(Integer.parseInt(rs.getString("qtd_paginas")));
				liv.setStatus(Integer.parseInt(rs.getString("status")));				
				lista.add(liv);
			}
			
			conexao.closeConexao();
												
		}catch(SQLException e) {
			
			e.printStackTrace();
		}			
		
		return lista;
	}
	


}

