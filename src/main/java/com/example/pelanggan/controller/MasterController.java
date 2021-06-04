package com.example.pelanggan.controller;


import com.example.pelanggan.model.Mastertype;
import com.example.pelanggan.model.lihat;
import com.example.pelanggan.repo.MasterRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("master")
@RestController
public class MasterController {
    @Autowired
    private MasterRepo repo;

    @GetMapping
    @JsonView(lihat.viewMaster.class)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Mastertype> getAll(){
        return repo.getAll();
    }
}
