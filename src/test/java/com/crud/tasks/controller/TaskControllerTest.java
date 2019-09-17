//package com.crud.tasks.controller;
//
//import com.crud.tasks.domain.Task;
//import com.crud.tasks.domain.TaskDto;
//import com.crud.tasks.mapper.TaskMapper;
//import com.crud.tasks.service.DbService;
//import com.google.gson.Gson;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatcher;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.ArgumentMatchers.anyList;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.hamcrest.Matchers.is;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(TaskController.class)
//public class TaskControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private DbService dbService;
//
//    @MockBean
//    private TaskMapper taskMapper;
//
//    @Test
//    public void shouldFetchEmptyTasksList() throws Exception {
//        //Given
//        List<TaskDto> taskDtoList = new ArrayList<>();
//        when(taskMapper.mapToTaskDtoList(new ArrayList<>())).thenReturn(taskDtoList);
//
//        //When & Then
//        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$", hasSize(0)));
//    }
//
//    @Test
//    public void shouldFetchTasksList() throws Exception {
//        //Given
//        List<TaskDto> taskDtoList = new ArrayList<>();
//        taskDtoList.add(new TaskDto(1L, "title", "content"));
//        taskDtoList.add(new TaskDto(2L, "title2", "content2"));
//        when(taskMapper.mapToTaskDtoList(anyList())).thenReturn(taskDtoList);
//
//        //When & Then
//        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[1].id", is(2)))
//                .andExpect(jsonPath("$[1].title", is("title2")))
//                .andExpect(jsonPath("$[1].content", is("content2")));
//    }
//
//    @Test
//    public void shouldFetchTask() throws Exception {
//        //Given
//        TaskDto taskDto = new TaskDto(1L, "title", "content");
//        Task task = new Task(1L, "title", "content");
//
//        when(taskMapper.mapToTaskDto(ArgumentMatchers.any(Task.class))).thenReturn(taskDto);
//        when(dbService.getTask(1L)).thenReturn(Optional.of(task));
//
//        //When & Then
//        mockMvc.perform(get("/v1/task/getTask").contentType(MediaType.APPLICATION_JSON))
//                //.characterEnccodiung("UTF-8")
//                //.param("taskId", 1L)
//                .andExpect(jsonPath("$[1].id", is(1)))
//                .andExpect(status().is(200));
//
//
//    }
//
//    @Test
//    public void shouldDeleteTask() throws Exception{
//
//        // https://stackoverflow.com/questions/47759833/spring-mockmvc-how-to-test-delete-request-of-rest-controller?rq=1
//
//        //Given
//        Task task = new Task(1L, "title", "content");
//        when(dbService.getTask(1L));
//
//        //When & Then
//        mockMvc.perform(delete("/v1/task/deleteTask").contentType(MediaType.APPLICATION_JSON))
//                //.characterEncoding("UTF-8")
//                //.accept(MediaType.APPLICATION_JSON))
//                //.param("taskId", 1L))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void shouldUpdateTask() throws Exception {
//        //Given
//        TaskDto taskDto = new TaskDto(1L, "title", "content");
//        Task task = new Task(1L, "title", "content");
//
//        when(taskMapper.mapToTaskDto(ArgumentMatchers.any(Task.class))).thenReturn(taskDto);
//        when(dbService.saveTask(ArgumentMatchers.any(Task.class))).thenReturn(task);
//        when(taskMapper.mapToTask(ArgumentMatchers.any(TaskDto.class))).thenReturn(task);
//
//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(taskDto);
//
//        //When & Then
//        mockMvc.perform(put("/v1/task/updateTask")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(jsonContent))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.title", is("title")))
//                .andExpect(jsonPath("$.content", is("content")));
//    }
//
//    @Test
//    public void shouldCreateTask() throws Exception {
//        //Given
//        TaskDto taskDto = new TaskDto(1L, "title", "content");
//        Task task = new Task(1L, "title", "content");
//
//        when(taskMapper.mapToTask(ArgumentMatchers.any(TaskDto.class))).thenReturn(task);
//
//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(taskDto);
//
//        //When & Then
//        mockMvc.perform(post("/v1/task/createTask")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(jsonContent))
//                .andExpect(status().is(200));
//    }
//    }
//
//
//}
