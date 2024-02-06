package br.com.lamarkes.restwithspringboot.services;

import br.com.lamarkes.restwithspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final AtomicLong counter = new AtomicLong();


    private Logger logger = Logger.getLogger(PersonService.class.getName());

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
}
