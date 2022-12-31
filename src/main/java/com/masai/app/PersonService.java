package com.masai.app;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;



class SortList implements Comparator<Person>{

	public int compare(Person o1, Person o2) {
		if(o1.getAge()==o2.getAge()) return 0;
		else if(o1.getAge()<o2.getAge()) return -1;
		else return 1;
	}
	
}
public class PersonService {

	private Map<Person,Gym> theMap;
	private List<Person> theList;
	@Value("${app.name}")
	private String appName;
	
	public PersonService() {
		
	}
	
	public PersonService(Map<Person, Gym> theMap, List<Person> theList, String appName) {
		super();
		this.theMap = theMap;
		this.theList = theList;
		this.appName = appName;
	}

	public void printMap() {
		for (Map.Entry<Person,Gym> entry : theMap.entrySet()) 
            System.out.println("PersonName = " + entry.getKey().getName() +
                             ", GymName = " + entry.getValue().getGym_name());
		System.out.println("---------------------------------------------------");
	}
	
	public void printList() {
		Collections.sort(theList,new SortList());
		
		for(Person p:theList) {
			
			System.out.println("Id"+" "+"Name"+" "+"Email"+" "+"Mobile"+" "+"Age");
			System.out.println(p.getPerson_id()+" "+p.getName()+" "+p.getEmail()+" "+p.getMobile()
			+" "+p.getAge());
			System.out.println("---------------------------------------------------");
			
			
		}
	}
	public void printAppName() {
		System.out.println("The app name is"+this.appName);
	}

	public Map<Person, Gym> getTheMap() {
		return theMap;
	}

	public void setTheMap(Map<Person, Gym> theMap) {
		this.theMap = theMap;
	}

	public List<Person> getTheList() {
		return theList;
	}

	public void setTheList(List<Person> theList) {
		this.theList = theList;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	//defining getters and setters
	
}
