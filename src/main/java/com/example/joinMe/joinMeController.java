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


    @GetMapping("/login")
    public String login (Model model) {
        return "login";
    }

    @GetMapping("/activities")
    public String getAllActivities (Model model) {
        //get activities by category
        model.addAttribute("activities", joinMeService.getActivities());
        return "activities";
    }

    @PostMapping("/activities/{categoryID}")
    public String getActivitiesByCategory (@PathVariable int categoryID, Model model) {
        //get activities by category
       //model.addAttribute("activities", joinMeService.getActivities(categoryID));
        return "activities";
    }

    @PostMapping("/activities/{memberID}")
    public String getActivitiesMember (@PathVariable int memberID, Model model) {
        //get activities by category
        model.addAttribute("activities", joinMeService.getActivitiesByMember(memberID));
        return "activities";
    }

  @GetMapping("/addActivity")
   public String addActivity (@ModelAttribute Activity activity) {
        //save new activity
         joinMeService.createActivity(activity);
         return "addActivity";
   }
    @GetMapping("/editActivity")
    public String editActivity (@ModelAttribute Activity activity) {
        //save new activity
      //  joinMeService.createActivity(activity);
        return "activity";
    }

    @GetMapping("/deleteActivity")
    public void deleteActivity (@ModelAttribute Activity activity) {
        //delete activity
        int activityID = activity.getID();
        joinMeService.deleteActivity(activityID);
    }
}
