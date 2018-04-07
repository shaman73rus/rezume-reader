package com.reader.rezume.controller;

import com.reader.rezume.service.RezumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class RezumeController {

    @Autowired
    @Qualifier("rezumeService")
    private RezumeService rezumeService;

    @RequestMapping("/rezume")
    public String getRezumeInfo(Model model) throws IOException {
        model.addAttribute("rezume", rezumeService.getProperties());
        return "rezume";
    }
}
