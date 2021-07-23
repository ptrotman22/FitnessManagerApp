package com.example.demo.rest;

import com.example.demo.dao.FitnessDaoImpl;
import com.example.demo.entity.Fitness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is to allow calls from React
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class FitnessController {


    private final FitnessDaoImpl fitnessDaoImpl;

    @Autowired
    public FitnessController(FitnessDaoImpl fitnessDaoImpl) {
        this.fitnessDaoImpl = fitnessDaoImpl;
    }

    //http://localhost:8080/retrieveAll
    @GetMapping("/retrieveAll")
    public List<Fitness> findAll() {
        return fitnessDaoImpl.findAll();
    }

    @GetMapping("/fitness/{username}")
    public Fitness findEmployeeByUsername(@PathVariable("username") String username) {

        Fitness fitness = fitnessDaoImpl.findInfoByEmail(username);

        if(fitness == null) {
            throw new RuntimeException("Username is not found : " + username);
        }

        return fitness;
    }

    @GetMapping("/password/{username}")
    public String findPasswordByUsername(@PathVariable("username") String username) {

        Fitness fitness = fitnessDaoImpl.findInfoByEmail(username);

        if(fitness == null) {
            throw new RuntimeException("Username is not found : " + username);
        }

        return fitness.getPassword();
    }

//    @GetMapping("/admin/{employeeEmail}")
//    public boolean isAdmin(@PathVariable("employeeEmail") String employeeEmail) {
//
//        Employee employee = fitnessDaoImpl.findInfoByEmail(employeeEmail);
//
//        if(employee == null) {
//            throw new RuntimeException("Email is not found : " + employeeEmail);
//        }
//
//        return employee.isAdministrator();
//    }

    //http://localhost:8080/addPerson
    @PostMapping("/addPerson")
    public Fitness addPerson(@RequestBody Fitness thePerson) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        thePerson.setId(0);

        fitnessDaoImpl.save(thePerson);
        return thePerson;
    }

    //http://localhost:8080/updatePerson
    @PutMapping("/updatePerson")
    public Fitness updatePerson(@RequestBody Fitness updatePerson) {
        //No thePerson.setId(0); this will execute an update instead of a create
        fitnessDaoImpl.save(updatePerson);
        return updatePerson;
    }

    //http://localhost:8080/deletePerson/1
    @DeleteMapping("/deletePerson/{personId}")
    public String deletePerson(@PathVariable int personId) {

        //Creating a tempPerson to check to see if an employee exists
        Fitness tempPerson = fitnessDaoImpl.findById(personId);

        //This will throw an exception if the employee is null
        if(tempPerson == null) {
            throw new RuntimeException("Person is not found : " + personId);
        }

        //This will execute the deleteByID method in the employeeDaoImpl.
        fitnessDaoImpl.deleteById(personId);
        return "Deleted employee id : " + personId;
    }
}
