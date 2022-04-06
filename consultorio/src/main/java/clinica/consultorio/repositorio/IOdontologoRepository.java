package clinica.consultorio.repositorio;

import clinica.consultorio.entidades.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Integer> {
}
