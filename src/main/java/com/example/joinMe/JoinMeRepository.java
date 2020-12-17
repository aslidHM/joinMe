package com.example.joinMe;

import org.springframework.beans.factory.annotation.Autowired;
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
             PreparedStatement ps = conn.prepareStatement("Select  A.*,  C.CATEGORYNAME, MA.ISOWNER,MA.MEMBERID, M.EMAIL FROM ACTIVITY  A  join CATEGORY C ON C.CATEGORYID = A.CATEGORYID join MEMBERACTIVITY MA on MA.ACTIVITYID = A.ACTIVITYID join MEMBER M on M.MEMBERID = MA.MEMBERID WHERE MA.ISOWNER = 1 and A.ACTIVITYDATE >= CURRENT_DATE();");) {


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                activities.add(rsActivity(rs));

            }
            for (Activity a: activities) {
                List<Member> members = new ArrayList<>();
                members = getMembersForOneActivity(a.getActivityId());
                a.setActivityMembers(members);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;


    }

    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("Select * from Category;");) {


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(rsCategory(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;


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

    public List<Member> getMembersForOneActivity(int activityID) {
        List<Member> members = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("Select M.*  FROM Activity A join MEMBERACTIVITY MA on MA.activityId = A.activityId join MEMBER M on M.memberId = MA.memberId WHERE A.activityId = ? ");) {

            ps.setInt(1, activityID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                members.add(rsMember(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;


    }

    public List<Activity> getActivityForMember(int memberID) {
        List<Activity> activities = new ArrayList<>();
        Date currDate = new Date();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("Select a.*, ma.IsOwner FROM Activity a Join MemberActivity ma On a.ActivityId= ma.ActivityId join Member m on m.MemberId = ma.MemberId WHERE a.ActivityDate >= CURRENT_DATE() AND ma.memberId = ?");) {

            ps.setInt(1, memberID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                activities.add(rsActivity(rs));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;


    }

    public void addActivity(Activity activity, int memberID) {
        int generatedActivityId = 0;

        String generatedKeys[] = {"ActivityId"};

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Activity (ActivityName, MaxMembers, ActivityDate, Location , CategoryId) VALUES (?, ?, ?, ?, ?)", generatedKeys);
             PreparedStatement ps1 = conn.prepareStatement("INSERT INTO MemberActivity VALUES ( ?, ?, ?)");) {
            conn.setAutoCommit(false);
            ps.setString(1, activity.getActivityName());
            ps.setInt(2, activity.getMaxMembers());
            ps.setTimestamp(3, DateUtil.toDbFormat(activity.getActivityDate()));
            ps.setString(4, activity.getLocation());
            ps.setInt(5, activity.getCategoryId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedActivityId = rs.getInt("ActivityId");
            }

            ps1.setInt(1, memberID);
            ps1.setInt(2, generatedActivityId);
            ps1.setInt(3, activity.getIsOwner());
            ps1.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addMemberToActivity(int activityId, int memberID) {

        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO MemberActivity VALUES ( ?, ?, ?)");) {

            ps.setInt(1, memberID);
            ps.setInt(2, activityId);
            ps.setInt(3, 0);
            ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void editActivity(Activity activity) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE Activity SET ActivityName = ?, MaxMembers = ?, " +
                     " ActivityDate = ?, Location = ?, CategoryId = ? Where ActivityID = ?");) {
            ps.setString(1, activity.getActivityName());
            ps.setInt(2, activity.getMaxMembers());
            ps.setTimestamp(3, DateUtil.toDbFormat(activity.getActivityDate()));
            ps.setString(4, activity.getLocation());
            ps.setInt(5, activity.getCategoryId());
            ps.setInt(6, activity.getActivityId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteActivity(int activityID) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM MemberActivity WHERE ActivityId = ?");
             PreparedStatement ps1 = conn.prepareStatement("DELETE FROM Activity WHERE ActivityId = ?");) {

            conn.setAutoCommit(false);

            ps.setInt(1, activityID);
            ps.executeUpdate();

            ps1.setInt(1, activityID);
            ps1.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteMemberFromActivity(int activityId, int memberId) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM MemberActivity WHERE ActivityId = ? and MemberId = ?");) {

            ps.setInt(1, activityId);
            ps.setInt(2, memberId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Member CheckMemberLogin(String email, String password){
        Member member = null;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM MEMBER AS M WHERE M.Email=? AND M.Password=?")){
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                member =(rsMember(rs));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(member==null){
            return null;
        }else{
            return member;
        }

    }

    public void addMember(String fullName, String email, String password) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Member VALUES ( ?, ?, ?)");) {

            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Helper method to create a Activity object instantiated with data from the ResultSet
    private Activity rsActivity(ResultSet rs) throws SQLException {
    List<Member> members = new ArrayList<>();
        return new Activity(rs.getInt("ActivityId"),
                rs.getString("ActivityName"),
                rs.getString("Email"),
                rs.getInt("MaxMembers"),
                DateUtil.toModelDate(rs.getTimestamp("ActivityDate")),
                rs.getString("Location"),
                rs.getInt("CategoryId"),
                rs.getString("CategoryName"),
                rs.getInt("isOwner"));

    }

    private Member rsMember(ResultSet rs) throws SQLException {

        return new Member(rs.getInt("MemberId"),
                rs.getString("FullName"),
                rs.getString("Email"),
                rs.getString("Password"));


    }

    private Category rsCategory(ResultSet rs) throws SQLException {

        return new Category(rs.getInt("CategoryId"),
                rs.getString("CategoryName"));


    }

}
