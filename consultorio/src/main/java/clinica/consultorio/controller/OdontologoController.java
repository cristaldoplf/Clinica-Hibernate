package clinica.consultorio.controller;

import clinica.consultorio.dto.OdontologoDTO;
import clinica.consultorio.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("api/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> findById(@PathVariable("id") Integer id) {
        OdontologoDTO odontologoDTO = odontologoService.findById(id);
        return new ResponseEntity<>(odontologoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OdontologoDTO> create(@RequestBody OdontologoDTO odontologoDTO) {
        OdontologoDTO newOdontologoDTO = odontologoService.create(odontologoDTO);
        return new ResponseEntity<>(newOdontologoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        odontologoService.deleteById(id);
        return new ResponseEntity<>("Odontologo eliminado", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<OdontologoDTO> update(@RequestBody OdontologoDTO odontologoDTO) throws ServerException{
        if (odontologoDTO.getId() == null){
            throw new ServerException("El request no trae id");
        }
        if(odontologoService.findById(odontologoDTO.getId()) == null){
            throw new ServerException("Odontologo no encontrado");
        }else{
            OdontologoDTO updateOdontologo = odontologoService.update(odontologoDTO);
            return new ResponseEntity<>(updateOdontologo, HttpStatus.OK);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<OdontologoDTO>> findAll(){
        List<OdontologoDTO> odontologoDTOList=odontologoService.findAll();
        return new ResponseEntity<>(odontologoDTOList,HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<OdontologoDTO> findByName(@RequestParam String name){
        OdontologoDTO odontologoDTO = odontologoService.getOdontologoByName(name);
        return new ResponseEntity<>(odontologoDTO,HttpStatus.OK);
    }


}
