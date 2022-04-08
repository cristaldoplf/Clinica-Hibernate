package clinica.consultorio.service.impl;

import clinica.consultorio.dto.PatientDTO;
import clinica.consultorio.entidades.Patient;
import clinica.consultorio.repositorio.IPatientRepository;
import clinica.consultorio.service.IPatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PatientDTO findById(Integer id) {
        Patient patient = patientRepository.getById(id);
        PatientDTO newPatientDTO = mapToDTO(patient);
        return newPatientDTO;
    }

    @Override
    public PatientDTO create(PatientDTO patientDTO) {
        Patient newPatientSaved = patientRepository.save(mapToEntity(patientDTO));
        PatientDTO newPatientDTO = mapToDTO(newPatientSaved);
        return newPatientDTO;
    }

    @Override
    public void deleteById(Integer id) {
        Patient patient = patientRepository.getById(id);
        patientRepository.delete(patient);
    }

    @Override
    public PatientDTO update(PatientDTO patientDTO) {
        //mapeamos el DTO que entra a una entidad, la persistimos
        //y despues lo que devuelve el save lo mapeamos a DTO para devolverlo.
        Patient patient = mapToEntity(patientDTO);
        Patient newPatientSaved = patientRepository.save(patient);
        return mapToDTO(newPatientSaved);
    }

    @Override
    public List<PatientDTO> findAll() {
        List<Patient> patient_list = patientRepository.findAll();
        List<PatientDTO> patientDTO_list = patient_list.stream().map(pat -> mapToDTO(pat)).collect(Collectors.toList());
        return patientDTO_list;
    }

    @Override
    public PatientDTO getPatientByEmail(String email) {
        Patient patient = patientRepository.findPatientByEmail(email);
        return mapToDTO(patient);
    }

    //------ MAPPER -----
    private PatientDTO mapToDTO(Patient patient){
        PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);

        return patientDTO;
    }

    private Patient mapToEntity(PatientDTO patientDTO){
        Patient patient = modelMapper.map(patientDTO, Patient.class);

        return patient;
    }
}
