package main.java.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import main.java.container.Greeting;
import main.java.container.GreetingRespones;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {
	
	private static final String TEMPLATE = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(this.TEMPLATE, name));
	}
	
	@RequestMapping(value="hi",method=RequestMethod.GET)
	public @ResponseBody GreetingRespones sayHellos(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
		List<Greeting> list = new ArrayList<Greeting>();
		Random random = new Random();
		int ran = random.nextInt(10);
		for (int i=0;i<ran;i++) {
			list.add(new Greeting(counter.incrementAndGet(), name + (i+1)));
		}
		GreetingRespones greetingRespones = new GreetingRespones();
		greetingRespones.setStatus("success");
		greetingRespones.setGreeting(list);
		return greetingRespones;
	}
}
