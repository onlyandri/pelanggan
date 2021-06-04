package com.example.pelanggan.controller;

import com.example.pelanggan.model.Pelanggan;
import com.example.pelanggan.model.Transaksi;
import com.example.pelanggan.model.lihat;
import com.example.pelanggan.repo.TransaksiRepo;
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

@RequestMapping("transaksi")

@RestController
public class TransakasiController {
    @Autowired
    private TransaksiRepo repo;

    @GetMapping
    @JsonView(lihat.viewlist.class)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Transaksi> getAll(){
        return repo.getALL();
    }

    @GetMapping("/detail/{id}")
    @JsonView(lihat.viewTransaksi.class)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Transaksi> getByIdPelanggan(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse res, UriComponentsBuilder uri){
       return repo.getByIdPelanggan(id);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> simpan(@RequestBody Transaksi t, HttpServletRequest req, HttpServletResponse res, UriComponentsBuilder uri) {
        repo.Tambah(t);
        HttpHeaders h = new HttpHeaders();
        return new ResponseEntity<Void>(h, HttpStatus.CREATED);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> update(@RequestBody Transaksi t, HttpServletRequest req, HttpServletResponse res, UriComponentsBuilder uri) {
        repo.Update(t);
        HttpHeaders h = new HttpHeaders();
        return new ResponseEntity<Void>(h, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @JsonView(lihat.viewdetail.class)
    public Transaksi getdetail(@PathVariable("id") int id_transaksi) {
        return repo.get(id_transaksi);
    }

    @DeleteMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@RequestBody Transaksi t, HttpServletRequest req, HttpServletResponse res, UriComponentsBuilder uri) {
        repo.delete(t);
        HttpHeaders h = new HttpHeaders();
        return new ResponseEntity<Void>(h, HttpStatus.OK);
    }
}
