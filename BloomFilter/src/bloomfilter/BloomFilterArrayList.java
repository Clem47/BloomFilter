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
    }
    
    @Override
    public void add(int number){
        myListe.add(Hash.hashArraySize(number, myListe),true);
        myListe.add(Hash.hashHashCode(number),true);
        myListe.add(Hash.hashPrimaty(number),true );}
    @Override
    public boolean countain(int number){return false;}
}
