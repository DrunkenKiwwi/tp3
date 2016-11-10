package convertisseur_fxml.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import convertisseur_fxml.modele.Distance;
import convertisseur_fxml.modele.Poids;
import convertisseur_fxml.modele.TypeDistance;
import convertisseur_fxml.modele.TypePoids;
import convertisseur_fxml.modele.TypeVolume;
import convertisseur_fxml.modele.Volume;

public class TypeMesureTest {
	private Poids poids;
	private Volume volume;
	private Distance distance;

	@Before
	public void setUp() throws Exception {
		poids = new Poids();
		volume = new Volume();
		distance = new Distance();
	}

	@Test
	public void test() {
		// 1 kilo vers grammes
		assertTrue(poids.getVersUnite(poids.setVersBase(1, TypePoids.KILOGRAMME), TypePoids.GRAMME) == 1000);
		// 1 pied vers pouces
		assertTrue(Math
				.round(distance.getVersUnite(distance.setVersBase(1, TypeDistance.PIED), TypeDistance.POUCE)) == 12);
		// 1 gallon vers pintes
		assertTrue(volume.getVersUnite(volume.setVersBase(1, TypeVolume.GALLON), TypeVolume.PINTE) == 8);
	}

}
