package com.example.joinMe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinMeService {

    @Autowired
    JoinMeRepository joinMeRepository;

    private List<Activity> activities;

    public List<Activity> getActivities(int categoryID) {
        //get all activities for a specific category
        return joinMeRepository.findByCategoryId(categoryID);
    }

    // update one activity
    public Activity createActivity(Activity activity) {
        return joinMeRepository.save(activity);
    }

    // delete an activity
    public void deleteActivity(int activityId) {
        Activity activityToDelete = this.getActivity(activityId);
        if (activityToDelete != null) {
            joinMeRepository.delete(activityToDelete);
        }
    }

    // get one Activity
    public Activity getActivity(int activityID) {

        return joinMeRepository.findById(activityID).get();
    }

}
