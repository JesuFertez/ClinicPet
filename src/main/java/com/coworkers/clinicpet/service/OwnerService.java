package com.coworkers.clinicpet.service;import com.coworkers.clinicpet.model.Owner;import java.util.ArrayList;import java.util.List;public class OwnerService {    private final List<Owner> owners = new ArrayList<>();    public OwnerService() {        Owner owner1 = new Owner("1", "jose", "jose");        Owner owner2 = new Owner("2", "Ana", "ana");        owners.add(owner1);        owners.add(owner2);    }    public Owner getUserById(String id) {        for (Owner current : owners) {            if (current.getId().equals(id)) {                return current;            }        }        throw new RuntimeException("Owner not found");    }    public void saveOwner(Owner owner) {        String name = "name";        if (owner.getName().equals(name)) {            throw new RuntimeException();        }        this.owners.add(owner);    }}