
public class Punktezettel{
	
				
		private String _spielername;
	    private int[] _wert = new int[13]; // Alle Felder in die Etwas beim Spielen eingetragen werden kann

	    
	    
	    /*
	     * Konstruktor
	     * @Param spielername
	     */
	    public Punktezettel(String spielername){
	    	this._spielername = spielername;
	    }
	    
	    
	    /*
	     * Prüft für jedes Feld wieviele Punkte es bei dieser Würfelkombination geben würde und gibt das Feld mit dem höchsten Wert zurück
	     * @return Zahl des besten Feldes oder -1 falls kein Feld besetzt werden kann
	     */
	    public int gibBestesFeld(int[] augenzahlen){
	    	int besterWert = 0;
	    	int bestesFeld = -1;
	    	int aktuell = 0;
	    	
	    	for ( int i = 0; i < 13; i++ ) {		
	    		aktuell = berechneFeldwert( augenzahlen, i );
				//Größer gleich damit die schwerer zu erreichenden Felder zuerst besetzt werden, falls 2 Felder den selben Wert hätten
				if(aktuell >= besterWert){
					besterWert = aktuell;
					bestesFeld = i;
				}
			}
	    	
	    		return bestesFeld;
	    	
	    	
	    }
	    
	    /*
	     * Sucht das Feld mit dem höchsten Punktewert raus und trägt dort das Ergebnis ein
	     */
	    public boolean trageInBestesFeldEin(int[] augenzahlen){
	    	int feld = gibBestesFeld( augenzahlen );
	    	
	    	if(feld == -1){
	    		return false;
	    	}else{
	    		
	    	}
	    	int wert = berechneFeldwert( augenzahlen, feld );
	    	eintragen( wert, feld );
	    	return true;
	    }
	    
	    
	    /*
	     * Gibt zurück wieviele Punkte das Feld mit den angegebenen Augenzahlen wert ist
	     * @param augenzahlen 6 Würfelergebnsse
	     * @param feld Das Feld dessen Wert überprüft werden soll
	     */
	    public int berechneFeldwert(int[] augenzahlen, int feld){
	    	
	    	//Wenn bereits in dieses Feld eingetragen wurde gib ungünstigstes Ergebnis zurück
	    	if(_wert[feld] != 0){
	    		return 0;	
	    	}else{
	    		
	    		switch ( feld ) {
	    			
	    			// Die 6 oberen Felder
					case 0:
						return zaehleAugenzahlVorkommen( augenzahlen, 1 ) * 1;
					case 1:
						return zaehleAugenzahlVorkommen( augenzahlen, 2 ) * 2;
					case 2:
						return zaehleAugenzahlVorkommen( augenzahlen, 3 ) * 3;
					case 3:
						return zaehleAugenzahlVorkommen( augenzahlen, 4 ) * 4;
					case 4:
						return zaehleAugenzahlVorkommen( augenzahlen, 5 ) * 5;
					case 5:
						return zaehleAugenzahlVorkommen( augenzahlen, 6 ) * 6;
						
					// Die 7 unteren Felder
						
					// Dreierpasch
					case 6:
						if( zaehleAugenzahlVorkommen( augenzahlen, 1 ) >=3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 2 ) >=3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 3 ) >=3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 4 ) >=3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 5 ) >=3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 6 ) >=3 )
								{
								return summe(augenzahlen);
								}
							else
							{
								return 0;
							}
						
						
						// Viererpasch
					case 7:
						if( zaehleAugenzahlVorkommen( augenzahlen, 1 ) >=4 ||
							zaehleAugenzahlVorkommen( augenzahlen, 2 ) >=4 ||
							zaehleAugenzahlVorkommen( augenzahlen, 3 ) >=4 ||
							zaehleAugenzahlVorkommen( augenzahlen, 4 ) >=4 ||
							zaehleAugenzahlVorkommen( augenzahlen, 5 ) >=4 ||
							zaehleAugenzahlVorkommen( augenzahlen, 6 ) >=4 )
								{
								return summe(augenzahlen);
								}
							else
							{
								return 0;
							}
						
						// Full House
					case 8:
						if( (
							zaehleAugenzahlVorkommen( augenzahlen, 1 ) =3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 2 ) =3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 3 ) =3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 4 ) =3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 5 ) =3 ||
							zaehleAugenzahlVorkommen( augenzahlen, 6 ) =3) &&
						
							(
							zaehleAugenzahlVorkommen( augenzahlen, 1 ) =2 ||
							zaehleAugenzahlVorkommen( augenzahlen, 2 ) =2 ||
							zaehleAugenzahlVorkommen( augenzahlen, 3 ) =2 ||
							zaehleAugenzahlVorkommen( augenzahlen, 4 ) =2 ||
							zaehleAugenzahlVorkommen( augenzahlen, 5 ) =2 ||
							zaehleAugenzahlVorkommen( augenzahlen, 6 ) =2))
							{
							return 25;
							}
						else
						{
							return 0;
						}
						
						// Kleine Straße
					case 9:
						if( (
							zaehleAugenzahlVorkommen( augenzahlen, 3 )>=1 && 
							zaehleAugenzahlVorkommen( augenzahlen, 4 )>=1 && 
							
							(
							(
							zaehleAugenzahlVorkommen( augenzahlen, 1 )>=1 && 
							zaehleAugenzahlVorkommen( augenzahlen, 2 )>=1
							) ||
							(
							zaehleAugenzahlVorkommen( augenzahlen, 2 )>=1 && 
							zaehleAugenzahlVorkommen( augenzahlen, 5 )>=1
							) || 
							(
							zaehleAugenzahlVorkommen( augenzahlen, 5 )>=1 && 
							zaehleAugenzahlVorkommen( augenzahlen, 6 )>=1
							)
							)
							)
							{
							return 30;
							}
						else
						{
							return 0;
						}
						
						// Große Straße
						case 10:
							if(
								zaehleAugenzahlVorkommen( augenzahlen, 2 )==1 && 
								zaehleAugenzahlVorkommen( augenzahlen, 3 )==1 && 
								zaehleAugenzahlVorkommen( augenzahlen, 4 )==1 && 
								zaehleAugenzahlVorkommen( augenzahlen, 5 )==1 && 
								(
								zaehleAugenzahlVorkommen( augenzahlen, 1 )==1 || 
								zaehleAugenzahlVorkommen( augenzahlen, 6 )==1
							    )
							   )
								{
								return 30;
								}
							else
							{
								return 0;
							}
							
							// Kniffel
						case 11:
							if( zaehleAugenzahlVorkommen( augenzahlen, 1 ) ==5 ||
								zaehleAugenzahlVorkommen( augenzahlen, 2 ) ==5 ||
								zaehleAugenzahlVorkommen( augenzahlen, 3 ) ==5 ||
								zaehleAugenzahlVorkommen( augenzahlen, 4 ) ==5 ||
								zaehleAugenzahlVorkommen( augenzahlen, 5 ) ==5 ||
								zaehleAugenzahlVorkommen( augenzahlen, 6 ) ==5 )
									{
									return 50;
									}
								else
								{
									return 0;
								}
							
							// Chance
						case 12:							
								return summe(augenzahlen);
									
						
						
					default:
						return 0;
						
				}
	    		
	    	}
	    	
	    }
	    
	    /*
	     * Zählt wie oft eine gewisse Augenzahl vorkommt
	     */
	    private int zaehleAugenzahlVorkommen(int[] augenzahlen, int gesuchteZahl){
	    	int ergebnis = 0;
	    	for ( int i = 0; i < augenzahlen.length; i++ ) {
				if(augenzahlen[i] == gesuchteZahl){
					ergebnis++;
				}
			}
	    	return ergebnis;
	    }
	    
	    private int summe(int[] augenzahlen){
	    	int ergebnis = 0;
	    	for ( int i = 0; i < augenzahlen.length; i++ ) {
				ergebnis+= augenzahlen[i];
			}
	    	return ergebnis;
	    }
		
	    /*
	     * Ergebnis in ein Feld eintragen
	     */
	    public void eintragen(int zahl, int feld){
	    	_wert[feld] = zahl;
	    }
	    
	    /*
	     * @return Summe aller Felder mit Boni
	     */
	    public int berechnePunkteFuerSpiel(){
	    	int ergebnis = 0;
	    	for ( int i = 0; i < _wert.length; i++ ) {
	    		
				ergebnis += _wert[i];
				
				if(i == 5 && ergebnis >= 63){
					ergebnis += 35;
				}
			}
	    }
	    
	    /*
	     * @return Das Array aller 13 Felder
	     */
	    public int[] gibWerte(){
	    	return _wert;
	    }
	    
	    /*
	     * Setzt die Tabelle auf initialwerte zurück
	     */
	    public void resetteWerte(){
	    	for ( int i = 0; i < _wert.length; i++ ) {
				_wert[i] = 0;
			}
	    }
}
