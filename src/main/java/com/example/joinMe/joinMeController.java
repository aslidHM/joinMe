package com.example.joinMe;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class joinMeController {



    @GetMapping("/activities/{memberID}")
    public String activities (Model model) {

        List<Activity> member = new ArrayList<>();
        // todo get all customersmodel.addAttribute("customers", customers);

        return "customers";
    }
}
