package clinica.consultorio.service.impl;

import clinica.consultorio.dto.OdontologoDTO;
import clinica.consultorio.entidades.Odontologo;
import clinica.consultorio.repositorio.IOdontologoRepository;
import clinica.consultorio.service.IOdontologoService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public OdontologoDTO findById(@NotNull Integer id) {
        Odontologo odontologo = odontologoRepository.getById(id);
        OdontologoDTO newOdontologoDTO = mapToDTO(odontologo);

        return newOdontologoDTO;
    }

    @Override
    public OdontologoDTO create(@NotNull OdontologoDTO odontologoDTO) {
        //DTO recibiendo por parametro
        //1- DTO convertir a entidad
        Odontologo odontologo = mapToEntity(odontologoDTO);
        //2- la entidad guardamos en la base de datos
        Odontologo newOdontologoSave = odontologoRepository.save(odontologo);
        //3- entidad guardad en la base de datos retornamos como DTO
        return mapToDTO(newOdontologoSave);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        //1- buscar la entidad
        //2- verificar que se encontro
        //3- eliminarla
        Odontologo odontologo = odontologoRepository.getById(id);
        odontologoRepository.delete(odontologo);

    }

    @Override
    public OdontologoDTO update(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapToEntity(odontologoDTO);
        Odontologo newOdontologoSave = odontologoRepository.save(odontologo);
        return mapToDTO(newOdontologoSave);
    }

    @Override
    public List<OdontologoDTO> findAll() {
        List<Odontologo> odontologo_list = odontologoRepository.findAll();
        List<OdontologoDTO> odontologoDTOS_list = odontologo_list.stream().map(odo -> mapToDTO(odo)).collect(Collectors.toList());
        return odontologoDTOS_list;
    }

    @Override
    public OdontologoDTO getOdontologoByName(String name) {
        Odontologo odontologo = odontologoRepository.findOdontologoByNombre(name);
        return mapToDTO(odontologo);
    }

    //------ MAPPER -----
    private OdontologoDTO mapToDTO(Odontologo odontologo){
        OdontologoDTO odontologoDTO = modelMapper.map(odontologo,OdontologoDTO.class);

        return odontologoDTO;
    }

    private Odontologo mapToEntity(OdontologoDTO odontologoDTO){
        Odontologo odontologo = modelMapper.map(odontologoDTO, Odontologo.class);

        return odontologo;
    }



}
