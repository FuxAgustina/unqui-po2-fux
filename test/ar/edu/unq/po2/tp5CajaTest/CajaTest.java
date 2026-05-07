package ar.edu.unq.po2.tp5CajaTest;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unq.po2.tp5.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaTest {
    private Caja caja;
    private Producto arroz;
    private Producto cooperativaLeche;
    private Servicio luz;
    private Impuesto abl;
    private Agencia stubAgencia;

    @BeforeEach
    public void setUp() {
        stubAgencia = new Agencia() {
            @Override
            public void registrarPago(Factura factura) {

            }
        };
        caja = new Caja(stubAgencia);
        arroz = new Producto(90d, 2, "Arroz");
        cooperativaLeche = new ProductoCooperativa(200d, 1, "Leche");
    }

    @Test
    public void testRegistrarProductoYVerificarMonto(){
        caja.registrarProducto(cooperativaLeche);
        assertEquals(180d, caja.getMontoAPagar());
    }

    @Test
    public void noHayStock(){
        caja.registrarProducto(arroz);
        caja.registrarProducto(arroz);
        caja.registrarProducto(arroz);

        assertEquals(180d, caja.getMontoAPagar());
        assertEquals(0, arroz.getStock());
    }

    @Test
    public void testRegistrarFacturaServicio() {
        luz = new Servicio(10d, 5);
        caja.registrarFactura(luz);

        assertEquals(50d, caja.getMontoAPagar());
    }

    @Test
    public void testRegistrarFacturaImpuesto() {
        abl = new Impuesto(200d);
        caja.registrarFactura(abl);

        assertEquals(200d, caja.getMontoAPagar());
    }

    @Test
    public void testCompraMixtaDeProductosYFacturas() {
        caja.registrarProducto(arroz);
        caja.registrarProducto(cooperativaLeche);

        abl = new Impuesto(200d);
        caja.registrarFactura(abl);

        assertEquals(470d, caja.getMontoAPagar());
    }
}

