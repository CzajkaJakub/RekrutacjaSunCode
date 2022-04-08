package com.example.rekrutacjasuncode;

import com.example.rekrutacjasuncode.Dao.ColumnInterface;
import com.example.rekrutacjasuncode.Entity.Data;
import com.example.rekrutacjasuncode.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    private final DataService dataService;

    private final List<String> list;

    @Autowired
    public MainController(DataService dataService) {
        this.dataService = dataService;
        this.list = new ArrayList<>();
        list.add("id");
        list.add("kolumna1");
        list.add("kolumna2");
        list.add("kolumna3");
        list.add("kolumna4");
    }

    @GetMapping("/")
    public String showMainPage(Model theModel){
        theModel.addAttribute("columns", list);
        return "dashboard";
    }

    @GetMapping("/response")
    public String showResponse(){
        Data data = dataService.findById(1L);
        System.out.println(data.getKolumna3());
        return "response";
    }
}
