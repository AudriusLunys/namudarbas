package com.Audrius.NamuDarbas.namudarbas.controller;

import com.Audrius.NamuDarbas.namudarbas.model.Phone;
import com.Audrius.NamuDarbas.namudarbas.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/phones")
    public String findAll(Model model) {
        List<Phone> phones = phoneService.findAll();
        model.addAttribute("phones", phones);
        return "phone-list";
    }

    @GetMapping("/phone-create")
    public String createPhoneForm(Phone phone) {
        return "phone-create";
    }

    @PostMapping ("/phone-create")
    public String createPhone(Phone phone) {
        phoneService.savePhone(phone);
        return "redirect:/phones";
    }

    @GetMapping("phone-delete/{id}")
    public String deletePhone(@PathVariable("id") Long id){
        phoneService.deleteById(id);
        return "redirect:/phones";
    }

    @GetMapping("/phone-update/{id}")
    public String updatePhoneForm(@PathVariable("id") Long id, Model model){
        Phone phone = phoneService.findByID(id);
        model.addAttribute("phone", phone);
        return "phone-update";
    }

    @PostMapping("/phone-update")
    public String updatePhone(Phone phone){
        phoneService.savePhone(phone);
        return "redirect:/phones";
    }
}
