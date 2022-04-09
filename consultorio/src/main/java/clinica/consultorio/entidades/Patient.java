package clinica.consultorio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastname;
    private String name;
    private String email;
    private int dni;
    private LocalDate admissionDate;

    @OneToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adress", referencedColumnName = "id")
    private Adress adress;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dni=" + dni +
                ", admissionDate=" + admissionDate +
                ", adress=" + adress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
