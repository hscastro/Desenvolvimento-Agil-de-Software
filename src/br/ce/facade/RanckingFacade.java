package br.ce.facade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ce.conn.Conexao;
import br.ce.dao.RankingDAO;
import br.ce.model.Livro;
import br.ce.model.Pontos;
import br.ce.model.Usuario;

public class RanckingFacade implements RankingDAO {

	private int pontos;
	private int total;
	private int qtd_paginas;
	private Conexao conexao = new Conexao();
	private Connection conn;
	private List<Pontos> lista = new ArrayList<Pontos>();
	
	public RanckingFacade() {
		this.qtd_paginas = 0;
		this.pontos = 1;
		this.total = 0;
		this.conn = conexao.openConexao();
	}
	
	
	@Override
	public boolean adicionarPontos(Usuario usuario, Livro livro) {	
		
		qtd_paginas = livro.getQtdDePaginas();
				
		try{
			  if(qtd_paginas <= 100){
				 pontos+=1;				 
			  }else if(qtd_paginas >= 101 && qtd_paginas <= 200){
				 pontos+=2; 				  
			  }else if(qtd_paginas >= 201 && qtd_paginas <= 300){
				  pontos+=3;
			  }else{
				  pontos+=4;
			  }
			  
			  total+=pontos;
			
			  String insert = "INSERT INTO public.tb_pontos (livro_id, login, valor) VALUES (?,?,?)";
			
			  PreparedStatement pstm = conn.prepareStatement(insert);	
			
			  pstm.setInt(1, livro.getId());			
			  pstm.setString(2, usuario.getLogin());
			  pstm.setInt(3, total);	
			  			
			  int test = 0;
			 
			  test = pstm.executeUpdate();
			  conexao.closeConexao();
			 
			  if(test != 0){
				 System.out.println("Livro inserido com sucesso!");
				 return true;
			  }else{
				 System.out.println("Erro ao inserir o Livro!");
				 return false;
			 }
			  
						
		}catch(SQLException e){					 
			 e.printStackTrace();
		}
		
		return false;
	}

	
	@Override
	public List<Pontos> listaTodos() {
					
		String sql = "SELECT  g.genero AS genero, p.login As login, SUM(valor) AS total, count(genero) AS quant " +
								"FROM tb_pontos p, tb_livros l, tb_generos g "+
								"WHERE (p.livro_id = l.id_livro AND l.genero_id = g.id_genero) "+	
								"GROUP BY login, genero ORDER BY total DESC";
		try {
			PreparedStatement pstm = this.conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			Pontos ptn = null;
			
			while(rs.next()){
				ptn = new Pontos();				
				ptn.setLogin(rs.getString("login"));
				ptn.setValor(rs.getInt("total"));
				ptn.setGenero(rs.getString("genero"));
				ptn.setContador(rs.getInt("quant"));
				lista.add(ptn);
			}
			
			conexao.closeConexao();
												
		}catch(SQLException e) {			
			e.printStackTrace();
		}			
		
		return lista;
				
	}

	@Override
	public List<Pontos> listaTodos(Usuario user) {
		
		
		String sql = "SELECT  g.genero AS genero, p.login As login, SUM(valor) AS total, " +
				     " count(genero) AS quant FROM tb_pontos p, tb_livros l, tb_generos g "+
				     " WHERE (p.livro_id = l.id_livro AND l.genero_id = g.id_genero AND login = '"+user.getLogin()+"') "+	
				     " GROUP BY login, genero ORDER BY total DESC ";
					
		 
		try {
			PreparedStatement pstm = this.conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			Pontos ptn = null;
			
			while(rs.next()){
				ptn = new Pontos();				
				ptn.setLogin(rs.getString("login"));
				ptn.setValor(rs.getInt("total"));
				ptn.setGenero(rs.getString("genero"));
				ptn.setContador(rs.getInt("total"));
				lista.add(ptn);
			}
			
			conexao.closeConexao();
												
		}catch(SQLException e) {			
			e.printStackTrace();
		}			
		
		return lista;
				
	}


}
