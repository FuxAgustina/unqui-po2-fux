package ar.edu.unq.po2.tp4.supermercado;

import ar.edu.unq.po2.tp4.src.supermercado.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {
	
	private Producto arroz;
	private Producto vino;
	
	@BeforeEach
	public void setUp() {
		arroz = new Producto("Arroz", true, 18.9d);
		vino = new Producto("Vino", false, 55d);
	}
	
	@Test
	public void testConstructor() {
		assertEquals("Arroz", arroz.getNombre());
		assertEquals(new Double(18.9), arroz.getPrecio());
		assertTrue(arroz.esPrecioCuidado());
		
		assertEquals("Vino", vino.getNombre());
		assertEquals(new Double(55), vino.getPrecio());
		assertFalse(vino.esPrecioCuidado());
	}
	
	@Test
	public void testAumentarPrecio() {
		arroz.aumentarPrecio(1.5);
		assertEquals(new Double(20.4), arroz.getPrecio());
	}
}
