package com.example.joinMe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;



public interface JoinMeRepository extends CrudRepository<Activity, Integer>, PagingAndSortingRepository<Activity, Integer> {

    //List<Activity> findAllByOrderByCategory();

   // List<Activity> findAllByOrderByDateDesc();

    List<Activity> findByCategoryId(int categoryID);





}
