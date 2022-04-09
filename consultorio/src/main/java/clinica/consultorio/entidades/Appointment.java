package clinica.consultorio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha;
    private Time hora;
    private Integer id_patient;
    private Integer id_dentist;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id) && Objects.equals(fecha, that.fecha) && Objects.equals(hora, that.hora) && Objects.equals(id_patient, that.id_patient) && Objects.equals(id_dentist, that.id_dentist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, hora, id_patient, id_dentist);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", id_patient=" + id_patient +
                ", id_dentist=" + id_dentist +
                '}';
    }
}
