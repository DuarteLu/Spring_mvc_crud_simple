package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;


@Service("ServicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {
	
	private RepositorioUsuario servicioUsuarioDao;
	
	@Autowired
	public ServicioUsuarioImpl(RepositorioUsuario servicioUsuarioDao){
		this.servicioUsuarioDao = servicioUsuarioDao;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return servicioUsuarioDao.getUsuarios();
	}

	@Override
	public void save(Usuario usuario) {
		servicioUsuarioDao.save(usuario);
		
	}

	@Override
	public Usuario buscarPorId(int id) {
	
		return servicioUsuarioDao.findById(id);
	}

	@Override
	public void eliminar(int id) {
		Usuario persona = buscarPorId(id);
		servicioUsuarioDao.borrarUsuario(persona);
		
	}

	@Override
	public void editar(Usuario usuario) {
		servicioUsuarioDao.update(usuario);		
		
	}

}
