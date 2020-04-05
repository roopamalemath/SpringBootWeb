package com.in28Minutes.springboot.web;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.in28Minutes.springboot.web.controller.TodoController;
import com.in28Minutes.springboot.web.model.Todo;
import com.in28Minutes.springboot.web.service.TodoService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
 

@SpringBootTest
@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
@WebAppConfiguration
public class TodoControllerTest {
	
	@Mock
	private TodoController todoController;
	
	@InjectMocks
	private TodoService todoService;
	
	private MockMvc mockMvc;
	
	@Test
	void AddTodosTest() throws Exception {
		List<Todo> todos=new ArrayList<Todo>();
		todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
		
		 when(todoService.retrieveTodos(Mockito.any())).thenReturn(todos);
		 when(todoController.getLoggedInUserName(Mockito.any())).thenReturn("in28Minutes");
        
        mockMvc.perform(get("/list-todos"))
        .andExpect(status().isOk())
        .andExpect(view().name("list-todos"))
        .andExpect(forwardedUrl("/WEB-INF/jsp/list-todos.jsp"))
        .andExpect(model().attribute("todos", hasSize(Mockito.anyInt())))
        .andExpect(model().attribute("todos", hasItem(
                allOf(
                        hasProperty("id", is(1)),
                        hasProperty("user", is("in28Minutes")),
                        hasProperty("desc", is("Learn Spring MVC")),                       
                        hasProperty("targetDate", is(new Date())),
                        hasProperty("isDone", is(false))
                )
        )))
        .andExpect(model().attribute("todos", hasItem(
                allOf(
                        hasProperty("id", is(2)),
                        hasProperty("user", is("in28Minutes")),
                        hasProperty("desc", is("Learn Struts")),                       
                        hasProperty("targetDate", is(new Date())),
                        hasProperty("isDone", is(false))
                )
        )));
       verify(todoService, times(1)).retrieveTodos(Mockito.anyString());
       verifyNoMoreInteractions(todoService);
	}
	
	@Test
	public void getLoggedInUserNameTest() {
		when(todoController.getLoggedInUserName(Mockito.any())).thenReturn("in28Minutes");
		String assetCheck=todoController.getLoggedInUserName(Mockito.any());
		assertEquals("in28Minutes", assetCheck);
		
	}

}
