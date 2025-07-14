package com.example.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.intranet.model.Employe;
import com.example.intranet.repository.EmployeRepository;

@Controller
public class EmployeController {

    private final EmployeRepository employeRepository;

    public EmployeController(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @GetMapping("/employes")
    public String listEmployes(Model model) {
        model.addAttribute("employes", employeRepository.findAll());
        return "employes";
    }

    @GetMapping("/ajouter-employe")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("employe", new Employe());
        return "ajouter_employe";
    }

    @PostMapping("/ajouter-employe")
    public String enregistrerEmploye(@ModelAttribute Employe employe) {
        employeRepository.save(employe);
        return "redirect:/employes";
    }
    
    // Afficher le formulaire de modification
    @GetMapping("/employes/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable Long id, Model model) {
        Employe emp = employeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Employé non trouvé : " + id));
        model.addAttribute("employe", emp);
        return "modifier_employe";
    }

    // Enregistrer la modification
    @PostMapping("/employes/modifier/{id}")
    public String modifierEmploye(@PathVariable Long id, @ModelAttribute Employe employe) {
        employe.setId(id);
        employeRepository.save(employe);
        return "redirect:/employes";
    }

    // Supprimer un employé
    @GetMapping("/employes/supprimer/{id}")
    public String supprimerEmploye(@PathVariable Long id) {
        employeRepository.deleteById(id);
        return "redirect:/employes";
    }
}
