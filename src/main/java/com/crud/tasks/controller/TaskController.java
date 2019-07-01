package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    private static final Logger LOGGER = Logger.getLogger(TaskController.class.getName());

    //    private TaskMapper taskMapper;
//    private DbService deService;
    private Map<Long, TaskDto> tasksMap = new HashMap<>();
    private static final AtomicLong IDS = new AtomicLong();

    public TaskController() {
        Long firstId = IDS.getAndIncrement();
        tasksMap.put(firstId, new TaskDto(firstId, "first task", "some content"));
        Long secondId = IDS.getAndIncrement();
        tasksMap.put(secondId, new TaskDto(secondId, "secind task", "some more content"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    //@GetMapping("/tasksMap")
    //@ResponseBody
    public List<TaskDto> getTasksMap() {
        LOGGER.info("Returning all tasksMap: " + tasksMap);
        return new ArrayList<>(tasksMap.values());
    }

    //@GetMapping("/tasksMap/{taskId}")
    //@ResponseBody
    //public TaskDto getTask(@PathVariable("taskId") Long taskId) {
    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{taskId}")
    @ResponseBody
    public TaskDto getTask(@PathVariable("taskId") Long taskId) {
        ///TaskDto taskDto = new TaskDto(1L, "test title", "test_content");
        //return new TaskDto(1L, "test title", "test_content");
        TaskDto taskDto = tasksMap.get(taskId);
        LOGGER.info("Getting single task: " + taskDto);

        return taskDto;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        LOGGER.info("Removing single task: " + taskId);
        tasksMap.remove(taskId);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tasks")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        Long taskId = taskDto.getId();
        LOGGER.info("Updating single task: " + taskDto);

        tasksMap.put(taskId, taskDto);

        return taskDto;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto) {
        Long taskId = IDS.getAndIncrement();
        taskDto.setId(taskId);
        LOGGER.info("Creating single task: " + taskDto);

        tasksMap.put(taskId, taskDto);
    }


}
