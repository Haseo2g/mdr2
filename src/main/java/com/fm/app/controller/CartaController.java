package com.fm.app.controller;

import com.fm.app.model.Carta;
import com.fm.app.model.Drops;
import com.fm.app.model.Fusao;
import com.fm.app.repository.CartaRepository;
import com.fm.app.repository.DropsRepository;
import com.fm.app.repository.EquipamentoRepository;
import com.fm.app.repository.FusaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class CartaController {
    @Autowired
    private CartaRepository cartaRepository;

    @Autowired
    private FusaoRepository fusaoRepository;

    @Autowired
    private DropsRepository dropsRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

//    @GetMapping("/card")
//    public ModelAndView listarCartas() {
//        List<Carta> cards = cartaRepository.findAll();
//        System.out.println(cards.size());
//        ModelAndView mav = new ModelAndView("cartas");
//        mav.addObject("cartas", cards);
//        return mav;
//    }

//    @GetMapping("/cards")
//    public ModelAndView listarCartas2() {
//        List<Carta> cards = cartaRepository.findAll();
//        System.out.println(cards.size());
//        ModelAndView mav = new ModelAndView("cards");
//        mav.addObject("cartas", cards);
//        return mav;
//    }

    @GetMapping("/card/{id}")
    public ModelAndView listarCartas2(
            @PathVariable(required = false) Integer id) {
        Carta card = cartaRepository.findById(id).get();
        ModelAndView mav = new ModelAndView("card/cardX");
        mav.addObject("carta", card);
        mav.addObject("fusoes", fusaoRepository.findByMaterial(id));
        mav.addObject("resultado", fusaoRepository.findByResult(id));
        if (card.getType().equals(Carta.TYPE.EQUIP)) {
            mav.addObject("equipable", equipamentoRepository.findEquipableCards(id));
        } else if (card.getTypeOrdinal() < 20) {
            mav.addObject("equips", equipamentoRepository.findEquipCards(id));
        }

        Map<Carta, List<Carta>> fusoesAgrupadas = new HashMap<>();

        List<Fusao> fusoes = fusaoRepository.findByMaterial(id);

        for (Fusao fusao : fusoes) {
            Carta result = fusao.getResult();
            Carta outroMaterial = fusao.getCarta1().getId().equals(id) ? fusao.getCarta2() : fusao.getCarta1();

            fusoesAgrupadas.computeIfAbsent(result, k -> new ArrayList<>()).add(outroMaterial);
        }

        mav.addObject("fusoesAgrupadas", fusoesAgrupadas);


        List<Drops> drops = dropsRepository.findByCarta(id);
        List<Drops> decks = new ArrayList<>();
        Iterator<Drops> iterator = drops.iterator();

        while (iterator.hasNext()) {
            Drops drop = iterator.next();
            if (drop.getRank() == Drops.CARD_ORIGIN.DECK) {
                decks.add(drop);
                iterator.remove(); // remove da lista original
            }
        }

        mav.addObject("drops", drops);
        mav.addObject("decks", decks);

        return mav;
    }

    @GetMapping("/cards")
    public ModelAndView listarCartasFiltradas(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Integer atk,
            @RequestParam(required = false) Integer def,
            @RequestParam(required = false) String type
    ) {
        List<Carta> cartas;

        if (nome == null && atk == null && def == null && type == null) {
            System.out.println("caiu no 1");
            cartas = cartaRepository.findAll();
        } else {
            System.out.println("caiu no 2");
            if (nome != null && nome.trim().isEmpty()) nome = null;
            if (type != null && type.trim().isEmpty()) type = null;
            cartas = cartaRepository.findByFilters(nome, atk, def, type);
        }
        System.out.println(cartas.size());

        ModelAndView mav = new ModelAndView("cards");
        mav.addObject("cartas", cartas);
        return mav;
    }

}
