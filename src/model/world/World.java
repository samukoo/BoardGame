package model.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class World implements iWorld{

	public ArrayList<Hex> world = new ArrayList<Hex>(); //lopullinen maailma joka piirretaan ja joka on julkinen muille luokille
	int hexID[]=new int[2];
/*
 * Luokka luo ja piirtaa pelikentan resources/kartta.txt datan mukaan.
 * Konstruktori kutsuu createMap metodia, joka lukee tiedostosta pelikentan(maailman) mallin ja tallentaa sen boardMap -muuttujaan.
 * boardMap datalla luodaan varsinainen hexa maailma, joka tallennetaan world -muuttujaan jossa sita sailytetaan. 
 * Lopuksi world muuttujan datan persuteella maailma piirretaan ruudulle.
 */
	
	public World(){
		createMap();  //Konstruktori kutsuu metodia joka huolehtii maailman luonnista
	}

	public ArrayList<String> loadMap(String mapFile) throws IOException{
		
		//Alustetaan file objektit
		File file = new File(mapFile);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String content=null;
		ArrayList<String>charMap = new ArrayList<String>();
		
		while((content = br.readLine())!=null){ //Luetaan rivi kerrallaan metodin charMap -muuttujaan 
			charMap.add(content);
		}
		br.close();		//suljetaan tiedosto
		return charMap;	//palautetaan charMap muuttuja (data tallentuu boardMap muuttujaan, josta aletaan louhimaan lopullinen hexakartta
	}
	
	public ArrayList<Hex> createMap() {
		//huom! voisi pilkkoa kahteen metodiin (" " -> "null" omaksi metodiksi)
		//1. luodaan varasto kartalle
		ArrayList<String>boardMap = new ArrayList<String>(); //boardmap on tiedostosta ladattu maailman malli
		
		//2. try catch blocki, ei jaksa laittaa metodeja heittamaan poikkeuksia
		try {
			boardMap = loadMap("src/resources/kartta.txt"); //ladataan data boardMap muuttujaan tiedostosta
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		// 3. j=rivit, i=merkit yksittaisella rivilla
		for(int j=0; j<boardMap.size();j++){ 		//..rivien lkm (boardMap.size) = alkioiden lkm. 
			for(int i=0; i<boardMap.get(j).length(); i++){		//..merkkien lkm rivilla (alkion Stringin pituus .length)
				Character hexType = boardMap.get(j).charAt(i);	//tuodaan tietylta rivilta, yksittainen MERKKI hexType -muuttujaan
				world.add(new Hex(i, j, hexType.toString()));	//Luodaan uusi HEXa maailmaan, Character -merkki muutetaan Stringiksi etta Hex konstructori hyvaksyy sen.
			}
		}
		world = convertEmptyHex(world);
		return world;
	}
	
	public ArrayList<Hex> convertEmptyHex(ArrayList<Hex> world){
		// 4. Kaydaan lapi maailman kaikki hexat. Mikali kartassa on tyhjia hexatyyppeja (type = " "), korvataan valilyönti "null":lla selvyyden vuoksi.
		for(int i = 0; i<world.size();i++){
			if(world.get(i).getType().equals(" ")){
				world.get(i).setType("null");
			}
		}
		return world;
	}
	
	//Piirtometodi
	public void drawWorld(Graphics g){
		for(int i= 0;i<world.size();i++){					//Maailman kokoinen piirtoloop
			if(!world.get(i).getType().equals("null")){		//piirretaan, mikali type EI ole "null"
				
				g.setColor(getColor(i));					//haetaan tyypin mukaan fillColor
				g.fillPolygon(world.get(i).getHex());			//piirretaan hex objecti
				g.setColor(world.get(i).isSelected() ? Color.RED : Color.BLACK); //jos hexa isSelected sitten Color.RED, muutoin color.BLACK 
				g.drawPolygon(world.get(i).getHex());			//piirretaan polygoni uudestaan, etta saadaan reunat mukaan

				int[]hexCenter=world.get(i).hexCenter();
					g.drawString(world.get(i).getType(),hexCenter[0],hexCenter[1]); //piirretaan hexan tyyppi
			}
		}
	}

	public Color getColor(int i) {
		//Switch case ja jotenkin enumit tanne?
		//tama elegantiksi
		
		if(world.get(i).getType().equals("b")){
		return Color.YELLOW;}
		else if(world.get(i).getType().equals("f")){
			return Color.GREEN;}
		else if(world.get(i).getType().equals("s")){
			return Color.BLUE;}
		return null;
	}

	//Haetaan hiiren pixeli koordinaatin mukaan ja kutsutaan setHex metodia, joka asettaa hexan is selected booleanin arvon "true". Palautetaan hexan koordinaatti
	public int[] selectHex(Point point){ 
		
		for(Hex selection:world){		
			hexID = selection.hexHit(point.x, point.y);
			if(hexID != null){
				setHex(hexID);
				return hexID;  //int[2] esim: int[3,3]
			}}
		return null;
		}
		
//	setHex metodi: tassa on kaytetty ns. ternary operaatiota, milla on korvattu if -rakenne.
//	esim: foo[0]==target.getXyId()[0] && foo[1]==target.getXyId()[1] tarkistaa etta hexan lokaatio matsaa
//	jos tama on true, target.setSelected metodi saa arvon true, muutoin false.
	public void setHex(int[] foo){
		for(Hex target:world)
			target.setSelected( foo[0]==target.getXyId()[0] && foo[1]==target.getXyId()[1] ? true:false);
	}

	@Override
	public int[] getHexCenterPosition(int[] hexID) {
		int res[] = new int[2];
		for(Hex testHex : world){
			if(testHex.xyId[0]==hexID[0] && testHex.xyId[1]==hexID[1])
				res = testHex.hexCenter();
		}
		return res;
	}

	@Override
	public boolean isNextHex(int[][]locations) {

		
		return true;
		
	}

	






}
