package ru.polinabevad.bugtracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.core.Task;
import ru.polinabevad.bugtracker.core.services.MessageService;
import ru.polinabevad.bugtracker.core.services.PeopleService;
import ru.polinabevad.bugtracker.core.services.TaskService;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    TaskService taskService;

    @Autowired
    PeopleService peopleService;

    @Autowired
    MessageService messageService;

    @RequestMapping(value = {"/","/tasks"}, method = RequestMethod.GET)
    public String tasks(Model model) {
        //model.addAttribute("message", "Hello World!");
        List<Task> tasks = taskService.findAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @RequestMapping(value = "/peoples", method = RequestMethod.GET)
    public String peoples(Model model) {
        List<People> peoples = peopleService.findAllPeoples();
        model.addAttribute("peoples", peoples);
        return "peoples";
    }
}
