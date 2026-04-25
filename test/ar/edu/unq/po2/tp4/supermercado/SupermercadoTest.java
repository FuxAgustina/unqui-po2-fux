package ar.edu.unq.po2.tp4.supermercado;

import ar.edu.unq.po2.tp4.src.supermercado.Producto;
import ar.edu.unq.po2.tp4.src.supermercado.Supermercado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SupermercadoTest {
	
	private Producto arroz;
	private Producto detergente;
	private Supermercado supermercado;
	private Producto vino;
	
	@BeforeEach
	public void setUp() {
		arroz = new Producto("Arroz", true, 18.9d);
		detergente = new Producto("Detergente", false, 75d);
		supermercado = new Supermercado("Lo de Tito", "Av Zubeldia 801");
		
	}
	
	@Test
	public void testCantidadDeProductos() {
		assertEquals(0, supermercado.getCantidadDeProductos());
		supermercado.agregarProducto(arroz);
		supermercado.agregarProducto(detergente);
		assertEquals(2, supermercado.getCantidadDeProductos());
	}
	
	@Test
	public void testPrecioTotal() {
		assertEquals(new Double(0), supermercado.getPrecioTotal());
		supermercado.agregarProducto(arroz);
		supermercado.agregarProducto(detergente);
		assertEquals(new Double(93.9), supermercado.getPrecioTotal());
	}
}
