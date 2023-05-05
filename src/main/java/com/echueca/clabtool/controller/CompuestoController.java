package com.echueca.clabtool.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clabtool")
public class CompuestoController {
    /*
    @Autowired
    private ICompuestoService compuestoService;
    
    @GetMapping("/compuesto")
    public List<Compuesto> getCompuesto() throws JsonProcessingException, IOException {
        return this.compuestoService.getCompuesto();
    }
    
    @GetMapping("/compuesto/{id}")
    public Compuesto getCompuestoById(@PathVariable String id) throws JsonProcessingException, IOException {
        return this.compuestoService.getCompuestoById(id);
    }
    
    @PostMapping("/compuesto")
    public ResponseEntity<?> saveCompuesto(@RequestBody Compuesto compuesto) throws JsonProcessingException, IOException {
        return this.compuestoService.saveCompuesto(compuesto);
    }
    
    @PutMapping("/compuesto")
    public ResponseEntity<?> updateCompuesto(@RequestBody Compuesto compuesto) throws JsonProcessingException, IOException {
        return this.compuestoService.updateCompuesto(compuesto);
    }*/
}
