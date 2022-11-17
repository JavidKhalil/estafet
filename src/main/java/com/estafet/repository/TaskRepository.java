package com.estafet.repository;

import com.estafet.domain.Customer;
import com.estafet.domain.Task;
import com.estafet.exceptions.TaskProceedingGenericException;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {

    private AtomicLong idCounter = new AtomicLong(1L);

    private Map<Long, Task> tasks = new HashMap<>();

    public void updateTask(
            String title,
            String description,
            Boolean finished,
            Customer customer,
            Long id) throws TaskProceedingGenericException {
        Task task = tasks.get(id);
        if(task == null){
            throw new TaskProceedingGenericException(
                    String.format("Attempt to modify unexisting tasks with id %d", id.intValue()));
        } else {
            task.setCustomer(customer);
            task.setDescription(description);
            task.setFinished(finished);
            task.setTitle(title);
            tasks.remove(id);
            tasks.put(id, task);
        }
    }

    public void deleteWithId(Long id) {
        tasks.remove(id);
    }

    public List<Task> findAll() {
       return new ArrayList<>(tasks.values());
    }

    public Task saveAndFlush(Task task) {
        Long id = idCounter.getAndIncrement();
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    public Optional<Task> findById(Long id) {
        return Optional.of(tasks.get(id));
    }

    public void deleteById(Long id) {
        tasks.remove(id);
    }
}
