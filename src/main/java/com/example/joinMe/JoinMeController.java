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
    public String login(Model model) {
        return "signIn";
    }

    @GetMapping("/")
    public String initialize() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/activities")
    public String getAllActivities(Model model) throws ParseException {
        getActivities(model);
        return "activity";
    }

    @PostMapping("/activities/{categoryID}")
    public String getActivitiesByCategory(@PathVariable int categoryID, Model model) {
        model.addAttribute("activities", repository.getActivityByCategory(categoryID));
        return "activity";
    }

    @PostMapping("/activities/{memberID}")
    public String getActivitiesMember(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        repository.getActivityForMember(member.getMemberID());
        return "activity";
    }

    @PostMapping("/addActivity")
    public String addActivity(Model model, @ModelAttribute Activity newActivity, @ModelAttribute DisplayDateAndTime displayDateAndTime, HttpSession session) {
        // Activity a = new Activity(0, "Åsas activity", "asa.lindkvist@hm.com", 8, DateUtil.toModelDate("2020-12-14 13:00"), "Hemma", 1, 1);

        newActivity.updateWithDisplayDateAndTime(displayDateAndTime);
        Member member = (Member) session.getAttribute("member");

        newActivity.setEmail(member.getEmail());
        newActivity.setIsOwner(1);
        repository.addActivity(newActivity, member.getMemberID());

        getActivities(model);
        return "activity";
    }

    @GetMapping("/editActivity")
    public String editActivity(@ModelAttribute Activity activity) {
       /* Activity a = new Activity(0, "Åsas activity", "asa.lindkvist@hm.com", 8, DateUtil.toModelDate("2020-12-14 13:00"), "Hemma", 1, 1);
        repository.addActivity(a, 2);
        a.setID(5);
        a.setActivityName("Åsas editerade aktivitet");*/

        repository.editActivity(activity);
        return "activity";
    }

    @PostMapping("/addMemberToActivity")
    public String addMemberToActivity(@RequestParam int activityId, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        repository.addMemberToActivity(activityId, member.getMemberID());

        return "redirect:/activities";
    }

    @GetMapping("/deleteActivity")
    public String deleteActivity(@PathVariable int activityId) {
        repository.deleteActivity(activityId);
        return "activity";
    }

    @GetMapping("/deleteMemberFromActivity")
    public String deleteMemberFromActivity(@PathVariable int activityId, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        repository.deleteMemberFromActivity(activityId, member.getMemberID());
        return "activity";
    }


    @PostMapping("/tryLogin")
    String form(@RequestParam String email, String password, Model model, HttpSession session) {
        Member member = repository.CheckMemberLogin(email, password);
        if (member != null) {
            session.setAttribute("memberId", member.getMemberID());
            session.setAttribute("fullName", member.getFullName());
            session.setAttribute("email", member.getEmail());
            session.setAttribute("password", member.getPassword());
            session.setAttribute("member", member);
            return "index";
        } else {
            model.addAttribute("message", "Wrong email or password, please try again");
            return "signIn";
        }

    }

    @GetMapping("/logout")
    String logout(HttpSession session) {
        session.removeAttribute("memberId");
        session.removeAttribute("fullName");
        session.removeAttribute("email");
        session.removeAttribute("password");
        session.removeAttribute("newMember");
        session.removeAttribute("member");
        return "index";
    }

    @PostMapping("/addMember")
    String addMember(@PathVariable String fullName, @PathVariable String email, @PathVariable String password, HttpSession session) {

        repository.addMember(fullName, email, password);
        return "index";
    }
private void getActivities(Model model){
    String displayDate = "";
    String displayTime = "";
    List<Activity> activities = repository.getActivities();
    List<Category> categories = repository.getCategories();

    model.addAttribute("activities", activities);
    model.addAttribute("categories", categories);
    model.addAttribute("displayDateAndTime", new DisplayDateAndTime());

    //Activity a = new Activity();
    //a.setActivityName("new XXXX");
    model.addAttribute("newActivity", new Activity());


}

}
