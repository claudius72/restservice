package com.velox.jersey.todo.model;

import java.util.HashMap;
import java.util.Map;

public class TodoDao {
	  public static TodoDao instance = new TodoDao();
	
	  private Map<String, Todo> contentProvider = new HashMap<>();
	  
	  private TodoDao() {
	    
	    Todo todo = new Todo("1", "Learn REST");
	    todo.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
	    contentProvider.put("1", todo);
	    todo = new Todo("2", "Do something");
	    todo.setDescription("Read complete http://www.vogella.com");
	    contentProvider.put("2", todo);
	    todo = new Todo("3", "Read title");
	    todo.setDescription("Go to top of http://www.vogella.com");
	    contentProvider.put("3", todo);
	    
	  }
	  public Map<String, Todo> getModel(){
	    return contentProvider;
	  }
}
