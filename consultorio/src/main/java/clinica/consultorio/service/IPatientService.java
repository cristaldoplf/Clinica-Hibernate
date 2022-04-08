package clinica.consultorio.service;

import clinica.consultorio.dto.PatientDTO;

public interface IPatientService extends ICRUDService<PatientDTO>{

    PatientDTO getPatientByEmail(String email);
}
