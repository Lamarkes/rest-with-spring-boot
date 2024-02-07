package br.com.lamarkes.restwithspringboot.services;

import br.com.lamarkes.restwithspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final AtomicLong counter = new AtomicLong();


    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Lamark");
        person.setLastName("Ricarte");
        person.setAddress("Uberlandia - Minas Gerais - Brasil");
        person.setGender("Male");

        return person;
    }

    public Person createPerson(Person person){

        logger.info("Creating one Person!");

        return person;
    }

    public Person updatePerson(Person person){

        logger.info("Creating one Person!");

        return person;
    }

    public void deletePerson(String id){

        logger.info("Deleting one Person!");


    }

    private Person mockPerson(int i) {
        logger.info("Finding one Person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name: " +i);
        person.setLastName("Last name" +i);
        person.setAddress("Some address in Brasil: "+i);
        person.setGender("Male");

        return person;
    }
}
