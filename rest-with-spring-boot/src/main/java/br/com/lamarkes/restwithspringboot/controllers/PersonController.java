package br.com.lamarkes.restwithspringboot.controllers;
import br.com.lamarkes.restwithspringboot.model.Person;
import br.com.lamarkes.restwithspringboot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findBdyId(
            @PathVariable(value = "id") String id)throws Exception{

        return service.findById(id);
    }

}
