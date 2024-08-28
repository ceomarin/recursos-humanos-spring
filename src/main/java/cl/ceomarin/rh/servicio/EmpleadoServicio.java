package cl.ceomarin.rh.servicio;

import cl.ceomarin.rh.excepcion.RecursoNoEncontradoExepcion;
import cl.ceomarin.rh.modelo.Empleado;
import cl.ceomarin.rh.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAllEmpleados();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Long id) {
        Empleado empleado = empleadoRepositorio.empleadoFindById(id);
        if (empleado == null) {
            throw new RecursoNoEncontradoExepcion("Empleado no encontrado con ID: " + id);
        }
        return empleado;
    }
    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }
    @Override
    public void eliminarEmpleado(Empleado empleado) {

        if (empleado != null && empleado.getId() != null) {
            empleadoRepositorio.deleteByIdNative(empleado.getId());
        } else {
            throw new IllegalArgumentException("Empleado o ID no puede ser nulo");
        }
    }
}
