package clinica.consultorio.controller;

import clinica.consultorio.dto.DomicilioDTO;
import clinica.consultorio.dto.OdontologoDTO;
import clinica.consultorio.entidades.Domicilio;
import clinica.consultorio.service.impl.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("api/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDTO> findById(@PathVariable("id") Integer id) {
        DomicilioDTO domicilioDTO = domicilioService.findById(id);
        return new ResponseEntity<>(domicilioDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DomicilioDTO> create(@RequestBody DomicilioDTO domicilioDTO) {
        DomicilioDTO newDomicilioDTO = domicilioService.create(domicilioDTO);
        return new ResponseEntity<>(newDomicilioDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        domicilioService.deleteById(id);
        return new ResponseEntity<>("Domicilio Eliminado", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DomicilioDTO> update(@RequestBody DomicilioDTO domicilioDTO) throws ServerException {
        if (domicilioDTO.getId() == null) {
            throw new ServerException("El request no trae id");
        }
        if (domicilioService.findById(domicilioDTO.getId()) == null) {
            throw new ServerException("Odontologo no encontrado");
        } else {
            DomicilioDTO updateOdontologo = domicilioService.update(domicilioDTO);
            return new ResponseEntity<>(updateOdontologo, HttpStatus.OK);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<DomicilioDTO>> findAll() {
        List<DomicilioDTO> domicilio_list = domicilioService.findAll();
        return new ResponseEntity<>(domicilio_list, HttpStatus.OK);
    }


}
