package telran.person.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.person.model.Person;

public class PersonRestoreAppl {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		List<Person> personsRestore = mapper.readValue(new File("persons.json"), new TypeReference<List<Person>>() {
		});
		personsRestore.forEach(System.out::println);

	}

}
