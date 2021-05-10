package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario consultarUsuario (Usuario usuario);
	  public List<Usuario> getUsuarios();

	  void save(Usuario usuario);

	 Usuario findById(int id);

	 void borrarUsuario(Usuario usuario);

	 void update(Usuario usuario);
}
