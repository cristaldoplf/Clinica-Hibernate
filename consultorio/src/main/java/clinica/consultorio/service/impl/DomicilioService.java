package clinica.consultorio.service.impl;

import clinica.consultorio.dto.DomicilioDTO;
import clinica.consultorio.dto.OdontologoDTO;
import clinica.consultorio.entidades.Domicilio;
import clinica.consultorio.entidades.Odontologo;
import clinica.consultorio.repositorio.IDomicilioRepository;
import clinica.consultorio.service.IDomicilioService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DomicilioDTO findById(@NotNull Integer id) {
        Domicilio domicilio = domicilioRepository.getById(id);
        DomicilioDTO newDomiciolio = mapToDTO(domicilio);
        return newDomiciolio;

    }

    @Override
    public DomicilioDTO create(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapToEntity(domicilioDTO);
        //save devuelve lo que creo, por eso lo guardamos y lo mapeamos, es la devolucion
        //del save, no el mismo objeto que entra por parametro.
        Domicilio newDomicilio = domicilioRepository.save(domicilio);
        System.out.println("######################################################");
        System.out.println(newDomicilio.getId());
        return mapToDTO(newDomicilio);
    }

    @Override
    public void deleteById(Integer id) {
        //1- buscar la entidad
        //2- verificar que se encontro
        //3- eliminarla
        Domicilio domicilio = domicilioRepository.getById(id);
        domicilioRepository.delete(domicilio);
    }

    @Override
    public DomicilioDTO update(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapToEntity(domicilioDTO);
        Domicilio newDomicilio = domicilioRepository.save(domicilio);
        return mapToDTO(newDomicilio);
    }


    @Override
    public List<DomicilioDTO> findAll() {
        List<Domicilio> domicilio_list = domicilioRepository.findAll();
        List<DomicilioDTO> domicilioDTO_list = domicilio_list.stream().map(dom -> mapToDTO(dom)).collect(Collectors.toList());
        return domicilioDTO_list;
    }

    //------ MAPPER -----
    private DomicilioDTO mapToDTO(Domicilio domicilio){
        DomicilioDTO domicilioDTO = modelMapper.map(domicilio,DomicilioDTO.class);

        return domicilioDTO;
    }

    private Domicilio mapToEntity(DomicilioDTO domicilioDTO){
        Domicilio domicilio = modelMapper.map(domicilioDTO, Domicilio.class);

        return domicilio;
    }
}


