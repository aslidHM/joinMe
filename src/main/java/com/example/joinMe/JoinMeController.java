package com.example.joinMe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller

public class JoinMeController {

    @Autowired
    private JoinMeRepository repository;

    @GetMapping("/login")
    public String login (Model model) {
        return "signIn";
    }

    @GetMapping("/")
    public String initialize () {
        return "index";
    }
    @GetMapping("/contact")
    public String contact () {
        return "contact";
    }

    @GetMapping("/activities")
    public String getAllActivities (Model model) throws ParseException {

        List<Activity> activities = repository.getActivities();
        model.addAttribute("activities", activities);
        return "activity";
    }

    @PostMapping("/activities/{categoryID}")
    public String getActivitiesByCategory (@PathVariable int categoryID, Model model) {
        //get activities by category
        model.addAttribute("activities", repository.getActivityByCategory(categoryID));
        return "activities";
    }

    @PostMapping("/activities/{memberID}")
    public String getActivitiesMember (@PathVariable int memberID, Model model) {
        //get activities by category
        // model.addAttribute("activities", repository.getActivitiesByMember(memberID));
        return "activities";
    }

    @GetMapping("/addActivity")
    public String addActivity (@PathVariable int memberID, @ModelAttribute Activity activity) {
       // Activity a = new Activity(0, "Åsas activity", "asa.lindkvist@hm.com", 8, DateUtil.toModelDate("2020-12-14 13:00"), "Hemma", 1, 1);

        repository.addActivity(activity, memberID);
        return "activity";
    }
    @GetMapping("/editActivity")
    public String editActivity (@ModelAttribute Activity activity) {
       /* Activity a = new Activity(0, "Åsas activity", "asa.lindkvist@hm.com", 8, DateUtil.toModelDate("2020-12-14 13:00"), "Hemma", 1, 1);
        repository.addActivity(a, 2);
        a.setID(5);
        a.setActivityName("Åsas editerade aktivitet");*/

        repository.editActivity(activity);
        return "activity";
    }

    @GetMapping("/addMemberToActivity")
    public String addMemberToActivity (@PathVariable int memberID, @PathVariable int activityId) {

        repository.addMemberToActivity(memberID, activityId);
        return "activity";
    }

    @GetMapping("/deleteActivity")
    public String deleteActivity (@PathVariable int activityId) {
        repository.deleteActivity(activityId);
        return "activity";
    }

    @GetMapping("/deleteMemberFromActivity")
    public String deleteMemberFromActivity (@PathVariable int activityId, @PathVariable int memberId) {
        repository.deleteMemberFromActivity(activityId, memberId);
        return "activity";
    }


    @PostMapping("/tryLogin")
    String form(@RequestParam String email, String password, Model model, HttpSession session) {
        Member member = repository.CheckMemberLogin(email, password);
        if(member!=null){
            session.setAttribute("member", member);
            return "index";
        }
        else{
            model.addAttribute("message", "Wrong email or password, please try again");
            return "signIn";
        }

    }

    @GetMapping("/logout")
    String logout(HttpSession session) {
        session.removeAttribute("member");
        session.removeAttribute("newMember");
        return "signIn";
    }
}
