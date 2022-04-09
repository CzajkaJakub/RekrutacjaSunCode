package com.example.rekrutacjasuncode;

import com.example.rekrutacjasuncode.Dao.SearchType;
import com.example.rekrutacjasuncode.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class MainController {

    private final DataService dataService;
    private final List<String> list;

    @Autowired
    public MainController(DataService dataService) {
        this.dataService = dataService;
        this.list = new ArrayList<>(Arrays.asList("id", "kolumna1", "kolumna2", "kolumna3", "kolumna4"));
    }

    @GetMapping("/")
    public String showMainPage(Model theModel){
        theModel.addAttribute("columns", list);
        return "dashboard";
    }

    @PostMapping("/showRows")
    public String showResponse(@RequestParam String column,
                               @RequestParam SearchType searchType,
                               Model theModel){
        theModel.addAttribute("columns", dataService.getRows(column, searchType));
        return "response";
    }
}
