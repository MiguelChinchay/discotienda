package ulima.discotienda.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ulima.discotienda.mundo.Disco;
import ulima.discotienda.mundo.Cancion;
import ulima.discotienda.mundo.ElementoExisteException;

public class DiscoTestEscenario2 {
	private Disco disco1;

	@Before
	public void setUp() throws Exception {
		/**
		 * Construye un disco con algunas unas canciones
		 */

		disco1 = new Disco("Mi disco1", "artistaPrueba", "Latino",
				"./data/imagenes/prueba.jpg");

		Cancion c1 = new Cancion("C1", 1, 20, 1.50, 2, 96, 2);
		Cancion c2 = new Cancion("C2", 1, 20, 3.45, 2, 96, 2);
		Cancion c3 = new Cancion("C3", 1, 20, 78.10, 2, 96, 2);
		try {
			disco1.agregarCancion(c1);
			disco1.agregarCancion(c2);
			disco1.agregarCancion(c3);
		} catch (ElementoExisteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verifica el método que calcula el precio de un disco. <br>
	 * <b> Métodos a probar: </b> <br>
	 * darPrecioDisco. <br>
	 * <b> Objetivo: </b> Probar que el método darPrecioDisco() calcula
	 * correctamente el valor del precio del disco de acuerdo a las canciones
	 * que este tiene. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Se sabe que el precio de un disco es X. Al pedir el precio del disco
	 * éste debe ser igual a X.
	 */
	@Test
	public void testCalcularPrecio() {

		assertEquals("El cálculo del precio del disco1 está mal", "83.05",
				Double.toString(disco1.darPrecioDisco()));
	}

	/**
	 * Verifica el método darCancion.<br>
	 * Se busca una canción que esté dentro del disco. <br>
	 * <b> Métodos a probar: </b> <br>
	 * darCancion. <br>
	 * <b> Objetivo: </b> Probar que el método darCancion() retorne una canción
	 * que existe en el disco. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al pedir una canción que existe en el disco, ésta debe ser retornada.
	 */
	@Test
	public void testDarCancionOk() {

		Cancion c = disco1.darCancion("C2");
		assertNotNull("La canción C2 se debería haber encontrado", c);
	}

	/**
	 * Verifica el método darNombresCanciones, que debería retornar los nombres
	 * de las 3 canciones que están en el disco. Este método se verifica usando
	 * el escenario 2. <br>
	 * <b> Métodos a probar: </b> <br>
	 * darNombresCanciones. <br>
	 * <b> Objetivo: </b> Probar que el método darNombresCanciones() retornen
	 * los nombres de todas las canciones que hay en el disco. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al pedir el arreglo con los nombres de las canciones de un disco,
	 * dicho arreglo debe contener todos los nombres de las canciones
	 * existentes.
	 */
	@Test
	public void testDarNombresCanciones() {

		ArrayList nombres = disco1.darNombresCanciones();
		assertEquals("El número de nombres es incorrecto", 3, nombres.size());

		String nombre1 = (String) nombres.get(0);
		String nombre2 = (String) nombres.get(1);
		String nombre3 = (String) nombres.get(2);

		assertEquals("El nombre de la canción no es el esperado", "C1", nombre1);
		assertEquals("El nombre de la canción no es el esperado", "C2", nombre2);
		assertEquals("El nombre de la canción no es el esperado", "C3", nombre3);
	}
}
