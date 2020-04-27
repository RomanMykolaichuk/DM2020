/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.e4x.mit21.dm2020MIT21;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author 38068
 */
@Controller
public class TableSampleController {

    private final TableSampleRepository tableSampleRepository;

    @Autowired
    public TableSampleController(TableSampleRepository tableSampleRepository) {
        this.tableSampleRepository = tableSampleRepository;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("tableRows", tableSampleRepository.findAll());
        return "index";
    }
    
    @GetMapping("/signup")
    public String showAddForm(TableSample tableSample) {
        return "add-rows";
    }
    
     @PostMapping("/addrows")
    public String addUser(@Valid TableSample tableSample, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-rows";
        }

        tableSampleRepository.save(tableSample);
        model.addAttribute("tableRows", tableSampleRepository.findAll());
        return "index";
    }


}
