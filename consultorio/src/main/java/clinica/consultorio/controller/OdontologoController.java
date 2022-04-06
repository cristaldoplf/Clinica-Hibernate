package clinica.consultorio.controller;

import clinica.consultorio.dto.OdontologoDTO;
import clinica.consultorio.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<OdontologoDTO> findById(@PathVariable("id") Integer id){
        OdontologoDTO odontologoDTO = odontologoService.findById(id);
        return new ResponseEntity<>(odontologoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OdontologoDTO> create (@RequestBody OdontologoDTO odontologoDTO){
        OdontologoDTO newOdontologoDTO = odontologoService.create(odontologoDTO);
        return new ResponseEntity<>(newOdontologoDTO, HttpStatus.OK);
    }



}
