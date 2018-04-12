package com.reader.rezume.controller;

import com.reader.rezume.entity.PersonalData;
import com.reader.rezume.repository.PropertyRepository;
import com.reader.rezume.service.RezumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class RezumeController {

    @Autowired
    private RezumeService rezumeService;

    @Autowired
    private PropertyRepository propertyRepository;

    @RequestMapping("/rezume")
    public String setRezumeInfo(Model model) throws IOException {
        model.addAttribute("rezume", rezumeService.getProperties());
        return "rezume";
    }

    @GetMapping("/save")
    @ResponseBody
    public String save() throws IOException {
        propertyRepository.save(rezumeService.getProperties());
        return "Save complete";
    }

    @RequestMapping("/re")
    public String RezumeInfo(Model model) throws IOException {
        List<PersonalData>personalData = propertyRepository.findAll();
        for (PersonalData personalDatum : personalData) {
            model.addAttribute("rezume", personalDatum);
        }
        return "rezume";
    }
}
