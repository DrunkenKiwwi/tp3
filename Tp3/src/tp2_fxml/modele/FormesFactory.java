package tp2_fxml.modele;

import tp2_fxml.exception.FormeException;
import tp2_fxml.exception.ZoneDessinException;

public class FormesFactory {

	private int largeur = 0;
	private int hauteur = 0;

	public FormesFactory(int largeur, int hauteur) {
		if (validerDimension(largeur) && validerDimension(hauteur)) {
			setLargeur(largeur);
			setHauteur(hauteur);
		}
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public Forme getInstance(DataFactory data) throws FormeException, ZoneDessinException {
		Forme forme = null;
		if (validerFormeDansZone(data.getLargeur(), data.getHauteur(), data.getPosX(), data.getPosY())){
			forme = data.envoyerForme(data.getType());
		} else {
			throw new ZoneDessinException();
		}
		return forme;
	}

	private boolean validerDimension(int dim) {
		return (dim > 0);
	}

	private boolean validerFormeDansZone(int largeur, int hauteur, int posX, int posY) {
		return (validerX(largeur + posX) && validerY(hauteur + posY));
	}

	private boolean validerX(int x) {
		return ((x > 0) && (x < this.getLargeur()));
	}

	private boolean validerY(int y) {
		return ((y > 0) && (y < this.getHauteur()));
	}
}
