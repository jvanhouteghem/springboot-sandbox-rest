#springboot-sandbox-rest

I. Create Project

Create new Spring starter project
Select the web package.
Check in pom.xml that jackson-databind is loaded.

II. Create model

Create new package called "model"
Create inside the package an object class called "Person" : 
```
public class Person {
	String id;
	String firstName;
	String lastName;
	int age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
```

III. Create service

Create new package called "service"
Create inside the package a class called "PersonService" :
```
@Service
public class PersonService {
	Hashtable<String, Person> persons = new Hashtable<String, Person>();

	public PersonService(){
		Person p = new Person();
		p.setId("1");
		p.setAge(21);
		p.setFirstName("Steve");
		p.setLastName("Smith");
		persons.put("1", p);
		
		p = new Person();
		p.setId("2");
		p.setAge(22);
		p.setFirstName("Loan");
		p.setLastName("Smith");
		persons.put("2", p);
	}
	
	public Person getPerson(String id){
		if (persons.containsKey(id))
			return persons.get(id);
		else 
			return null;
	}
	
	public Hashtable<String, Person> getAll(){
		return persons;
	}

}
```

IV. Create controller

Create controller packageCreate inside the package a class called PersonController : 
```
@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService ps;
	
	@RequestMapping("/all")
	public Hashtable<String, Person> getAll(){
		return ps.getAll();
	}
	
	@RequestMapping("{id}")
	public Person getPerson(@PathVariable("id") String id) {
		return ps.getPerson(id);
	}
	
}

```

V. Try it

Run as > Spring boot app
Connect to http://localhost:8080/persons/all

Result is : 
```
{"2":{"id":"2","firstName":"Loan","lastName":"Smith","age":22},"1":{"id":"1","firstName":"Steve","lastName":"Smith","age":21}}
```

VI. Errors
"spring boot This application has no explicit mapping for /error, so you are seeing this as a fallback." > Make sure that your main class is in a root package above other classes.

Source : https://www.youtube.com/watch?v=rPMt8GhZkA0