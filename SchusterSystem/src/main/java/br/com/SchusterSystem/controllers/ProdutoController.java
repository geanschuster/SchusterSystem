package br.com.SchusterSystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.SchusterSystem.models.Produto;
import br.com.SchusterSystem.repositories.ProdutoRepository;


@Controller
@RequestMapping(value="/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/lista")
	public String lista(Model model) {
		List<Produto> produto = this.produtoRepository.findAll();
		model.addAttribute("produto", produto);
		 return "produto/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		Produto produto = new Produto();
		List<Produto> list = produtoRepository.findAll();
		model.addAttribute("list", list);
		model.addAttribute("produto", produto);
		
		return "produto/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar (Produto produto) {
		produto = produto.toProduto();
		
		produtoRepository.save(produto);
		return "redirect:/produto/lista";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable Long id, Model model) {
	
		 Optional<Produto> optional = this.produtoRepository.findById(id);
		 
		 if (optional.isPresent()) {
			List<Produto> list = produtoRepository.findAll();
			model.addAttribute("list", list);
			 Produto produto = optional.get();
			 produto.fromProduto(produto);
			model.addAttribute(produto);
			
	    		return "/produto/editar";
			}else {
				return"redirect:/produto/lista";	
			}
	}
	
	
    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Optional<Produto> optional = this.produtoRepository.findById(id);
        
    	if (optional.isPresent()) {
			Produto produto = optional.get();
			
			model.addAttribute(produto);
    		return "/produto/detalhes";
    		
		}else {
			return"redirect:/produto/lista";	
		}
    }
	
	@PostMapping("/{id}/atualizar")
	public String atualizar(@PathVariable Long id,Produto produto) {
		Optional<Produto> optional = this.produtoRepository.findById(id);
		if(optional.isPresent()) {
			
			produto.toProdutoAtualizar(optional.get());
			
			this.produtoRepository.save(produto);
		
		}
		
		return"redirect:/produto/lista";
		
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		this.produtoRepository.deleteById(id);
		 return"redirect:/produto/lista";
		
	}
	
}
