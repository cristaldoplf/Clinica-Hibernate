package clinica.consultorio.repositorio;

import clinica.consultorio.entidades.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Integer> {

    //@Query("FROM Odontologo o WHERE o.nombre = :name")
    //Odontologo getOdontologoByName(@Param("name") String name);

    public Odontologo findOdontologoByNombre(String nombre);
    //find+NombreClase+By+NombreAtributo
}
