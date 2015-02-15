package com.shpak.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.shpak.persistence.service.RowService;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTests {
	
	@Mock
	private RowService rowServiceMock;
	
	@InjectMocks
	private MainController mainController;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {

        // Setup Spring test in standalone mode
		 mockMvc = MockMvcBuilders.standaloneSetup(mainController)
				 	.setHandlerExceptionResolvers(exceptionResolver())
	                .setValidator(validator())
	                .setViewResolvers(viewResolver())
	                .build();
    }
	
	@Test
	public void buildGridGetTest()  throws Exception {
		
		this.mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("main"))
		.andExpect(forwardedUrl("/WEB-INF/view/main.jsp"))
		.andExpect(model().attribute("rowList" , notNullValue()))
		.andExpect(model().attribute("selectedRows" , notNullValue()));
			
	}
	
	@Test
	public void buildGridPostTest()  throws Exception {
		
		
		this.mockMvc.perform(get("/"))		
		.andExpect(status().isOk())
		.andExpect(view().name("main"))
		.andExpect(forwardedUrl("/WEB-INF/view/main.jsp"))
		.andExpect(model().attribute("rowList" , notNullValue()))
		.andExpect(model().attribute("selectedRows" , notNullValue()));
			
	}
	
	//Configuration
	
	private HandlerExceptionResolver exceptionResolver() {
		
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
 
        Properties exceptionMappings = new Properties();
 
        exceptionMappings.put("java.lang.Exception", "error/error");
        exceptionMappings.put("java.lang.RuntimeException", "error/error");
 
        exceptionResolver.setExceptionMappings(exceptionMappings);
 
        Properties statusCodes = new Properties();
 
        statusCodes.put("error/404", "404");
        
 
        exceptionResolver.setStatusCodes(statusCodes);
 
        return exceptionResolver;
    }
 
	 
	 private LocalValidatorFactoryBean validator() {
	    return new LocalValidatorFactoryBean();
	    }
	 
	 private ViewResolver viewResolver() {
		 
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	 
	    viewResolver.setViewClass(JstlView.class);
	    viewResolver.setPrefix("/WEB-INF/view/");
	    viewResolver.setSuffix(".jsp");
	 
	    return viewResolver;
	    }
}


