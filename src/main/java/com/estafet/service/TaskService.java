package com.estafet.service;

import com.estafet.domain.Customer;
import com.estafet.domain.Task;
import com.estafet.exceptions.TaskProceedingGenericException;
import com.estafet.repository.CustomerRepository;
import com.estafet.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Find all tasks
     *
     * @return
     */
    public List<Task> findAll() {
       List<Task> list = taskRepository.findAll();
        return list;
    }

    /**
     * Add new task
     *
     * @param task
     * @return
     */
    public Task createTask(Task task) {
       return taskRepository.saveAndFlush(task);
    }

    /**
     * Find all
     *
     * @param id
     * @return
     */
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    /**
     * Delete service
     *
     * @param id
     * @return
     */
    public Boolean deleteTask(Long id) {
        taskRepository.deleteById(id);
        return !taskRepository.findById(id).isPresent();
    }

    /**
     * Update with id
     * Customer should be provided
     *
     * @param task
     * @throws TaskProceedingGenericException
     */
    @Transactional
    public void updateTask(Task task) throws TaskProceedingGenericException {
        Customer customer = task.getCustomer();
        if(customer != null){
            customerRepository.saveAndFlush(customer);
            taskRepository.updateTask(task.getTitle(), task.getDescription(), task.getFinished(), task.getCustomer(), task.getId());
        } else {
            throw new TaskProceedingGenericException("You try to save a task without specifying Customer " +
                    "add one, please");
        }

    }

}
