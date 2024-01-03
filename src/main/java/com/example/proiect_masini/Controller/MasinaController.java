package com.example.proiect_masini.Controller;

import java.security.Principal;
import com.example.proiect_masini.Model.Masina;
import com.example.proiect_masini.Model.SecurityUser;
import com.example.proiect_masini.Model.Utilizator;
import com.example.proiect_masini.Repository.UtilizatorRepository;
import com.example.proiect_masini.Service.MasinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MasinaController {

    private final MasinaService masinaService;
    private final UtilizatorRepository utilizatorRepository;
    @Autowired
    public MasinaController(MasinaService masinaService, UtilizatorRepository utilizatorRepository) {
        this.masinaService = masinaService;
        this.utilizatorRepository = utilizatorRepository;
    }

    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/")
    public String showCars(Model model, @AuthenticationPrincipal SecurityUser utilizatorCurent,
                           @Param("filter1") String filter1, @Param("filter2") String filter2,
                           @Param("filter3") String filter3) {
        if(filter1==null && filter2==null && filter3==null) {
            model.addAttribute("masini", masinaService.findAll());
        }
        else {
            model.addAttribute("masini", masinaService.findAllByKeywords(filter1, filter2, filter3));
        }
        Masina masina = new Masina();
        model.addAttribute("masina", masina);
        model.addAttribute("utilizatorCurent", utilizatorRepository.findByUtilizator(utilizatorCurent.getUsername()));
        return "mainpage";
    }

    @PostMapping("/edit")
    public String editCar(@RequestParam("action") String action){
        if(action.equals("add"))
            return "forward:/add";
        if(action.equals("modify"))
            return "forward:/modify";
        if(action.equals("delete"))
            return "forward:/delete";
        return "redirect:/";
    }
    @PostMapping( "/add")
    public String addCar(Masina masina, @AuthenticationPrincipal SecurityUser securityUser)
    {
        masina.setId_utilizator(securityUser.getId());
        System.out.println(masina.toString());

        boolean notAdded = masinaService.addMasina(masina);
        if(notAdded)
            return "redirect:/?notAdded=true";
        return "redirect:/";
    }
    @PostMapping("/modify")
    public String modifyCar(Masina masina)
    {
        boolean notModified = masinaService.modifyMasina(masina);
        if(notModified)
            return "redirect:/?notModified=true";
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String deleteCar(Masina masina)
    {
        boolean notDeleted = masinaService.deleteMasina(masina);
        if(notDeleted)
            return "redirect:/?notDeleted=true";
        return "redirect:/";
    }
}
