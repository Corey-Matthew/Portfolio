package com.fdmgroup.issuetracker.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.fdmgroup.issuetracker.model.impl.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("context.xml")
@WebAppConfiguration
public class LoginControllerTest {
	@Autowired
    private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	private User user;
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIfDisplayLoginPageReturnsLoginJsp() throws Exception {
	mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(model().attribute("user", User.class)).andExpect(content().string("login"));
	}
	
	@Test
	public void testLoginServelt() throws Exception {
	mockMvc.perform(get("/loginServlet")).andExpect(status().isOk()).andExpect(model().attribute("user", User.class)).andExpect(content().string("login"));
	}

}
