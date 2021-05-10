package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {
	 public List<Usuario> getUsuarios();
	 void save(Usuario usuario);
	 Usuario buscarPorId(int id);
	 void eliminar(int id);
	 void editar(Usuario usuario);

}
