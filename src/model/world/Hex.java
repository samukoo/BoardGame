package model.world;
import java.awt.Polygon;

import javax.swing.JPanel;


public class Hex extends JPanel{
	private static final long serialVersionUID = 1L;
	private Polygon hex = new Polygon();
	private String type = null;
	private int r = 50; //hex:n s‰de
	private int x,y, xId,yId; //hex:n keskipiste ja etenem‰ sek‰ HEXan x ja y ID
	private int xDefault = 100; //Hexan vakio siirtym‰, ett‰ kaikki hexat n‰kyy ruudulla
	private int yDefault = 100;
	private boolean selected = false;
	
	public Hex(int i, int j, String type){
		//i = kuinka mones hexaa riviss‰?
		//j = mill‰ rivill‰ rivi‰?
		createHex(i,j);
		this.xId=i;
		this.yId=j;
		this.type = type;
	}
		
	public void createHex(int i, int j){
		//x&y = hex:n kulman koordinaatit 
		//tehd‰‰n hex
		for(int hi=0;hi<6;hi++){
			x=(int)(Math.round(r*Math.cos(Math.PI/6 + hi * Math.PI/3)));
			y=(int)(Math.round(r*Math.sin(Math.PI/6 + hi * Math.PI/3)));
			
			//erotettu x siirtym‰ ja rivisiirtym‰ erilliseksi ettei mene ihan sekavaksi 
			x = x +(int)(Math.round(i*2*r*Math.cos(Math.PI/6)));
			y = y + (int)(Math.round(j*3*r*Math.sin(Math.PI/6)));
			
			//jos pariton rivi niin lis‰t‰‰n koko rivin etenem‰‰
			if(j%2 != 0){
				x = x + (int)(r*Math.cos(Math.PI/6));
			}
			hex.addPoint(x+xDefault,y+yDefault);
		}
	}

	public void selectHex(int x,int y){
		//jos hiiren klikkauksen x&y on t‰m‰n hexan sis‰lle, aseta se valituksi
		setSelected(false);
		if(hex.contains(x, y)){
			setSelected(true);
			System.out.println(" Y: " + yId + " x: "+xId);
		}
	}	
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getxId() {
		return xId;
	}

	public int getyId() {
		return yId;
	}
	
	public int getxDefault() {
		return xDefault;
	}

	public int getyDefault() {
		return yDefault;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Polygon getHex() {
		return hex;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}




}
