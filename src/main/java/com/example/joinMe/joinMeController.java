package com.example.joinMe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class joinMeController {

    @Autowired
    private joinMeService joinMeservice;

    @GetMapping("/")
    public String getAllActivities (Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String login (Model model) {
        return "login";
    }

    @PostMapping("/activities/{categoryID}")
    public String getActivitiesByCategory (@PathVariable int categoryID, Model model) {

        List<Activity> member = new ArrayList<>();
        // todo get all customersmodel.addAttribute("customers", customers);

        return "activities";
    }
    @GetMapping("/activities")
    public String addActivities (Model model) {

        List<Activity> member = new ArrayList<>();

        Activity newActivity = new Activity();
        // todo get all customersmodel.addAttribute("customers", customers);
        joinMeservice.addActivity(newActivity);
        return "addActivity";
    }
}
