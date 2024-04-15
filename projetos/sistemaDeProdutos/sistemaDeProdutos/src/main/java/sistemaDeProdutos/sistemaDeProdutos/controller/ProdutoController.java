package sistemaDeProdutos.sistemaDeProdutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.persistence.EntityManager;
import sistemaDeProdutos.sistemaDeProdutos.model.ProdutoTO;
import sistemaDeProdutos.sistemaDeProdutos.model.RelatorioTO;
import sistemaDeProdutos.sistemaDeProdutos.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	ProdutoRepository pr;
	
	@GetMapping("/produtoFormRota")
	public String produtoFormularioGet() {
		return "cadastroProduto";
	}
	
	
	@PostMapping("/produtoFormRota")
	public String cadastroProdutoPost(ProdutoTO obj) {
		pr.save(obj);
		return "redirect:/listaProdutosRota";
	}
	
	@GetMapping("/listaProdutosRota")
	public ModelAndView listarProdutos() {
		ModelAndView produtoMV = new ModelAndView("listaProdutos");
		List<ProdutoTO> listaProdutos = (List<ProdutoTO>)pr.findAll();
		
		produtoMV.addObject("produtos", listaProdutos);
		
		return produtoMV;
	}
	
	@RequestMapping("/deletar")
	public String deletarProduto(long id) {
		
		ProdutoTO produto = pr.findById(id);
		
		pr.delete(produto);
		
		return "redirect:/listaProdutosRota";
	}
	
	@RequestMapping("/editarProdutoRota")
	public ModelAndView editarProduto(long id) {
		ProdutoTO produto = pr.findById(id);
		ModelAndView produtoMV = new ModelAndView("editarProduto");
		produtoMV.addObject("produto", produto);
		
		return produtoMV;
	}
	
	@PostMapping("/editarProdutoRota")
	public String editarProdutoRota(ProdutoTO obj) {
		
		pr.save(obj);
		
		return "redirect:/listaProdutosRota";
	}
	
	@GetMapping("/relatorioRota")
	public ModelAndView precoTotalProdutos() {
		RelatorioTO relatorio = new RelatorioTO();
		List<ProdutoTO> produtos = (List<ProdutoTO>)pr.findAll();
		for(ProdutoTO produto : produtos) {
			relatorio.setValorTotalProdutos((produto.getQntdEstoque() * produto.getPrecoUnitario()) + relatorio.getValorTotalProdutos()); 
		}
		
		ModelAndView produtoMV = new ModelAndView("relatorio");
		produtoMV.addObject("relatorio", relatorio);
		
		return produtoMV;
	}
}
