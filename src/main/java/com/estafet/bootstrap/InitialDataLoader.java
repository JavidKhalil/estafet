package com.estafet.bootstrap;

import com.estafet.domain.Customer;
import com.estafet.domain.Task;
import com.estafet.repository.CustomerRepository;
import com.estafet.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitialDataLoader {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostConstruct
    private void loadInitialData() {
        Customer estafet = new Customer();
        estafet.setCreated(new Date(System.currentTimeMillis()));
        estafet.setName("Estafet");
        estafet.setSurname("Estafetetos");
        Set<Task> taskSet = new HashSet<>();
        estafet.setTasks(taskSet);
        Task wakeup = new Task("Wake up", "Should do it fast", false, estafet);
        taskSet.add(wakeup);
        taskService.createTask(wakeup);
        Task makeaBf = new Task("Prepare a tea", "Be carefull with a pot", false, estafet);
        taskSet.add(makeaBf);
        taskService.createTask(makeaBf);
        Task goToWork = new Task("Go to work", "Prepare report", false, estafet);
        taskSet.add(goToWork);
        taskService.createTask(goToWork);
        Task makeSpeech = new Task("Make a speech", "Read latest news, before", false, estafet);
        taskSet.add(makeSpeech);
        taskService.createTask(makeSpeech);
        Task takeTaxi = new Task("The way to home", "Met the friends", false, estafet);
        taskSet.add(takeTaxi);
        taskService.createTask(takeTaxi);
        customerRepository.saveAndFlush(estafet);

    }

}
