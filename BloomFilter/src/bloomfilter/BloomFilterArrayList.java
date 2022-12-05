/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.util.ArrayList;

/**
 *
 * @author ccrispel
 */
public class BloomFilterArrayList extends AbstractBloomFilter {
    ArrayList myListe;
    
    public BloomFilterArrayList(){
        myListe = new ArrayList<>();
        for (int i = 0 ;i < 2048; i++){
            myListe.add(false);
        }
    }
    
    @Override
    public void add(int number){
        myListe.set(Hash.hashArraySize(number, myListe),true);
        myListe.set(Hash.hashHashCode(number, myListe),true);
        myListe.set(Hash.hashPrimaty(number, myListe),true );
    }
  
    @Override
    public boolean countain(int number){
        return myListe.get(Hash.hashArraySize(number, myListe)).equals(true) && 
                myListe.get((Hash.hashHashCode(number,myListe))).equals(true)&& 
                myListe.get((Hash.hashPrimaty(number,myListe))).equals(true);
    }
}
