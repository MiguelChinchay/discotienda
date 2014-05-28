package ulima.discotienda.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ulima.discotienda.mundo.Disco;
import ulima.discotienda.mundo.Cancion;
import ulima.discotienda.mundo.ElementoExisteException;

public class DiscoTestEscenario1 {
	private Disco disco1;

	@Before
	public void setUp() throws Exception {
		/**
		 * Construye un disco sin canciones
		 */
		disco1 = new Disco("Mi disco1", "artistaPrueba", "Latino", "prueba.jpg");
	}

	/**
	 * Prueba que las canciones se agreguen correctamente. <br>
	 * <b> M�todos a probar: </b> <br>
	 * agregarCancion. <br>
	 * <b> Objetivo: </b> Probar que el m�todo agregarCancion() es capaz de
	 * agregar canciones de forma correcta a la tienda. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar una canci�n que no existe en un disco, esta debe ser
	 * adicionada al disco. <br>
	 * 2. Al agregar una canci�n que existe en un disco se debe arrojar una
	 * excepci�n indic�ndolo.
	 */
	@Test
	public void testAgregarCancion() {

		Cancion c1 = new Cancion("Cancion1", 1, 20, 1.50, 2, 96, 0);
		Cancion c2 = new Cancion("Cancion1", 2, 40, 3.45, 2, 96, 0);
		try {
			disco1.agregarCancion(c1);
		} catch (ElementoExisteException e) {
			fail();
		}
		try {
			disco1.agregarCancion(c2);
			fail();
		} catch (ElementoExisteException e) {
			assertTrue(true);
		}
	}
    /**
     * Verifica los m�todos que retornan datos del disco1. <br>
     * <b> M�todos a probar: </b> <br>
     * darNombreDisco, darArtista, darGenero, darImagen. <br>
     * <b> Objetivo: </b> Probar que los m�todos que dan informaci�n de un disco retornan la informaci�n correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el nombre de un disco es X. Al pedir el nombre del disco �ste debe ser igual a X. <br>
     * 2. Se sabe que el del artista de un disco es X. Al pedir el artista del disco �ste debe ser igual a X. <br>
     * 3. Se sabe que el nombre del g�nero de un disco es X. Al pedir el g�nero del disco �ste debe ser igual a X. <br>
     * 4. Se sabe que la imagen de un disco es X. Al pedir la imagen del disco �ste debe ser igual a X.
     */

	@Test
	public void testDatos() { 
        assertEquals( "El nombre del disco1 est� mal", "Mi disco1", disco1.darNombreDisco( ) );
        assertEquals( "El artista del disco1 est� mal", "artistaPrueba", disco1.darArtista( ) );
        assertEquals( "El g�nero del disco1 est� mal", "Latino", disco1.darGenero( ) );
        assertEquals( "La imagen del disco1 est� mal", "prueba.jpg", disco1.darImagen( ) );

		
	}
	
}
