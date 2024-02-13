package br.com.lamarkes.restwithspringboot.services;

import br.com.lamarkes.restwithspringboot.exceptions.ResourceNotFoundException;
import br.com.lamarkes.restwithspringboot.model.Person;
import br.com.lamarkes.restwithspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){
        logger.info("Finding all people!");
        return personRepository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one Person!");

        return personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));
    }

    public Person createPerson(Person person){

        logger.info("Creating one Person!");

        return personRepository.save(person);
    }

    public Person updatePerson(Person person){

        logger.info("Updating one Person!");
        Person entity = personRepository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
    }

    public void deletePerson(Long id){

        logger.info("Deleting one Person!");
        Person entity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));


        personRepository.delete(entity);


    }
}
