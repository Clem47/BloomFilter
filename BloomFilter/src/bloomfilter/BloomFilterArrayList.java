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
    ArrayList<Boolean> myListe;
    private final int K;
    
    public BloomFilterArrayList(int size, int k){
        myListe = new ArrayList<>();
        K = k;
        for (int i = 0 ;i < size; i++){
            myListe.add(false);
        }
    }
    
     /**
     * Add value to bloom filter
     * @param number value to add
     */
    @Override
    public void add(int number){
        for(int i = 1; i <= K ; i++){
            myListe.set(Hash.hashPrimaty(number, myListe,i),true );
        }
    }
    
     /**
     * Check if a value is contain 
     * @param number value to check
     * @return true if the value is contain
     */
    @Override
    public boolean contain(int number){
        boolean isContain = true;
        int i = 1;
        while(isContain && i <= K){
            isContain = isContain && myListe.get((Hash.hashPrimaty(number,myListe,i)));
            i++;
        }
        return isContain;
    }
}
