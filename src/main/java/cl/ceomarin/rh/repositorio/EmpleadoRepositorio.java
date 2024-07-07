package cl.ceomarin.rh.repositorio;

import cl.ceomarin.rh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado,Long> {
}
