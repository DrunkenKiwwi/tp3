package tp2_fxml.modele;

import tp2_fxml.exception.FormeException;

public class Ovale extends Forme {
	private int largeur = 1;
	private int hauteur = 1;

	/**
	 * Constructeur des cercles qui prend le rayon en paramÃ¨tre. Utilise le
	 * constructeur de Forme et donne le nom "Cercle"
	 * 
	 * @param largeur
	 *            largeur de l'ovale
	 * @param hauteur
	 *            hauteur de l'ovale
	 * @throws FormeException
	 *             si la hauteur ou la largeru n'est pas valide pas valide
	 */
	public Ovale(int largeur, int hauteur) throws FormeException {
		super("Ovale");
		if (validerHauteur(hauteur) && validerLargeur(largeur)) {
			setLargeur(largeur);
			setHauteur(hauteur);
		} else {
			throw new FormeException();
		}
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		if (validerLargeur(largeur)) {
			this.largeur = largeur;
		}
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		if (validerHauteur(hauteur)) {
			this.hauteur = hauteur;

		}
	}

	/**
	 * Donne le nom de l'ovale, sa largeur et sa hauteur
	 * 
	 * @return Nom, largeur et hauteur
	 */
	public String toString() {
		return ("Ovale de " + getLargeur() + " de largeur et de " + getHauteur() + " de hauteur");
	}

	/**
	 * Valide si la hauteur passée en paramètre est entre MIN_VAL et MAX_VAL
	 * 
	 * @param hauteur
	 *            hauteur à tester
	 * @return vrai si la valeur passée est entre MIN_VAL et MAX_VAL
	 */
	private static boolean validerHauteur(int hauteur) {
		return ((hauteur <= MAX_VAL) && (hauteur >= MIN_VAL));
	}
	/**
	 * Valide si la largeur passée en paramètre est entre MIN_VAL et MAX_VAL
	 * 
	 * @param largeur
	 *            largeur à tester
	 * @return vrai si la valeur passée est entre MIN_VAL et MAX_VAL
	 */
	private static boolean validerLargeur(int largeur) {
		return ((largeur <= MAX_VAL) && (largeur >= MIN_VAL));
	}
	


}
