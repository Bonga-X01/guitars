package com.guitars.guitars.guitar;

import com.guitars.guitars.instrument.Instrument;
import com.guitars.guitars.instrument.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuitarController {
    @Autowired
    GuitarService guitarService; //todo: remove guitarService
    @Autowired
    InstrumentService instrumentService;

    @PostMapping("inventory/guitars/add")
    public void addGuitar(@RequestParam(name = "serialNumber") String serialNumber,
                          @RequestParam(name = "builder") String builder,
                          @RequestParam(name = "model") String model,
                          @RequestParam(name = "type") String type,
                          @RequestParam(name = "backWood") String backWood,
                          @RequestParam(name = "topWood") String topWood,
                          @RequestParam(name = "price") String price,
                          @RequestParam(name = "numStrings") int numStrings
                          ) {
        GuitarSpec spec = new GuitarSpec(builder, model, type, backWood, topWood, numStrings);
        Guitar newGuitar = new Guitar(serialNumber, price, spec);
        instrumentService.addInstrument(newGuitar);
    }
    @GetMapping("/guitars/get")
    public List<Instrument> readGuitar(@RequestParam(name = "builder") String builder,
                          @RequestParam(name = "model") String model,
                          @RequestParam(name = "type") String type,
                          @RequestParam(name = "backWood") String backWood,
                          @RequestParam(name = "topWood") String topWood,
                          @RequestParam(name = "numStrings") int numStrings
    ) {
        List<Instrument> matchingGuitars;
        //create a new SearchGuitar object with request Param
        GuitarSpec guitarSpec = new GuitarSpec(builder, model, type, backWood, topWood, numStrings);
        //access the service and use repository to find matches
        matchingGuitars = instrumentService.readMatching(guitarSpec);
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
                             @RequestParam(name = "numStrings") int numStrings,
                             @PathVariable int id
    ){
        GuitarSpec guitarSpec = new GuitarSpec(builder, model, type, backWood, topWood, numStrings);
        guitarService.updateGuitar(guitarSpec, id);
    }
    @DeleteMapping("/guitars/delete/{id}")
    public void deleteGuitar(@PathVariable int id) {
        guitarService.deleteGuitar(id);
    }
}
