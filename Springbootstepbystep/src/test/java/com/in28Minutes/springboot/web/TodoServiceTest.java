package com.in28Minutes.springboot.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28Minutes.springboot.web.model.Todo;
import com.in28Minutes.springboot.web.service.TodoService;

@SpringBootTest
public class TodoServiceTest {
	
	
	@Mock
	TodoService todoservice;
	
	
	@Test
	public void RetrieveTodoTest() {		
		List<Todo> todos1=new ArrayList<Todo>();
		todos1.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false));
		todos1.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));		
		
		List<Todo> todos=new ArrayList<Todo>();
		todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
		when(todoservice.retrieveTodos(Mockito.anyString())).thenReturn(todos);
		todos=todoservice.retrieveTodos(Mockito.anyString());
		assertEquals(2, todos.size());
		
		
		
	}
	
	@Test
	public void RetrieveTodoTest1() {		
		List<Todo> todos1=new ArrayList<Todo>();
		todos1.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false));
		todos1.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
		
		
		List<Todo> todos=new ArrayList<Todo>();
		todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
		when(todoservice.retrieveTodos(Mockito.anyString())).thenReturn(todos);
		todos=todoservice.retrieveTodos(Mockito.anyString());
		assertEquals(todos1, todos);		
	}
	
	@Test
	public void retrieveTodoTest() {
		Todo todo =new Todo();
		todo.setId(1);
		todo.setUser("in28Minutes");
		todo.setDesc("Learn Spring MVC");
		todo.setTargetDate(new Date());
		todo.setDone(false);
		when(todoservice.retrieveTodo(Mockito.anyInt())).thenReturn(todo);
		Todo assertTodo=todoservice.retrieveTodo(1);
		assertEquals(assertTodo, todo);
	}
	
	public void deleteTodoTest() {
		//stubVoid(todoservice.deleteTodo(Mockito.anyInt()))
	}

}
