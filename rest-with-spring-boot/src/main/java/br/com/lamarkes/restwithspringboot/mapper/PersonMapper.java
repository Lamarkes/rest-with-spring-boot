package br.com.lamarkes.restwithspringboot.mapper;

import br.com.lamarkes.restwithspringboot.data.vo.v2.PersonVOV2;
import br.com.lamarkes.restwithspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVO(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthDay(new Date());

        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 personVO){
        Person person = new Person();
        person.setId(person.getId());
        person.setFirstName(personVO.getFirstName());
        person.setLastName(personVO.getLastName());
        person.setAddress(personVO.getAddress());
        person.setGender(personVO.getGender());
        //person.setBirthDay(new Date());

        return person;
    }

}
