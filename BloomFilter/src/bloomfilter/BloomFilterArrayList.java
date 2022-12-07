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
        for (int i = 0 ;i < 2048; i++){
            myListe.add(false);
        }
    }
    
    @Override
    public void add(int number){
        for(int i = 1; i <= K ; i++){
            myListe.set(Hash.hashPrimaty(number, myListe,i),true );
        }
    }
    
    @Override
    public boolean contain(int number){
        boolean isContain = true;
        int i = 1;
        while(isContain && i <= K){
            isContain &= myListe.get((Hash.hashPrimaty(number,myListe,i)));
            i++;
        }
        return isContain;
    }
}
