package com.example.joinMe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;



public interface JoinMeRepository extends CrudRepository<Activity, Integer>, PagingAndSortingRepository<Activity, Integer> {

    //List<Activity> findAllByOrderByCategory();

   // List<Activity> findAllByOrderByDateDesc();

  //  List<Activity> findByCategoryId(int categoryID);


     @Query("SELECT * FROM Activities a WHERE a.categoryId = ?1 AND a.date > ${new Date()}  ORDER BY Date DESC")
     List<Activity> findByCategoryID(int categoryID);

    //Date currentDate = new Date();
    @Query("SELECT * FROM Activities a WHERE a.date > ${new Date()} ORDER BY Date DESC")
     List<Activity> findAllFromDate();


    //Date currentDate = new Date();
    @Query("SELECT * FROM Activities a WHERE a.memberID> = ?1 ORDER BY Date DESC")
    List<Activity> findAllByMember(int memberID);



}
