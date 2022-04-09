package clinica.consultorio.service.impl;

import clinica.consultorio.dto.AdressDTO;
import clinica.consultorio.entidades.Adress;
import clinica.consultorio.repositorio.IAdressRepository;
import clinica.consultorio.service.IAdressService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdressService implements IAdressService {

    @Autowired
    private IAdressRepository adressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdressDTO findById(@NotNull Integer id) {
        Adress adress = adressRepository.getById(id);
        AdressDTO newAdress = mapToDTO(adress);
        return newAdress;


    }

    @Override
    public AdressDTO create(AdressDTO adressDTO) {
        Adress adress = mapToEntity(adressDTO);
        //save devuelve lo que creo, por eso lo guardamos y lo mapeamos, es la devolucion
        //del save, no el mismo objeto que entra por parametro.
        Adress newAdress = adressRepository.save(adress);
        return mapToDTO(newAdress);
    }

    @Override
    public void deleteById(Integer id) {
        //1- buscar la entidad
        //2- verificar que se encontro
        //3- eliminarla
        Adress adress = adressRepository.getById(id);
        adressRepository.delete(adress);
    }

    @Override
    public AdressDTO update(AdressDTO adressDTO) {
        Adress adress = mapToEntity(adressDTO);
        Adress newAdress = adressRepository.save(adress);
        return mapToDTO(newAdress);
    }


    @Override
    public List<AdressDTO> findAll() {
        List<Adress> adress_list = adressRepository.findAll();
        List<AdressDTO> adressDTO_list = adress_list.stream().map(adress -> mapToDTO(adress)).collect(Collectors.toList());
        return adressDTO_list;
    }

    //------ MAPPER -----
    private AdressDTO mapToDTO(Adress adress){
        AdressDTO adressDTO = modelMapper.map(adress, AdressDTO.class);

        return adressDTO;
    }

    private Adress mapToEntity(AdressDTO adressDTO){
        Adress adress = modelMapper.map(adressDTO, Adress.class);

        return adress;
    }
}


