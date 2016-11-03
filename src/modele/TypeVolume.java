package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public enum TypeVolume implements TypeMesure {

	LITRE("Litre (L)", 1), MILLILITRE("Millilitre (mL)", 0.001), GALLON("Gallon US (gal US)",
			3.785411784), PINTE("Pinte US (pt US fl)", 0.473176473), ONCE("Once US (fl oz)", 0.0295735295625);

	private String texte = null;
	// la base est le litre
	private double uniteVersBase = 0;

	private TypeVolume(String s, double d) {
		texte = s;
		uniteVersBase = d;
	}

	@Override
	public String toString() {
		return texte;
	}

	public double getUniteVersBase() {
		return uniteVersBase;
	}

	public static ObservableList<TypeMesure> getListeType() {
		ObservableList<TypeMesure> liste = FXCollections.observableArrayList();

		for (TypeVolume current : TypeVolume.values()) {
			liste.add(current);
		}

		return liste;
	}

}
