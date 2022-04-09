package com.example.rekrutacjasuncode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class MainController {

    private final List<String> list;

    @Autowired
    public MainController() {
        this.list = new ArrayList<>(Arrays.asList("id", "kolumna1", "kolumna2", "kolumna3", "kolumna4"));
    }

    @GetMapping("/")
    public String showMainPage(Model theModel){
        theModel.addAttribute("columns", list);
        return "dashboard";
    }

}
