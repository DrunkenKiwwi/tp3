package tp2_fxml.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import tp2_fxml.exception.FormeException;
import tp2_fxml.modele.Rectangle;

public class RectangleTest {

	private Rectangle r1, r2, r3, r4;
	@Before
	public void setUp() throws Exception {
		try {
			r1 = new Rectangle(1, 2);
			r2 = new Rectangle(10, 5);
			r3 = new Rectangle(7, 11);
			r4 = new Rectangle(19, 3);
		} catch (FormeException e) {
		}
	}

	@After
	public void tearDown() throws Exception {
		r1 = null;
		r2 = null;
		r3 = null;
		r4 = null;
	}

	@Test
	public void testRectangle() {
		// Rectangles invalides
		try {
			Rectangle r5 = new Rectangle(10, Rectangle.MIN_VAL - 1);
			fail();
		} catch (FormeException e) {

		}
		try {
			Rectangle r6 = new Rectangle(Rectangle.MIN_VAL - 1, 5);
			fail();
		} catch (FormeException e) {

		}
		try {
			Rectangle r7 = new Rectangle(Rectangle.MAX_VAL + 1, 10);
			fail();
		} catch (FormeException e) {

		}
		try {
			Rectangle r8 = new Rectangle(5, Rectangle.MAX_VAL + 1);
			fail();
		} catch (FormeException e) {

		}
	}

	@Test
	public void testCalculerSurface() {
		assertTrue(r1.calculerSurface() == 2);
		assertTrue(r2.calculerSurface() == 50);
		assertTrue(r3.calculerSurface() == 77);
		assertTrue(r4.calculerSurface() == 57);
	}

	@Test
	public void testCalculerPerimetre() {
		assertTrue(r1.calculerPerimetre() == 6);
		assertTrue(r2.calculerPerimetre() == 30);
		assertTrue(r3.calculerPerimetre() == 36);
		assertTrue(r4.calculerPerimetre() == 44);
	}

	

	@Test
	public void testToString() {
		assertTrue(r1.toString().equals("Rectangle de 1 de largeur et de 2 de hauteur"));
		assertTrue(r2.toString().equals("Rectangle de 10 de largeur et de 5 de hauteur"));
		assertTrue(r3.toString().equals("Rectangle de 7 de largeur et de 11 de hauteur"));
		assertTrue(r4.toString().equals("Rectangle de 19 de largeur et de 3 de hauteur"));
		
	}

	@Test
	public void testSetHauteur() {
		// Borne supérieure
		r1.setHauteur(Rectangle.MAX_VAL);
		assertTrue(r1.getHauteur() == Rectangle.MAX_VAL);
		// Borne inférieure
		r2.setHauteur(Rectangle.MIN_VAL);
		assertTrue(r2.getHauteur() == Rectangle.MIN_VAL);
		// Trop haut
		r3.setHauteur(Rectangle.MAX_VAL + 1);
		assertTrue(r3.getHauteur() == 11);
		// Trop bas
		r4.setHauteur(Rectangle.MIN_VAL - 1);
		assertTrue(r4.getHauteur() == 3);
	}

	@Test
	public void testSetLargeur() {
		// Borne supérieure
		r1.setLargeur(Rectangle.MAX_VAL);
		assertTrue(r1.getLargeur() == Rectangle.MAX_VAL);
		// Borne inférieure
		r2.setLargeur(Rectangle.MIN_VAL);
		assertTrue(r2.getLargeur() == Rectangle.MIN_VAL);
		// Trop haut
		r3.setLargeur(Rectangle.MAX_VAL + 1);
		assertTrue(r3.getLargeur() == 7);
		// Trop bas
		r4.setLargeur(Rectangle.MIN_VAL - 1);
		assertTrue(r4.getLargeur() == 19);
	}

}
