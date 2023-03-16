package pweb.aula1602.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pweb.aula1602.model.dao.PessoaDAO;
import pweb.aula1602.model.entity.Pessoa;
import pweb.aula1602.model.repository.PessoaRepository;

@Controller
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @GetMapping("/list")
    public String list(ModelMap model){
        model.addAttribute("pessoas",repository.pessoas());
        return "/pessoa/list"; //apontando para a view.html
    }

    /**
     * @param pessoa necessário devido utilizar no form.html o th:object que faz referência ao objeto esperado no controller.
     * @return
     */
    @GetMapping("/form")
    public ModelAndView form(Pessoa pessoa){
        return new ModelAndView("/pessoa/form");
    }

    @PostMapping("/save")
    public ModelAndView save(Pessoa pessoa, RedirectAttributes redirect){
        repository.save(pessoa);
        redirect.addFlashAttribute("sucesso","Armazenado com sucesso!");
        return new ModelAndView("redirect:/pessoas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", repository.pessoa(id));
        return new ModelAndView("/pessoa/form", model);
    }

}
