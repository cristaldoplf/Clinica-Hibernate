package clinica.consultorio.controller;

import clinica.consultorio.dto.DomicilioDTO;
import clinica.consultorio.dto.OdontologoDTO;
import clinica.consultorio.service.impl.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDTO> findById(@PathVariable("id") Integer id){
        DomicilioDTO domicilioDTO = domicilioService.findById(id);
        return new ResponseEntity<>(domicilioDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DomicilioDTO> create(@RequestBody DomicilioDTO domicilioDTO){
        DomicilioDTO newDomicilioDTO = domicilioService.create(domicilioDTO);
        return new ResponseEntity<>(newDomicilioDTO,HttpStatus.OK);
    }








}
