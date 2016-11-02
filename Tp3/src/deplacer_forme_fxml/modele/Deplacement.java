package deplacer_forme_fxml.modele;

public class Deplacement extends Thread {

	private static int dep = 1;
	private int depy = 0;
	private int depx = 0;

	public Deplacement(int x, int y) {
		setDepx(x);
		setDepy(y);
	}

	public void run() {
		
	}

	public int getDepy() {
		return depy;
	}

	public void setDepy(int depy) {
		this.depy = depy;
	}

	public int getDepx() {
		return depx;
	}

	public void setDepx(int depx) {
		this.depx = depx;
	}
	
	
	
	
}
