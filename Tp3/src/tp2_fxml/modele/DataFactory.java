package tp2_fxml.modele;

import javafx.scene.paint.Color;
import tp2_fxml.exception.FormeException;

public class DataFactory {
	private int largeur = 0;
	private int hauteur = 0;
	private int coteC = 0;
	private Color couleur = null;
	private int posX = 0;
	private int posY = 0;
	private String type = null;
	private double[] pointsTriangleX = new double[3];
	private double[] pointsTriangleY = new double[3];

	public DataFactory(int largeur, int hauteur, Color couleur, int posX, int posY, String type) {
		setLargeur(largeur);
		setHauteur(hauteur);
		setCouleur(couleur);
		setPosX(posX);
		setPosY(posY);
		setType(type);
	}

	public DataFactory(int largeur, int hauteur, int coteC, Color couleur, int posX, int posY, String type) {
		setLargeur(largeur);
		setHauteur(hauteur);
		setCoteC(coteC);
		setCouleur(couleur);
		setPosX(posX);
		setPosY(posY);
		setType(type);
		calculerPointsTriangle();
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

	public int getCoteC() {
		return coteC;
	}

	public void setCoteC(int coteC) {
		this.coteC = coteC;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double[] getPointsTriangleX() {
		return pointsTriangleX;
	}

	public double[] getPointsTriangleY() {
		return pointsTriangleY;
	}

	public void setPointsTriangle(double[] pointsX, double[] pointsY) {
		this.pointsTriangleX = pointsX;
		this.pointsTriangleY = pointsY;
	}

	private void calculerPointsTriangle() {
		double[] arrayX = new double[3];
		double[] arrayY = new double[3];
		int a = this.getLargeur();
		int b = this.getHauteur();
		int c = this.coteC;
		arrayX[0] = this.getPosX();
		arrayY[0] = this.getPosY();
		arrayX[1] = this.getPosX() + this.getLargeur();
		arrayY[1] = this.getPosY();
		double angle = Math
				.acos((Math.pow(a,2) + Math.pow(c,2) - Math.pow(b, 2))
						/ (2 * a * c));
		arrayX[2] = (int) (arrayX[1] - Math.cos(angle) * b);
		arrayY[2] = (int) (arrayY[1] - Math.sin(angle) * b);
		this.setPointsTriangle(arrayX, arrayY);
	}

	public Forme envoyerForme(String type) throws FormeException {
		Forme retour = null;
		switch (type) {
		case "Ligne":
			retour = new Ligne(getLargeur(), getHauteur());
			break;
		case "Ovale":
			retour = new Ovale(getLargeur(), getHauteur());
			break;
		case "Rectangle":
			retour = new Rectangle(getLargeur(), getHauteur());
			break;
		case "Triangle":
			retour = new Triangle(getLargeur(), getHauteur(), getCoteC());
			break;
		default:
			break;
		}
		return retour;
	}

}
