package clinica.consultorio.controller;


import clinica.consultorio.dto.PatientDTO;
import clinica.consultorio.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/{id}")
    ResponseEntity<PatientDTO> findById(@PathVariable("id") Integer id){
        PatientDTO patientDTO = patientService.findById(id);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<PatientDTO> create(@RequestBody PatientDTO patientDTO){
        PatientDTO newPatientDTO =  patientService.create(patientDTO);
        return new ResponseEntity<>(newPatientDTO, HttpStatus.OK);
    }
}
