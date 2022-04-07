package clinica.consultorio.service;

import clinica.consultorio.dto.OdontologoDTO;


public interface IOdontologoService extends ICRUDService<OdontologoDTO>{

    OdontologoDTO getOdontologoByName(String name);
}
