package clinica.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentDTO {

    private Integer id;
    private LocalDate fecha;
    private Time hora;
    private Integer id_patient;
    private Integer id_dentist;
}
