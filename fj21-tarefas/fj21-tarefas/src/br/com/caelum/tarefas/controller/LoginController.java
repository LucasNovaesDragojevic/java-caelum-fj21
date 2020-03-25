package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.caelum.tarefas.dao.UsuarioDao;
import br.com.caelum.tarefas.model.Usuario;

@Controller
public class LoginController {

	@RequestMapping("loginForm")
    public String loginForm() 
	{
		System.out.println("Indo para a página de login");
        return "formulario-login";
    }
	
	@RequestMapping("efetuaLogin")
    public String efetuaLogin(Usuario usuario, HttpSession session) throws ClassNotFoundException 
	{
        if(new UsuarioDao().existeUsuario(usuario)) 
        {
        	System.out.println("Usuário existe. Logando.");
            session.setAttribute("usuarioLogado", usuario);
            return "menu";
        }
        System.out.println("Usuário não existe.");
        return "redirect:loginForm";
    }
	
	@RequestMapping("logout")
	public String logout (HttpSession session) 
	{
        session.invalidate();
        return "redirect:loginForm";
    }
}
