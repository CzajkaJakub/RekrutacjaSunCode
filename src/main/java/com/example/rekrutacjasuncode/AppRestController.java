package com.example.rekrutacjasuncode;

import com.example.rekrutacjasuncode.Dao.SearchType;
import com.example.rekrutacjasuncode.Entity.Data;
import com.example.rekrutacjasuncode.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AppRestController {

    private final DataService dataService;

    @Autowired
    public AppRestController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/showRows")
    public List<Data> showResponse(@RequestParam String column,
                               @RequestParam SearchType searchType){
        return dataService.getRows(column, searchType);
    }
}
