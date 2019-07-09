package telran.person.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import telran.person.model.Address;
import telran.person.model.Child;
import telran.person.model.Employee;
import telran.person.model.Person;

public class PersonAppl {

	public static void main(String[] args) throws IOException {
		Person[] persons = {
				new Child(1000, "Mosche", LocalDate.of(2013, 5, 15),
						new Address("Lod", "Sokolov", 20, 10), "Shalom"),
				new Employee(2000, "Sarah", LocalDate.of(1990, 9, 23),
						new Address("Rehovot", "Herzl", 15, 28), "Motorola", 20000)
		};
		ObjectMapper mapper = new ObjectMapper();
		//mapper.registerModule(new JavaTimeModule());
		mapper.findAndRegisterModules();
		//Serialization to json
		String jsonString = mapper.writeValueAsString(persons);
		System.out.println(jsonString);
		System.out.println();
		//Deserialization from json
		List<Person> personsRestore = mapper.readValue(jsonString, new TypeReference<List<Person>>() {
		});
		personsRestore.forEach(System.out::println);
	}

}
