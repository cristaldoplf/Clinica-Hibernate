package clinica.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DomicilioDTO {

    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
