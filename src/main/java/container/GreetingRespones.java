package main.java.container;

import java.util.List;

public class GreetingRespones {
	
	private String status;
	private List<Greeting> greeting;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Greeting> getGreeting() {
		return greeting;
	}
	public void setGreeting(List<Greeting> greeting) {
		this.greeting = greeting;
	}
	
	
}
