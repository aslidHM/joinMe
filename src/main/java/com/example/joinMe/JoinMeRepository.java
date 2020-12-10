package com.example.joinMe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class JoinMeRepository {

    @Autowired
    private DataSource dataSource;


    public List<Activity> getActivities() {
        List<Activity> activities = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("Select * FROM ACTIVITY WHERE ActivityDate > ?");) {

            ps.setDate(1, (java.sql.Date) new Date());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                activities.add(rsActivity(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;


    }

    public List<Activity> getActivityByCategory(int categoryID) {
        List<Activity> activities = new ArrayList<>();
        Date currDate = new Date();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("Select *  FROM Activity WHERE ActivityDate > ? And CategoryId = ? ");) {

            ps.setDate(1, (java.sql.Date) currDate);
            ps.setInt(2, categoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                activities.add(rsActivity(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;


    }


    public List<Activity> getActivityForMember(int memberID) {
        List<Activity> activities = new ArrayList<>();
        Date currDate = new Date();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("Select a.*, m.IsOwner FROM Activity a Join MemberActivity m On a.MemberId = m.MemberId WHERE a.ActivityDate > ? AND a.memberId = ?)");) {
            //Select a.* FROM Activity a Join MemberActivity m On a.MemberId = m.MemberId Where a.MemberId = 1

            ps.setDate(1, (java.sql.Date) currDate);
            ps.setInt(2, memberID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                activities.add(rsActivity(rs));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;


    }

    public String addActivity(Activity activity) {

        try (Connection conn = dataSource.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Activity VALUES (null, ?, ?, ?, ?)");) {

            ps.setString(1, activity.getActivityName());
            ps.setInt(3, activity.getMaxMembers());
            ps.setDate(4, (java.sql.Date) activity.getStartDate());
            ps.setTime(5, (Time) activity.getStartTime());
            ps.setString(6, activity.getLocation());
            ps.setInt(7, activity.getCategoryId());
            ps.executeUpdate();



        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn1 = dataSource.getConnection();

             PreparedStatement ps1 = conn1.prepareStatement("INSERT INTO MemberActivity VALUES (null, ?, ?, ?, ?)");) {

            ps1.setInt(1, activity.getID());
            ps1.setInt(2, activity.getMemberId());
            ps1.setInt(3, activity.getIsOwner());
            ps1.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        return "AddActivity";
    }

    public String deleteActivity(int activityID) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM Activity WHERE ACTIVITYID = ?");) {

            ps.setInt(1, activityID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "AddBook";
    }

    // Helper method to create a Activity object instantiated with data from the ResultSet
    private Activity rsActivity(ResultSet rs) throws SQLException {
        return new Activity(rs.getInt("Activityid"),
                rs.getString("ActivityName"),
                rs.getInt("memberId"),
                rs.getInt("MaxMembers"),
                rs.getDate("ActivityDate"),
                rs.getTime("ActivityTime"),
                rs.getString("Location"),
                rs.getInt("CategoryId"));


    }


}
