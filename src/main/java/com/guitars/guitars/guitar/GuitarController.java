package com.guitars.guitars.guitar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuitarController {
    @Autowired
    GuitarService guitarService;
    @PostMapping("/guitars/add")
    public void addGuitar(@RequestParam(name = "serialNumber") String serialNumber,
                          @RequestParam(name = "builder") String builder,
                          @RequestParam(name = "model") String model,
                          @RequestParam(name = "type") String type,
                          @RequestParam(name = "backWood") String backWood,
                          @RequestParam(name = "topWood") String topWood,
                          @RequestParam(name = "price") String price
                          ) {
        //create a new guitar object with properties from client
        Guitar newGuitar = new Guitar(serialNumber, builder, model, type, backWood, topWood, price);
        //access the service and use repository to save new guitar
        guitarService.addGuitar(newGuitar);
    }
    @GetMapping("/guitars/get")
    public List<Guitar> readGuitar(@RequestParam(name = "builder") String builder,
                          @RequestParam(name = "model") String model,
                          @RequestParam(name = "type") String type,
                          @RequestParam(name = "backWood") String backWood,
                          @RequestParam(name = "topWood") String topWood
    ) {
        List<Guitar> matchingGuitars;
        //create a new SearchGuitar object with request Param
        GuitarSpec guitarSpec = new GuitarSpec(builder, model, type, backWood, topWood);
        //access the service and use repository to find matches
        matchingGuitars = guitarService.searchGuitars(guitarSpec);
        System.out.println("from controller");
        matchingGuitars.forEach(System.out::println);

        return matchingGuitars;
    }
    @GetMapping("/guitars/getAll")
    public List<Guitar> getAllGuitars() {
        List<Guitar> matchingGuitars;

        //access the service and use repository to find all
        matchingGuitars = guitarService.getAllGuitars();
        System.out.println("from controller");

        return matchingGuitars;
    }
    @PutMapping("/guitars/update/{id}")
    public void updateGuitar(@RequestParam(name = "builder") String builder,
                             @RequestParam(name = "model") String model,
                             @RequestParam(name = "type") String type,
                             @RequestParam(name = "backWood") String backWood,
                             @RequestParam(name = "topWood") String topWood,
                             @PathVariable int id
    ){
        GuitarSpec guitarSpec = new GuitarSpec(builder, model, type, backWood, topWood);
        guitarService.updateGuitar(guitarSpec, id);
    }
    @DeleteMapping("/guitars/delete/{id}")
    public void deleteGuitar(@PathVariable int id) {
        guitarService.deleteGuitar(id);
    }
}
