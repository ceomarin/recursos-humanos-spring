package cl.ceomarin.rh.servicio;

import cl.ceomarin.rh.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoPorId(Long id);

    public Empleado guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
