package br.com.lamarkes.restwithspringboot.controllers;
import br.com.lamarkes.restwithspringboot.data.vo.v1.PersonVO;
import br.com.lamarkes.restwithspringboot.data.vo.v2.PersonVOV2;
import br.com.lamarkes.restwithspringboot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import br.com.lamarkes.restwithspringboot.util.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService service;
    @GetMapping(produces = {MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML})
    public List<PersonVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public PersonVO findBdyId(
            @PathVariable(value = "id") Long id) {

        return service.findById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVO create(
            @RequestBody PersonVO person) {

        return service.createPerson(person);
    }

    @PostMapping(value = "/v2", consumes = {MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public PersonVOV2 createV2(
            @RequestBody PersonVOV2 person) {

        return service.createPersonV2(person);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public PersonVO update(
            @RequestBody PersonVO person) {

        return service.updatePerson(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(
            @PathVariable(value = "id") Long id) {

        service.deletePerson(id);

        return ResponseEntity.noContent().build();
    }

}
