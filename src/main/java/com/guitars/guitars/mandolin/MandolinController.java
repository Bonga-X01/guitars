package com.guitars.guitars.mandolin;

import com.guitars.guitars.guitar.GuitarSpec;
import com.guitars.guitars.instrument.Instrument;
import com.guitars.guitars.instrument.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MandolinController {
    @Autowired
    InstrumentService instrumentService;

    @PostMapping("inventory/mandolins/add")
    public void addMandolin(@RequestParam(name = "serialNumber") String serialNumber,
                            @RequestParam(name = "builder") String builder,
                            @RequestParam(name = "model") String model,
                            @RequestParam(name = "type") String type,
                            @RequestParam(name = "backWood") String backWood,
                            @RequestParam(name = "topWood") String topWood,
                            @RequestParam(name = "price") String price,
                            @RequestParam(name = "style") String style
    ) {
        MandolinSpec spec = new MandolinSpec(builder, model, type, backWood, topWood, style);
        Mandolin newMandolin = new Mandolin(serialNumber, price, spec);
        instrumentService.addInstrument(newMandolin);
    }
    @GetMapping("/inventory/mandolins/get")
    public List<Instrument> readMandolin(@RequestParam(name = "builder") String builder,
                                       @RequestParam(name = "model") String model,
                                       @RequestParam(name = "type") String type,
                                       @RequestParam(name = "backWood") String backWood,
                                       @RequestParam(name = "topWood") String topWood,
                                       @RequestParam(name = "style") String style
    ) {
        List<Instrument> matchingMandolins;
        //create a new SearchGuitar object with request Param
        MandolinSpec mandolinSpec = new MandolinSpec(builder, model, type, backWood, topWood, style);
        //access the service and use repository to find matches
        matchingMandolins = instrumentService.readMatching(mandolinSpec);
        System.out.println("from controller");
        matchingMandolins.forEach(System.out::println);

        return matchingMandolins;
    }
}
