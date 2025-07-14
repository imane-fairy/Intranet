package com.example.intranet.controller;

import com.example.intranet.model.Absence;
import com.example.intranet.repository.AbsenceRepository;
import com.example.intranet.repository.EmployeRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AbsenceController {

    private final AbsenceRepository absenceRepository;
    private final EmployeRepository employeRepository;

    public AbsenceController(AbsenceRepository absenceRepository, EmployeRepository employeRepository) {
        this.absenceRepository = absenceRepository;
        this.employeRepository = employeRepository;
    }

    @GetMapping("/absences")
    public String listeAbsences(Model model) {
        model.addAttribute("absences", absenceRepository.findAll());
        return "absences";
    }

    @GetMapping("/absences/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("absence", new Absence());
        model.addAttribute("employes", employeRepository.findAll());
        return "ajouter_absence";
    }

    @PostMapping("/absences/ajouter")
    public String enregistrerAbsence(@ModelAttribute Absence absence) {
        absence.setStatut("En attente");
        absenceRepository.save(absence);
        return "redirect:/absences";
    }
}

