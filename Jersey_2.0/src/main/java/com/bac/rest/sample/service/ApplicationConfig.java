package com.bac.rest.sample.service;

import java.util.Set;
import java.util.HashSet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest_service/")
public class ApplicationConfig extends Application {
	
	 @Override
	    public Set<Class<?>> getClasses() {
	        
	        Set<Class<?>> resources = new HashSet<>();
	        
	        System.out.println("REST configuration starting: getClasses()");            
	        
	        //features
	        //this will register Jackson JSON providers
	        //resources.add(org.glassfish.jersey.jackson.JacksonFeature.class);
	        //we could also use this:
	        //resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
	        
	        //instead let's do it manually:
	        //resources.add(com.bac.rest.config.MyJacksonJsonProvider.class);
	        //resources.add(com.bac.rest.config.MarshallingFeature.class);
	        //resources.add(com.bac.rest.config.JacksonJsonProviderAtRest.class);
	        //resources.add(com.nabisoft.tutorials.jerseyjackson.jaxrs.resource.MessageResource.class);
	        //resources.add(com.nabisoft.tutorials.jerseyjackson.jaxrs.resource.PersonResource.class);
	        //==> we could also choose packages, see below getProperties()
	        
	        System.out.println("REST configuration ended successfully.");
	        
	        return resources;
	    }

}
