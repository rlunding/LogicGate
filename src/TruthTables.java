

public class TruthTables {
	
	public TruthTables(){
		
	}
	
	public boolean OR(boolean A, boolean B){
		return A || B;
	}
	
	public boolean AND (boolean A, boolean B){
		return A && B;
	}
	
	public boolean NegAND (boolean A, boolean B){
		return !(A || B);
	}
	
	public boolean NOR (boolean A, boolean B){
		return !(A || B);
	}
	
	public boolean NAND (boolean A, boolean B){
		return !(A && B);
	}
	
	public boolean NegOR (boolean A, boolean B){
		return !(A && B);
	}
	
	public boolean XOR (boolean A, boolean B){
		return (A && !B) || (!A && B);
	}
	
	public boolean XNOR (boolean A, boolean B){
		return (A && B) || (!A && !B);
	}
}
