package tp2_fxml.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import tp2_fxml.exception.FormeException;
import tp2_fxml.modele.Ovale;

public class OvaleTest {

	private Ovale c1, c2, c3, c4;
	//TODO MODIFIER ...pourquoi?
	@Before
	public void setUp() throws Exception {
		try {
			c1 = new Ovale(1, 10);
			c2 = new Ovale(5, 7);
			c3 = new Ovale(11, 1);
			c4 = new Ovale(28, 1999);
		} catch (FormeException e) {
		}
	}

	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
	}

	@Test
	public void testOvale() {
		// Ovale invalides
		try {
			Ovale c5 = new Ovale(Ovale.MIN_VAL - 1, 1);
			fail();
		} catch (FormeException e) {

		}
		try {
			Ovale c6 = new Ovale(Ovale.MAX_VAL + 1, 1);
			fail();
		} catch (FormeException e) {

		}
	}

	

	
	@Test
	public void testToString() {
		assertTrue(c1.toString().equals("Ovale de 1 de largeur et de 10 de hauteur"));
		assertTrue(c2.toString().equals("Ovale de 5 de largeur et de 7 de hauteur"));
		assertTrue(c3.toString().equals("Ovale de 11 de largeur et de 1 de hauteur"));
	}

	@Test
	public void testSetLargeur() {
		// Borne supérieure
		c1.setLargeur(Ovale.MAX_VAL);
		assertTrue(c1.getLargeur() == Ovale.MAX_VAL);
		// Trop haut
		c2.setLargeur(Ovale.MAX_VAL + 1);
		assertTrue(c2.getLargeur() == 5);
		// Borne inférieure
		c3.setLargeur(Ovale.MIN_VAL);
		assertTrue(c3.getLargeur() == Ovale.MIN_VAL);
		// Trop bas
		c4.setLargeur(Ovale.MIN_VAL - 1);
		assertTrue(c4.getLargeur() == 28);
	}
	
	@Test
	public void testSetHauteur(){
		// Borne supérieure
				c1.setHauteur(Ovale.MAX_VAL);
				assertTrue(c1.getHauteur() == Ovale.MAX_VAL);
				// Trop haut
				c2.setHauteur(Ovale.MAX_VAL + 1);
				assertTrue(c2.getHauteur() == 7);
				// Borne inférieure
				c3.setHauteur(Ovale.MIN_VAL);
				assertTrue(c3.getHauteur() == Ovale.MIN_VAL);
				// Trop bas
				c4.setHauteur(Ovale.MIN_VAL - 1);
				assertTrue(c4.getHauteur() == 1999);
	}
	
}
