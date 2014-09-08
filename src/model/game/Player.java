package model.game;
import model.units.Tank;
/**
 * Pelaaja luokka. Tieto pelaajasta, ja hanen joukoista
 */
import model.units.Unit;

public class Player extends ArmyController {

	private int points = 5;
	
	
	public Player(String owner){
		super.setOwner(owner);
	}

	public int getPoints() {
		return points;
	}

	public void buyUnit(Tank mockTank) {
		
		try {
			this.points = checkPoints(points, mockTank);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
