package ar.edu.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class EmpresaTest {
    private Empresa empresa;
    private Empleado plantaPerm;
    private Empleado plantaTemp;
    private Empleado contratado;

    @BeforeEach
    public void setUp() {
        empresa = new Empresa("UNQ S.A.", 202600000);

        plantaPerm = new EmpleadoPlantaPermanente("Agustina", "Wilde", LocalDate.of(2004, 7, 13), 50000d, 2, true, 10);
        plantaTemp = new EmpleadoPlantaTemporaria("Tobias", "Wilde", LocalDate.of(1970, 8, 21), 40000d, 5);
        contratado = new EmpleadoContratado("Chiara", "Wilde", LocalDate.of(2004, 10, 4), 30000d, "Soltera", 10000, "Transferencia");


        empresa.agregarEmpleado(plantaPerm);
        empresa.agregarEmpleado(plantaTemp);
        empresa.agregarEmpleado(contratado);
    }

    @Test
    public void testSueldoBrutoPlantaPermanente() {
        assertEquals(50900d, plantaPerm.sueldoBruto(), 0.01);
    }

    @Test
    public void testRetencionesPlantaTemporariaMayorDe50() {
        assertEquals(8090d, plantaTemp.retenciones(), 0.01);
    }

    @Test
    public void testSueldoNetoContratado() {
        assertEquals(29950d, contratado.sueldoNeto(), 0.01);
    }

    @Test
    public void testMontoTotalSueldosNetosEmpresa() {
        Double sumaEsperada = plantaPerm.sueldoNeto() + plantaTemp.sueldoNeto() + contratado.sueldoNeto();
        assertEquals(sumaEsperada, empresa.montoTotalSueldosNetos(), 0.01);
    }

    @Test
    public void testLiquidacionGeneraRecibos() {
        empresa.liquidarSueldos();
        assertEquals(3, empresa.getRecibos().size());
    }
}