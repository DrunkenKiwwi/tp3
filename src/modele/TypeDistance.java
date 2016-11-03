package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public enum TypeDistance implements TypeMesure {

	KILOMETRE("Kilomètre (km)", 1000), METRE("Mètre (m)", 1), CENTIMETRE("Centimètre (cm)", 0.01), POUCE("Pouce (in)",
			0.0254), PIED("Pied (ft)", 0.3048), VERGE("Verge (yd)", 0.9144), MILLE("Mille (mi)", 1609.344);

	private String texte = null;
	// la base est le mètre
	private double uniteVersBase = 0;

	private TypeDistance(String s, double d) {
		texte = s;
		uniteVersBase = d;
	}

	public String toString() {
		return texte;
	}

	@Override
	public double getUniteVersBase() {
		return uniteVersBase;
	}
	
	public static ObservableList<TypeMesure> getListeType() {
		ObservableList<TypeMesure> liste = FXCollections.observableArrayList();

		for (TypeDistance current : TypeDistance.values()) {
			liste.add(current);
		}

		return liste;
	}

}
