package model.world;
import java.awt.Polygon;

import javax.swing.JPanel;


public class Hex extends JPanel{
	private static final long serialVersionUID = 1L;
	private Polygon hex = new Polygon();
	private String type = null;
	private int r = 50; //hex:n s‰de
	private int[] xy = new int[2];
	private int[] xyId = new int[2]; //HEXan x ja y ID
	private int[] xyDefault = {100,100}; //Hexan vakio siirtym‰, ett‰ kaikki hexat n‰kyy ruudulla
	private boolean selected = false;
	
	
	public Hex(int i, int j, String type){ //j = mill‰ rivill‰ rivi‰? i = kuinka mones hexaa riviss‰?
		createHex(i,j);
		
		this.xyId[0]=i;
		this.xyId[1]=j;
		this.type = type;
	}
	
	public Hex(){
		
	}
	
	public void createHex(int i, int j){
		//x&y = hex:n kulman koordinaatit 
		//tehd‰‰n hex
		for(int hi=0;hi<6;hi++){
			xy[0]=(int)(Math.round(r*Math.cos(Math.PI/6 + hi * Math.PI/3)));
			xy[1]=(int)(Math.round(r*Math.sin(Math.PI/6 + hi * Math.PI/3)));
			
			//erotettu x siirtym‰ ja rivisiirtym‰ erilliseksi ettei mene ihan sekavaksi 
			xy[0] = xy[0] +(int)(Math.round(i*2*r*Math.cos(Math.PI/6)));
			xy[1] = xy[1] + (int)(Math.round(j*3*r*Math.sin(Math.PI/6)));
			
			//jos pariton rivi niin lis‰t‰‰n koko rivin etenem‰‰
			if(j%2 != 0){
				xy[0] = xy[0] + (int)(r*Math.cos(Math.PI/6));
			}
			hex.addPoint(xy[0]+xyDefault[0],xy[1]+xyDefault[1]);
		}
	}

	public int[] selectHex(int x,int y){
		//jos hiiren klikkauksen x&y on t‰m‰n hexan sis‰lle, aseta se valituksi
		setSelected(false);
		if(hex.contains(x, y)){
			setSelected(true);
			return xyId;
		}
		return null;
	}	
	
	public int[] hexHit(int x,int y){
		if(hex.contains(x, y)){
			return xyId;
			}
		else
			return null;
		
	}	
	
	//laske hexan keskipisteen koordinaatit
	public int[] hexCenter(){
		int cX=0;
		int cY=0;
		int[] centerXY = new int[2];
		for(int list:hex.xpoints ){		//for each, lis‰t‰‰n muuttujaan kaikki hexan x-pointit
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

	public void setR(int r) {
		this.r = r;
	}

	public int[] getXyId() {
		return xyId;
	}

	


}
