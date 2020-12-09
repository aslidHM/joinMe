package com.example.joinMe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class JoinMeController {

    @Autowired
    private JoinMeService joinMeService;

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
        //get activities by category
       //model.addAttribute("activities", joinMeService.getActivities(categoryID));
        return "activities";
    }
//    @GetMapping("/addActivity")
//    public String addActivity (@ModelAttribute Activity activity) {
//        //save new activity
//       //  joinMeService.createActivity(activity);
//         return "addActivity";
//    }
//    @GetMapping("/editActivity")
//    public String editActivity (@ModelAttribute Activity activity) {
//        //save new activity
//      //  joinMeService.createActivity(activity);
//        return "editActivity";
//    }
}
