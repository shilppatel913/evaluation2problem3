package com.masai.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		/**let us make an object of PersonService and call it's methods**/
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		PersonService personService=(PersonService)context.getBean("personService");
		
		/**let us call all the methods of Person Service **/
		personService.printMap();
		personService.printList();
		personService.printAppName();

	}

}
