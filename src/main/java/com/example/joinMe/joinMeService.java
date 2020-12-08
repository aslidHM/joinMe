package com.example.joinMe;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class joinMeService {


    private List<Activity> activities;

    // edit an activity
    public Activity editActivity(Activity activity) {
        Activity activityToEdit = this.getActivity(activity.getID());

        return activity;
    }

    // delete an activity
    public void deleteBook(int id) {
        Activity activityToDelete = this.getActivity(id);
      // if (bookToDelete != null) {
            activities.remove(activityToDelete);
       // }
    }


    // get one Activity
    public Activity getActivity(int id) {
        for (Activity activity : activities) {
            if (activity.getID()==id) {
                return activity;
            }
        }
        return null;
    }

    public Activity addActivity (Activity activity){
    // to do update activity

        return activity;
    }
}
