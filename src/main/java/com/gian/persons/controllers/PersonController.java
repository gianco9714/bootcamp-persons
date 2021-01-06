package com.gian.persons.controllers;

import com.gian.persons.model.response.PersonResponse;
import com.gian.persons.service.IPersonService;
import com.gian.persons.service.impl.PersonServiceImpl;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@Validated
@RestController
@RequestMapping("/core")
@Api(value = "PersonController", produces = "application/json", tags = { "Person Controller" })
public class PersonController {

    @Autowired
    private IPersonService personService;

    @ApiOperation(value = "Obtener Personas", tags = { "Person Controller" })
    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = PersonResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<PersonResponse> getPerson(@RequestParam String documentNumber){

        log.info("Controller: Get Person with Document Number: " + documentNumber);
        return personService.getPerson(documentNumber);
    }
}
