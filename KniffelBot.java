import java.io.DataInputStream; 
import Random; 
public class KniffelBot {

	#dies ist der künstliche Kniffel-Spieler. Er hat ein würfelErgebnis, dass aus dem Wurf entsteht
	#eine Heuristik, die für ihn die Entscheidungen trifft
	#und einen Punktezettel, der die Kombination aus Punkten und Feld verwaltet.
	
	/**
	* Instanzvariablen:
	*/

	private int[] _würfelErgebnis;
	private Heuristik _heur;
	private Punktezettel _zettel;
	private boolean _echteWürfel;
	private Scanner _s;
	private int _würfelZahl

	public void init(boolean echteWürfel){
		public int[] _würfelErgebnis= new int[6];
		Heuristik _heur= new Heuristik();
		Punktezettel _zettel = new Punktezettel();
		boolean _echteWürfel = echteWürfel;
		Scanner _s = new Scanner(System.in);
	}
	
	public void spiele(){
		#wenn es echteWürfel gibt, soll man auch dem Bot die Würfelergebnisse nennen können.
		if(_echteWürfel){
			for(int i;i<_würfelZahl;i++){
				System.out.prinln("Geben sie das "+ (i+1) +"te Würfelergebnis ein");
				_würfelErgebnis[i]=s.nextInt();
			}
			_heur.entscheide(_würfelErgebnis);
		}
		else{
			_heur.entscheide(würfeln());
		}

	}

	#Todo
	public int[] würfeln(){
		Random rand = new Random();
		int[] würfelErgebnis;
		for(int i; i < _würfelZahl; i++){
			würfelErgebnis[i]=rand.nextInt(6)+1
		}
		return würfelErgebnis;

	}



} 