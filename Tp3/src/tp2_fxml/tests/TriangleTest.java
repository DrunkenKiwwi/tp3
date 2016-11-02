package tp2_fxml.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tp2_fxml.exception.FormeException;
import tp2_fxml.modele.Forme;
import tp2_fxml.modele.Triangle;

public class TriangleTest {

	private Triangle t1, t2, t3, t4;

	@Before
	public void setUp() throws Exception {
		t1 = new Triangle(1, 1, 1);
		t2 = new Triangle(3, 4, 5);
		t3 = new Triangle(15, 7, 12);
		t4 = new Triangle(11, 23, 18);
	}

	@Test
	public void testCalculerSurface() {
		assertTrue(t1.calculerSurface() == 0);
		assertTrue(t2.calculerSurface() == 6);
		assertTrue(t3.calculerSurface() == 41);
		assertTrue(t4.calculerSurface() == 96);
	}

	@Test
	public void testCalculerPerimetre() {
		assertTrue(t1.calculerPerimetre() == 3);
		assertTrue(t2.calculerPerimetre() == 12);
		assertTrue(t3.calculerPerimetre() == 34);
		assertTrue(t4.calculerPerimetre() == 52);
	}

	@Test
	public void testToString() {
		
		assertTrue(t1.toString().equals("Triangle de 1 de largeur et de 1 de hauteur et avec un coté C de 1"));
		assertTrue(t2.toString().equals("Triangle de 3 de largeur et de 4 de hauteur et avec un coté C de 5"));
		assertTrue(t3.toString().equals("Triangle de 15 de largeur et de 7 de hauteur et avec un coté C de 12"));
		assertTrue(t4.toString().equals("Triangle de 11 de largeur et de 23 de hauteur et avec un coté C de 18"));
	}

	@Test
	public void testTriangle() {
		try {
			Triangle t5 = new Triangle(Forme.MIN_VAL - 1, 15, 15);
			fail();
		} catch (FormeException e) {
		}
		try {
			Triangle t6 = new Triangle(Forme.MAX_VAL + 1, 15, 15);
			fail();
		} catch (FormeException e) {
		}
		// Les autres côtés fonctionnent pareil
	}

	@Test
	public void testEstRectangle() {
		assertFalse(t1.estRectangle());
		assertTrue(t2.estRectangle());
		assertFalse(t3.estRectangle());
	}

	@Test
	public void testSetCoteA() {
		t1.setLargeur(21);
		assertTrue(t1.getLargeur() == 21);
		t2.setLargeur(Forme.MAX_VAL + 1);
		assertFalse(t2.getLargeur() == (Forme.MAX_VAL + 1));
		t2.setLargeur(Forme.MIN_VAL - 1);
		assertFalse(t2.getLargeur() == (Forme.MIN_VAL - 1));
	}

	@Test
	public void testSetCoteB() {
		t1.setHauteur(21);
		assertTrue(t1.getHauteur() == 21);
		t2.setHauteur(Forme.MAX_VAL + 1);
		assertFalse(t2.getHauteur() == (Forme.MAX_VAL + 1));
		t2.setHauteur(Forme.MIN_VAL - 1);
		assertFalse(t2.getHauteur() == (Forme.MIN_VAL - 1));
	}

	@Test
	public void testSetCoteC() {
		t1.setCoteC(21);
		assertTrue(t1.getCoteC() == 21);
		t2.setCoteC(Forme.MAX_VAL + 1);
		assertFalse(t2.getCoteC() == (Forme.MAX_VAL + 1));
		t2.setCoteC(Forme.MIN_VAL - 1);
		assertFalse(t2.getCoteC() == (Forme.MIN_VAL - 1));
	}

}
