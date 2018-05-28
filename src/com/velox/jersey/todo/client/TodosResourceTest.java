/**
 * 
 */
package com.velox.jersey.todo.client;

import static org.junit.Assert.*;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Before;
import org.junit.Test;

import com.velox.jersey.todo.model.Todo;
import com.velox.jersey.todo.resouces.TodoResource;

/**
 * @author claudiu
 *
 */
public class TodosResourceTest {
	
	private ClientConfig config;
	private Client client;
	private WebTarget service;

	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/com.velox.jersey.todo").build();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	    config = new ClientConfig();
	    client = ClientBuilder.newClient(config);
	    service = client.target(getBaseURI());
	}

	/**
	 * Test method for {@link com.velox.jersey.todo.resouces.TodosResource#getTodos()}.
	 */
	@Test
	public void testGetTodos() {
	    // Get the Todos
	    System.out.println(service.path("rest").path("todos").request().accept(MediaType.TEXT_XML).get(String.class));
	}

	/**
	 * Test method for {@link com.velox.jersey.todo.resouces.TodosResource#getCount()}.
	 */
	@Test
	public void testGetCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.velox.jersey.todo.resouces.TodosResource#newTodo(java.lang.String, java.lang.String, java.lang.String, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testNewTodo() {
	    Todo todo = new Todo("4", "Vasilica");
	    String response = service.path("rest").path("todos").path(todo.getId()).request(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON).post(Entity.entity(todo,MediaType.APPLICATION_XML),String.class);
	    System.out.println(response);
	}

	/**
	 * Test method for {@link com.velox.jersey.todo.resouces.TodosResource#getTodo(java.lang.String)}.
	 */
	@Test
	public void testGetTodo() {
	    //Get Todo with id 1
	    String firstTodo = service.path("rest").path("todos/1").request().accept(MediaType.APPLICATION_JSON).get(String.class);
	    System.out.println(firstTodo);
	}
	
	@Test
	public void testDeleteTodo() {
		service.path("rest").path("todos/3").request().accept(MediaType.APPLICATION_JSON).delete();
	}

}
