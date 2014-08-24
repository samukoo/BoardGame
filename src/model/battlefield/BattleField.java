package model.battlefield;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.units.Infantry;
import model.units.Tank;
import model.units.Unit;
import model.world.Hex;
import model.world.World;

public class BattleField extends World {
//Luokan resurssit
	public ArrayList<Unit> unitList = new ArrayList(); 

	//konst.
	public BattleField(){
	}
	
	public ArrayList<Unit> addUnit(int[]xyHex, int[] xyLoc){
		unitList.add(new Tank(xyHex, xyLoc));
		return unitList;
	}
	
	public String moveUnit(int y, int x){
		//ELI T�SS� Y & X ON TARGET hexa
		//1: ei saa liikkua mereen
		// if(!getWorldType(y,x).equals("s")&& isNextHex(y, x)){  //T�m� IF lause m��ritt�� liikkumisen!
		int[]xYcoord = new int[2];
		
		for(int i=0; i<world.size();i++){ 		//1.for luuppi selvitt�� starttihexan 
			int[]xyID =world.get(i).getXyId();
			if(xyID[1] == y && xyID[0] == x){   //pieni kovakoodaus helpottamaan
				xYcoord = world.get(i).hexCenter();
			
			}
		}
		
		
		
		unitList.get(0).move(x, y, xYcoord);		//index nolla!

		System.out.println("X: " + unitList.get(0).getXyLoc()[0] + " Y: " + unitList.get(0).getXyLoc()[1]);
		
		return "ok";
		
		
		
		
	}
	
	public boolean isNextHex(int y, int x){
		//tarkistaa onko hexa vieress�?
		Hex startHex = new Hex();
			
			for(int i=0; i<world.size();i++){ 		//1.for luuppi selvitt�� starttihexan 
				int[]xyID =world.get(i).getXyId();
				if(xyID[1] == 3 && xyID[0] == 3){   //pieni kovakoodaus helpottamaan
					startHex= world.get(i);
				}
			}
				int[]centerXY = startHex.hexCenter();	//2. lasketaan start hexan xy keskipiste
				int result[][] = inspectHexBoard(centerXY);	//3. haetaan osumat hexan ymp�rilt�
				
				for(int i = 0; i<result.length; i++){		//4. t�m� palauttaa true mik�li arvioitava hexa on start hexan vieress�
				if(y==result[i][0] && x==result[i][1])
					return true;
				
				}
			return false;
		}
	
	public int[][] inspectHexBoard(int[]centerXY){	//t�ss� tehd��n n�kym�t�n hexa xy keskipisteen ymp�rille. sen kulmapisteiden avulla poimitaan hexan karttakoordinaatit
		int[][]res = new int[6][2];
		int counter = 0;
		int r = 65;
			for(int i=1; i<7; i++){
				int x = (int)(r*Math.cos(i*Math.PI/3) + centerXY[0]);
				int y = (int)(r*Math.sin(i*Math.PI/3) + centerXY[1]);
				
				for(int j = 0; j<world.size();j++){
					
					if(world.get(j).hexHit(x, y)!=null){
						res[counter] = world.get(j).hexHit(x, y);
						counter++;
						}
					}
				}
			return res;
		}
	
	public String getWorldType(int y, int x){
		for(int i = 0; i<world.size(); i++){
			
			int[]type = world.get(i).getXyId();
			
			if(type[1] == y && type[0] == x){
				return world.get(i).getType();
			}
		}
		return null;
	}
	
	public void drawUnits(Graphics g){
		
		for(int i = 0; i<unitList.size();i++){
		Unit unit = unitList.get(i);
		
		try {
			g.drawImage(unit.getImage(),
					
					unit.getXyLoc()[0]-unit.getImageDimension()[0]/2, // X lokaatio
					unit.getXyLoc()[1]-unit.getImageDimension()[1]/2, // Y lokaati
					null);	
			
		} catch (IOException e) {
			e.printStackTrace();}
		}
		
	}
}
