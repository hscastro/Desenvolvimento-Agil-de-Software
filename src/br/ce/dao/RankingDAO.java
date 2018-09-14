package br.ce.dao;

import java.util.List;

import br.ce.model.Livro;
import br.ce.model.Pontos;
import br.ce.model.Usuario;

public interface RankingDAO {
	
   public abstract boolean adicionarPontos(Usuario usuario, Livro livro);   
   List<Pontos> listaTodos();
   List<Pontos> listaTodos(Usuario login);	
	
}
