package com.example.devops.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.devops.DevopsApplication;

@AutoConfigureMockMvc
@SpringBootTest(classes = DevopsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WelcomeControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@LocalServerPort
	protected int port;

	@BeforeEach
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testWelcome() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(model().attribute("course", containsString("DevOps")));
	}

}
