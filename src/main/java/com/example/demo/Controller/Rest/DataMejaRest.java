package com.example.demo.Controller.Rest;


import com.example.demo.Model.audit.DataMeja;
import com.example.demo.Repository.DataMejaRepository;
import com.example.demo.Exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
public class DataMejaRest {

    private final DataMejaRepository repository ;

    DataMejaRest(DataMejaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/api/datameja")
    List<DataMeja> all() {
        return repository.findAll();
    }

    @PostMapping("/api/datameja")
    DataMeja newDataMeja(@RequestBody DataMeja newDataMeja) {
        return repository.save(newDataMeja);
    }



    @GetMapping("/employees/{id}")
    DataMeja one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
    }






    @PutMapping("/api/datameja/{id}")
    DataMeja replaceDataMeja(@RequestBody DataMeja newDataMeja, @PathVariable Long id) {

        return repository.findById(id)
                .map(dataMeja -> {
                    dataMeja.setKode_Qr_Meja(newDataMeja.getKode_Qr_Meja());
                    return repository.save(dataMeja);
                })
                .orElseGet(() -> {
                    newDataMeja.setId(id);
                    return repository.save(newDataMeja);
                });
    }

    @DeleteMapping("/api/datameja/{id}")
    void deleteDataMeja(@PathVariable Long id) {
        repository.deleteById(id);
    }



}











