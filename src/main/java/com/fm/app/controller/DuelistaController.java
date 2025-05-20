package com.fm.app.controller;

import com.fm.app.model.Carta;
import com.fm.app.model.Drops;
import com.fm.app.model.Fusao;
import com.fm.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class DuelistaController {
    @Autowired
    private CartaRepository cartaRepository;

    @Autowired
    private FusaoRepository fusaoRepository;

    @Autowired
    private DropsRepository dropsRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private DuelistaRepository duelistaRepository;

    @GetMapping("/duelistas")
    public String listarDuelistas(Model model) {
        model.addAttribute("duelistas", duelistaRepository.findAll());
        return "duelistas";
    }

    @GetMapping("/duelists")
    public String duelistsList(Model model) {
        model.addAttribute("duelists", duelistaRepository.findAll());
        return "duelists";
    }


    @GetMapping("/duelist/{id}")
    public ModelAndView duelistDetails(
            @PathVariable(required = false) Integer id) {
        Carta card = cartaRepository.findById(id).get();
        ModelAndView mav = new ModelAndView("duelist/duelistX");
        mav.addObject("duelist", duelistaRepository.findById(id).get());

        List<Drops> drops = dropsRepository.findByDuelist(id);

        mav.addObject("drops", drops);
        return mav;
    }
}
