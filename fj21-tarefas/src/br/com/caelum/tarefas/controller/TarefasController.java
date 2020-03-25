package br.com.caelum.tarefas.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.caelum.tarefas.dao.TarefaDao;
import br.com.caelum.tarefas.model.Tarefa;

@Controller
public class TarefasController {
	
	private final TarefaDao tarefaDao;
	
	@Autowired
	public TarefasController (TarefaDao tarefaDao)
	{
		this.tarefaDao = tarefaDao;
	}
	
	@RequestMapping("novaTarefa")
	public String form()
	{
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona (@Valid Tarefa tarefa, BindingResult bindingResult)
	{
		if (bindingResult.hasFieldErrors("descricao"))
		{
			return "tarefa/formulario";
		}
		try 
		{
			tarefaDao.adiciona(tarefa);
			return "redirect:listaTarefas";
		}
		catch (Exception exception)
		{
			System.out.println("[ERRO TAREFAS]" + exception);
			return null;
		}
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) throws ClassNotFoundException
	{
		model.addAttribute("tarefas", tarefaDao.lista());
		return "tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) throws ClassNotFoundException
	{
		tarefaDao.remove(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) throws ClassNotFoundException
	{
		model.addAttribute("tarefa", tarefaDao.buscarPorId(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) throws ClassNotFoundException
	{
		tarefaDao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id) throws ClassNotFoundException
	{
		tarefaDao.finaliza(id);
		System.out.println("finaliza controller");
	}
}
