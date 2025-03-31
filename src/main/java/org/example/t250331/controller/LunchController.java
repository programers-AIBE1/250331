package org.example.t250331.controller;

import org.example.t250331.domain.Lunch;
import org.example.t250331.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lunch")
public class LunchController {

    private final LunchService lunchService;

    public LunchController(LunchService lunchService) {
        this.lunchService = lunchService;
    }

    @GetMapping
    public String recommendLunch(Model model) {
        Lunch lunch = lunchService.getRandomLunch();
        model.addAttribute("lunch", lunch);
        return "lunch";
    }
}