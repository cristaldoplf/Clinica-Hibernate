package clinica.consultorio.service.impl;

import clinica.consultorio.dto.AdressDTO;
import clinica.consultorio.service.IAdressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdressServiceTest {
    @Autowired
    IAdressService adressService;

//    private String street;
//    private String adressNumber;
//    private String town;
//    private String province;

    @Test
    public void createAdressTest() {
        AdressDTO adressDTO = new AdressDTO();
        adressDTO.setStreet("Del Potro");
        adressDTO.setAdressNumber("La Torre");
        adressDTO.setTown("Tandil");
        adressDTO.setProvince("Buenos Aires");

        adressService.create(adressDTO);
        AdressDTO newAdressDTO = adressService.create(adressDTO);

        assertNotNull(newAdressDTO);

    }

    @Test
    public void findAdressTest() {
        assertNotNull(adressService.findById(1));
    }

    @Test
    public void updateAdressTest() {

    }

    @Test
    public void deleteAdressTest() {

    }

    @Test
    public void findAllAdressTest() {

    }


}