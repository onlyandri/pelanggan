package com.example.pelanggan.controller;

import com.example.pelanggan.model.Typepelanggan;
import com.example.pelanggan.model.lihat;
import com.example.pelanggan.repo.JenisRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("jenis")
@RestController
public class JenisController {
    @Autowired
    private JenisRepo repo;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    @JsonView(lihat.viewJenis.class)
    public List<Typepelanggan> getAll(){return repo.getAll();}

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> simpan(@RequestBody Typepelanggan a, HttpServletRequest req, HttpServletResponse res, UriComponentsBuilder uri){
        repo.Tambah(a);
        HttpHeaders h = new HttpHeaders();
        return new ResponseEntity<Void>(h, HttpStatus.CREATED);
    }
    @PutMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> update(@RequestBody Typepelanggan a, HttpServletRequest req, HttpServletResponse res, UriComponentsBuilder uri){
        repo.update(a);
        HttpHeaders h = new HttpHeaders();
        return new ResponseEntity<Void>(h, HttpStatus.CREATED);
    }

    @GetMapping(value = "getByMaster/{id}")
    @JsonView(lihat.viewMaster.class)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Typepelanggan> getByMaster(@PathVariable("id") int idMaster){
        return repo.getByIdMaster(idMaster);
    }
}
