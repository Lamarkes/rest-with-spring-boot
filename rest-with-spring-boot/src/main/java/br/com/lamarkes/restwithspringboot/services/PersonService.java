package br.com.lamarkes.restwithspringboot.services;

import br.com.lamarkes.restwithspringboot.data.vo.v1.PersonVO;
import br.com.lamarkes.restwithspringboot.data.vo.v2.PersonVOV2;
import br.com.lamarkes.restwithspringboot.exceptions.ResourceNotFoundException;
import br.com.lamarkes.restwithspringboot.mapper.Mapper;
import br.com.lamarkes.restwithspringboot.mapper.PersonMapper;
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

    @Autowired
    PersonMapper mapper;

    public List<PersonVO> findAll(){
        logger.info("Finding all people!");
        return Mapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        logger.info("Finding one person!");

        var entity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));

        return Mapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO createPerson(PersonVO personVO){

        logger.info("Creating one person!");
        var entity = Mapper.parseObject(personVO, Person.class);

        var vo = Mapper.parseObject(personRepository.save(entity),PersonVO.class);

        return vo;
    }

    public PersonVOV2 createPersonV2(PersonVOV2 personVO){

        logger.info("Creating one person with v2!");
        var entity = mapper.convertVoToEntity(personVO);

        var vo = mapper.convertEntityToVO(personRepository.save(entity));

        return vo;
    }

    public PersonVO updatePerson(PersonVO personVO){

        logger.info("Updating one PersonVO!");
        var entity = personRepository.findById(personVO.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());

        var vo = Mapper.parseObject(personRepository.save(entity),PersonVO.class);

        return vo;
    }

    public void deletePerson(Long id){

        logger.info("Deleting one PersonVO!");
        var entity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));


        personRepository.delete(entity);


    }
}
