package model.units;

public enum UnitTypes {

	Tank,Infantry;

	public static UnitTypes fromString(String string) {

		UnitTypes res=null;
		for( UnitTypes item: UnitTypes.values()){
			res = item;
			if(string.equals(res.toString())){
				return res;
			}
		}
		return null;
	}
	
}
