package clinica.consultorio.service.impl;

import clinica.consultorio.dto.AdressDTO;
import clinica.consultorio.dto.AppointmentDTO;
import clinica.consultorio.entidades.Adress;
import clinica.consultorio.entidades.Appointment;
import clinica.consultorio.repositorio.IAppointmentRepository;
import clinica.consultorio.service.IAdressService;
import clinica.consultorio.service.IAppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    IAppointmentRepository appointmentRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AppointmentDTO findById(Integer id) {
        Appointment newAppointment = appointmentRepository.getById(id);
        AppointmentDTO newAppointmentDTO = mapToDTO(newAppointment);
        return newAppointmentDTO;
    }

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentRepository.save(mapToEntity(appointmentDTO));
        return mapToDTO(appointment);
    }

    @Override
    public void deleteById(Integer id) {
        Appointment appointment = appointmentRepository.getById(id);
        appointmentRepository.delete(appointment);
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentRepository.save(mapToEntity(appointmentDTO));
        return mapToDTO(appointment);
    }

    @Override
    public List<AppointmentDTO> findAll() {
        return null;
    }


    //------ MAPPER -----
    private AppointmentDTO mapToDTO(Appointment appointment){
        AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);

        return appointmentDTO;
    }

    private Appointment mapToEntity(AppointmentDTO appointmentDTO){
        Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);

        return appointment;
    }
}
