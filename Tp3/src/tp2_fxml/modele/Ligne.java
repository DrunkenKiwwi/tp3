package tp2_fxml.modele;

import tp2_fxml.exception.FormeException;

public class Ligne extends Forme {

	int largeur = 1;
	int hauteur = 1;

	/**
	 * constructuer de la ligne
	 * 
	 * @param largeur
	 *            Largeur de la ligne
	 * @param hauteur
	 *            hauteur de la ligne
	 * @throws FormeException
	 */
	public Ligne(int largeur, int hauteur) throws FormeException {
		super("Ligne");
		if (validerparametre(largeur, hauteur)) {
			setHauteur(hauteur);
			setLargeur(largeur);
		} else {
			throw new FormeException();
		}

	}

	/**
	 * Méthode retournant la largeur de la ligne
	 * 
	 * @return
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Méthode assignant le parametre à la largeur de la ligne
	 * 
	 * @param largeur
	 *            largeur voulant etre assigner
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**
	 * Méthode retournant la hauteur de la ligne
	 * 
	 * @return
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * Méthode assignant le parametre à la largeur de la ligne
	 * 
	 * @param hauteur
	 *            hauteru voulant etre assigner à la ligne
	 */
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	private static final boolean validerparametre(int largeur, int hauteur) {
		return ((hauteur <= MAX_VAL) && (hauteur >= MIN_VAL) && (largeur <= MAX_VAL) && (largeur >= MIN_VAL));
	}

}
