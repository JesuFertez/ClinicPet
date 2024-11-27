package com.coworkers.clinicpet.controller;import com.coworkers.clinicpet.model.entities.Owner;import com.coworkers.clinicpet.service.OwnerService;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;@RestController@RequestMapping("/owners")public class OwnerController {    private final OwnerService ownerService;    public OwnerController(OwnerService ownerService) {        this.ownerService = ownerService;    }    @GetMapping("/{ownerId}")    public ResponseEntity<Owner> getOwnerById(@PathVariable Long ownerId) {        return ResponseEntity.ok(ownerService.getUserById(ownerId));    }    @PostMapping    public ResponseEntity<Void> saveOwner(@RequestBody Owner owner) {        ownerService.saveOwner(owner);        return ResponseEntity.status(201).build();    }}