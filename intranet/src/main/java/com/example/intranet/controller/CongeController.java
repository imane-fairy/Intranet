package com.example.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.intranet.model.Conge;
import com.example.intranet.repository.CongeRepository;
import com.example.intranet.repository.EmployeRepository;
import com.example.intranet.repository.TypeCongeRepository;

@Controller
public class CongeController {

    private final CongeRepository congeRepository;
    private final EmployeRepository employeRepository;
    private final TypeCongeRepository typeCongeRepository;

    public CongeController(CongeRepository congeRepository, EmployeRepository employeRepository,
                           TypeCongeRepository typeCongeRepository) {
        this.congeRepository = congeRepository;
        this.employeRepository = employeRepository;
        this.typeCongeRepository = typeCongeRepository;
    }

    @GetMapping("/conges")
    public String listConges(Model model) {
        model.addAttribute("conges", congeRepository.findAll());
        return "conges";
    }

    @GetMapping("/conges/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("conge", new Conge());
        model.addAttribute("employes", employeRepository.findAll());
        model.addAttribute("typesConge", typeCongeRepository.findAll());
        return "ajouter_conge";
    }

    @PostMapping("/conges/ajouter")
    public String enregistrerConge(@ModelAttribute Conge conge) {
        conge.setStatut("En attente");
        congeRepository.save(conge);
        return "redirect:/conges";
    }
}
