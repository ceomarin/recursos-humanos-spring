package cl.ceomarin.rh.repositorio;

import cl.ceomarin.rh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado,Long> {

    @Query(value = "SELECT * FROM empleado", nativeQuery = true)
    List<Empleado> findAllEmpleados();

    @Query(value = "SELECT * FROM empleado WHERE id_empleado=:id_empleado", nativeQuery = true)
    Empleado empleadoFindById(@Param("id_empleado")Long id_empleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleado WHERE id_empleado = :id_empleado", nativeQuery = true)
    void deleteByIdNative(@Param("id_empleado") Long id_empleado);

}
