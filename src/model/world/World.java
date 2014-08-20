package model.world;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class World {

	public ArrayList<Hex> world = new ArrayList<Hex>(); //lopullinen maailma joka piirret‰‰n ja joka on julkinen muille luokille
	
/*
 * Luokka luo ja piirt‰‰ pelikent‰n resources/kartta.txt datan mukaan.
 * Konstruktori kutsuu createMap metodia, joka lukee tiedostosta pelikent‰n(maailman) mallin ja tallentaa sen boardMap -muuttujaan.
 * boardMap datalla luodaan varsinainen hexa maailma, joka tallennetaan world -muuttujaan jossa sit‰ s‰ilytet‰‰n. 
 * Lopuksi world muuttujan datan persuteella maailma piirret‰‰n ruudulle.
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
		
		//2. try catch blocki, ei jaksa laittaa metodeja heitt‰m‰‰n poikkeuksia
		try {
			boardMap = loadMap("src/resources/kartta.txt"); //ladataan data boardMap muuttujaan tiedostosta
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		// 3. j=rivit, i=merkit yksitt‰isell‰ rivill‰
		for(int j=0; j<boardMap.size();j++){ 		//..rivien lkm (boardMap.size) = alkioiden lkm. 
			for(int i=0; i<boardMap.get(j).length(); i++){		//..merkkien lkm rivill‰ (alkion Stringin pituus .length)
				Character hexType = boardMap.get(j).charAt(i);	//tuodaan tietylt‰ rivilt‰, yksitt‰inen MERKKI hexType -muuttujaan
				world.add(new Hex(i, j, hexType.toString()));	//Luodaan uusi HEXa maailmaan, Character -merkki muutetaan Stringiksi ett‰ Hex konstructori hyv‰ksyy sen.
			}
		}
		world = convertEmptyHex(world);
		return world;
	}
	
	public ArrayList<Hex> convertEmptyHex(ArrayList<Hex> world){
		// 4. K‰yd‰‰n l‰pi maailman kaikki hexat. Mik‰li kartassa on tyhji‰ hexatyyppej‰ (type = " "), korvataan v‰lilyˆnti "null":lla selvyyden vuoksi.
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
			if(!world.get(i).getType().equals("null")){		//piirret‰‰n, mik‰li type EI ole "null"
				
				g.setColor(getColor(i));					//haetaan tyypin mukaan fillColor
				g.fillPolygon(world.get(i).getHex());			//piirret‰‰n hex objecti
				if(world.get(i).isSelected()){
					g.setColor(Color.RED);
				}
				else{
				g.setColor(Color.black);					//V‰ri vaihdetaan takaisin mustaksi
				}
				
				g.drawPolygon(world.get(i).getHex());			//piirret‰‰n polygoni uudestaan, ett‰ saadaan reunat mukaan
				
				int[]hexCenter=world.get(i).hexCenter();
					g.drawString(world.get(i).getType(),hexCenter[0],hexCenter[1]); //piirret‰‰n hexan tyyppi
			}
		}
	}

	private Color getColor(int i) {
		//Switch case ja jotenkin enumit t‰nne?
		//t‰m‰ elegantiksi
		
		if(world.get(i).getType().equals("b")){
		return Color.YELLOW;}
		else if(world.get(i).getType().equals("f")){
			return Color.GREEN;}
		else if(world.get(i).getType().equals("s")){
			return Color.BLUE;}
		return null;
	}
}
