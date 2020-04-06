package com.in28Minutes.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.in28Minutes.springboot.web.model.Todo;

// this isa service file
@Service
public class TodoService {
	
		static List<Todo> todos =new ArrayList<Todo>();
		private static int todoCount = 3;
		
		static {
			todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false));
			todos.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
	        todos.add(new Todo(3, "in28Minutes", "Learn Hibernate", new Date(),false));
		}
		
		public List<Todo> retrieveTodos(String user){
			List<Todo> filteredTodos=new ArrayList<Todo>();
			for(Todo todo: todos) {
				if(todo.getUser().equalsIgnoreCase(user)) {
					filteredTodos.add(todo);
				}
			}
			return filteredTodos;
		}
		
		public void addTodos(String name, String desc, Date targetDate,
	            boolean isDone) {
			todos.add(new Todo(++todoCount,name, desc, targetDate, isDone));
		}
		
		public void deleteTodo(int id) {
			Iterator<Todo> iterator = todos.iterator();
	        while (iterator.hasNext()) {
	            Todo todo = iterator.next();
	            if (todo.getId() == id) {
	                iterator.remove();
	            }
	        }
		}

		public void updateTodo(Todo todo) {
			todos.remove(todo);
			todos.add(todo);
			
		}

		public Todo retrieveTodo(int id) {
			for(Todo todo:todos) {
				if(todo.getId()==id)				
					return todo;
			}
			return null;
	}
}


