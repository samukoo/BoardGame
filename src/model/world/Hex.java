package model.world;
import java.awt.Polygon;

import javax.swing.JPanel;


public class Hex extends JPanel{
	private static final long serialVersionUID = 1L;
	private Polygon hex = new Polygon();
	private String type = null;
	private int r = 50; //hex:n sade
	private int[] xy = new int[2];
	public int[] xyId = new int[2]; //HEXan x ja y ID (EI PIXELI X&Y)
	private int[] xyDefault = {100,100}; //Hexan vakio siirtyma, etta kaikki hexat nakyy ruudulla
	private boolean selected = false;
	
	
	public Hex(int i, int j, String type){ //j = milla rivilla rivia? i = kuinka mones hexaa rivissa?
		createHex(i,j);
		
		this.xyId[0]=i;
		this.xyId[1]=j;
		this.type = type;
	}
	
	public void createHex(int i, int j){
		//x&y = hex:n kulman koordinaatit 
		//tehdaan hex
		for(int hi=0;hi<6;hi++){
			xy[0]=(int)(Math.round(r*Math.cos(Math.PI/6 + hi * Math.PI/3)));
			xy[1]=(int)(Math.round(r*Math.sin(Math.PI/6 + hi * Math.PI/3)));
			
			//erotettu x siirtyma ja rivisiirtyma erilliseksi ettei mene ihan sekavaksi 
			xy[0] = xy[0] +(int)(Math.round(i*2*r*Math.cos(Math.PI/6)));
			xy[1] = xy[1] + (int)(Math.round(j*3*r*Math.sin(Math.PI/6)));
			
			//jos pariton rivi niin lisataan koko rivin etenemaa
			if(j%2 != 0){
				xy[0] = xy[0] + (int)(r*Math.cos(Math.PI/6));
			}
			hex.addPoint(xy[0]+xyDefault[0],xy[1]+xyDefault[1]);
		}}

	
	public int[] hexHit(int x, int y){

		return (hex.contains(x,y) ? xyId : null );
	}	
	
	//laske hexan keskipisteen koordinaatit
	public int[] hexCenter(){
		int cX=0;
		int cY=0;
		int[] centerXY = new int[2];
		for(int list:hex.xpoints ){		//for each, lisataan muuttujaan kaikki hexan x-pointit
			cX+=list;
		}
		for(int list:hex.ypoints ){		//sama y pointeille
			cY+=list;
		}
		centerXY[0]=cX/6;				//ja tallennetaan keskiarvo (jaetaan kuudella)
		centerXY[1]=cY/6;
		return centerXY;
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

	public int getR() {
		return r;
	}

	public int[] getXyId() {
		return xyId;
	}
}
