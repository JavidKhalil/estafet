package com.estafet.repository;

import com.estafet.domain.Customer;
import com.estafet.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Query(value = "update Task t set t.title = ?1, t.description = ?2, t.finished = ?3, " +
            "t.customer = ?4 where t.id = ?5")
    void updateTask(
            String title,
            String description,
            Boolean finished,
            Customer customer,
            Long id);

    @Transactional
    @Query(value = "delete from Task t where t.id = ?1", nativeQuery = true)
    public void deleteWithId(Long id);

}
