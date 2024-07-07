package cl.ceomarin.rh.controlador;

import cl.ceomarin.rh.modelo.Empleado;
import cl.ceomarin.rh.servicio.EmpleadoServicio;
import cl.ceomarin.rh.servicio.IEmpleadoServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
public class EmpleadoRestControlador {

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoRestControlador.class);
    @Autowired
    private IEmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return empleados;
    }
}
