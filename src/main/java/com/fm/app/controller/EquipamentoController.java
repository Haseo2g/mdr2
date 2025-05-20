package com.fm.app.controller;

import com.fm.app.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipamentoController {
    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @GetMapping("/equipamentos")
    public String listarEquipamentos(Model model) {
        model.addAttribute("equipamentos", equipamentoRepository.findAll());
        return "equipamentos";
    }
}
