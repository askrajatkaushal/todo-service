package com.techolution.todoservice.repositories;

import com.techolution.todoservice.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    @Query("select t from Task t where t.discarded = false order by t.status desc, t.dueDate asc")
    List<Task> findAll();

    @Query("select t from Task t where t.userId = ?1 and t.discarded = false order by t.status desc, t.dueDate asc")
    List<Task> findByUserId(Integer userId);

}
