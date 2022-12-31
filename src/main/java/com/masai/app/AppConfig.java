package com.masai.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.masai.app"})
@PropertySource("app.properties")
public class AppConfig {
	
	@Bean(name = {"personService"})
	public PersonService getPersonService() {
		PersonService personService=new PersonService();
		personService.setTheMap(getMap());
		personService.setTheList(getList());
		return personService;
	}
	
	@Bean
	public Map<Person,Gym> getMap(){
		Map<Person,Gym> map=new HashMap<Person,Gym>();
		/**@Scope annotation is giving errors **/
		/** this three persons are registered in the same gym infinity avenger**/
		Person per2=new Person(2,"Isha","Isha@gmail.com",22,"9375499974");
		Person per3=new Person(3,"Niraj","Niraj@gmail.com",45,"9375444974");
		map.put(getPerson(), getGym());
		map.put(per2,getGym());
		map.put(per3,getGym());
		return map;
	}
	
	@Bean
	public List<Person> getList(){
		List<Person> persons=new ArrayList<Person>();
		Person per2=new Person(2,"Isha","Isha@gmail.com",22,"9375499974");
		Person per3=new Person(3,"Niraj","Niraj@gmail.com",45,"9375444974");
		Person per4=new Person(4,"Nishita","Nishita@gmail.com",40,"9376499974");
		Person per5=new Person(5,"Dhaval","dhaval@gmail.com",30,"8375444974");
		persons.add(getPerson());
		persons.add(per2);
		persons.add(per3);
		persons.add(per4);
		persons.add(per5);
		return persons;
	}
	
	//@Scope("prototype")
	@Bean
	public Person getPerson() {
		return new Person(1,"Shilp","shilp@gmail.com",21,"9375499974");
	}
	
	@Bean
	public Gym getGym() {
		return new Gym(101,"Avengers",2000);
	}

}
