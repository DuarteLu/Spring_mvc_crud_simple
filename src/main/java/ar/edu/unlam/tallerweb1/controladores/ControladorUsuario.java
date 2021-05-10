package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {
	
	@Autowired
	ServicioUsuario usuarioServicio;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String getUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioServicio.getUsuarios());
		return "usuarios";
	}
	
	@RequestMapping(value = "/agregar", method = RequestMethod.GET)
	public String agregar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarioFormulario";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(@ModelAttribute("usuario") Usuario usuario) {
		usuarioServicio.save(usuario);
		return "redirect:/lista";
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	 public String editar(@RequestParam(name="id") int id,Model model) {
		model.addAttribute("usuario", usuarioServicio.buscarPorId(id));
		return "usuarioFormulario";

	}
	
	@RequestMapping(value = "/guardarEdicion", method = RequestMethod.POST)
	public String guardarEdicion(@ModelAttribute("usuario") Usuario usuario) {
		usuarioServicio.editar(usuario);
		return "redirect:/lista";
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public String eliminar(@RequestParam(name="id") int id) {
		usuarioServicio.eliminar(id);
		return "redirect:/lista";
	}

}
