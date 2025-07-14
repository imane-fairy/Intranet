package com.example.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.intranet.model.Retard;
import com.example.intranet.repository.EmployeRepository;
import com.example.intranet.repository.RetardRepository;

@Controller
public class RetardController {

    private final RetardRepository retardRepository;
    private final EmployeRepository employeRepository;

    public RetardController(RetardRepository retardRepository, EmployeRepository employeRepository) {
        this.retardRepository = retardRepository;
        this.employeRepository = employeRepository;
    }

    @GetMapping("/retards")
    public String listeRetards(Model model) {
        model.addAttribute("retards", retardRepository.findAll());
        return "retards";
    }


       @GetMapping("/retards/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("retard", new Retard());
        model.addAttribute("employes", employeRepository.findAll());
        return "ajouter_retard";
    }


    @PostMapping("/retards/ajouter")
    public String enregistrerRetard(@ModelAttribute Retard retard) {
        retard.setStatut("En attente");
        retardRepository.save(retard);
        return "redirect:/retards";
    }
}

