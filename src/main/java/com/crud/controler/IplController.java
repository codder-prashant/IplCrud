package com.crud.controler;

import com.crud.entity.IplTeam;
import com.crud.service.IplService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IplController {


    private final IplService iplService;

    public IplController(IplService iplService) {
        this.iplService = iplService;
    }

    @PostMapping("/insert")// http://localhost:8080/insert
    public ResponseEntity<IplTeam> insertdata(@RequestBody IplTeam iplTeam) {
        IplTeam savedIplTeam = iplService.insertdata(iplTeam);
        return new ResponseEntity<>(savedIplTeam, HttpStatus.CREATED);
    }

    @GetMapping("/all")   // http://localhost:8080/all
    public ResponseEntity<List<IplTeam>> getAll() {
        List<IplTeam> iplTeams = iplService.getAllTeams();
        return ResponseEntity.ok(iplTeams);
    }
    @PutMapping("/update/{id}")  // http://localhost:8080/update/2
    public ResponseEntity<IplTeam> update(@PathVariable  int id, @RequestBody IplTeam iplTeam) {
        IplTeam updatedTeam =iplService.updateTeam(id, iplTeam);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);

    }

    @DeleteMapping("/{id}") // http://localhost:8080/2
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id){
        iplService.delete(id);
        Map<String, Boolean> response=new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/wel")
    public String welcome(){
        return "WeLcome";
    }
}

