package com.example.pelanggan.controller;

import com.example.pelanggan.model.Pelanggan;
import com.example.pelanggan.model.Transaksi;
import com.example.pelanggan.model.lihat;
import com.example.pelanggan.repo.PelangganRepo;
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
@RequestMapping("pelanggan")
@RestController
public class PelangganController {
    @Autowired
    private PelangganRepo repo;

    @GetMapping
    @JsonView(lihat.viewlist.class)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Pelanggan> getall() {
        return repo.getall();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @JsonView(lihat.viewdetail.class)
    public Pelanggan getdetail(@PathVariable("id") int idpelanggan) {
        return repo.get(idpelanggan);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> simpan(@RequestBody Pelanggan pel, HttpServletRequest req, HttpServletResponse res, UriComponentsBuilder uri) {
        repo.tambah(pel);
        HttpHeaders h = new HttpHeaders();
        return new ResponseEntity<Void>(h, HttpStatus.CREATED);
    }
    @PutMapping("/edit")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> update(@RequestBody Pelanggan pel, HttpServletRequest req, HttpServletResponse res, UriComponentsBuilder uri) {
        repo.update(pel);
        HttpHeaders h = new HttpHeaders();
        return new ResponseEntity<Void>(h, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable("id") int idpelanggan) {
        repo.delete(idpelanggan);
        HttpHeaders h = new HttpHeaders();
        return new ResponseEntity<Void>(h, HttpStatus.OK);
    }

    @GetMapping(value = "byNama")
    @JsonView(lihat.viewlist.class)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Transaksi> getByName(@RequestBody Pelanggan pel, HttpServletRequest req, HttpServletResponse res, UriComponentsBuilder uri){
       return repo.getByName(pel.getNama());
    }

    @PostMapping(value="login")
    @JsonView(lihat.viewdetail.class)
    @CrossOrigin(origins = "http://localhost:4200")
    public Pelanggan getLogin(@RequestBody Pelanggan pel) throws Exception {
        String tempUser = pel.getNama();
        String password = pel.getPassword();

        HttpHeaders h = new HttpHeaders();
      Object userObj = null;
        if(tempUser != null & password != null){
            userObj = repo.getByNamePassword(tempUser,password);
        }
        if (userObj == null){
            throw new Exception("tidak terdaftar");
        }
        return (Pelanggan) userObj;
    }
}
