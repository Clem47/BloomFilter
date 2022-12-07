/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

/**
 *
 * @author ccrispel
 */
public class BloomFilterArray extends AbstractBloomFilter {
   
    private boolean tab[];
    private final int K;
    
    public BloomFilterArray(int size, int k){
        tab = new boolean[size];
        K = k;
        for(int i = 0; i < tab.length-1; i++){
            tab[i] = false;
        }
    }
    
    @Override
    public void add(int number){
        for(int i = 1; i <= K ; i++){
            tab[Hash.hashPrimaty(number, tab,i)] = true ;
        }
    }
    
    @Override
    public boolean contain(int number){
        boolean isContain = true;
        int i = 1;
        while(isContain && i <= K){
            isContain &= tab[Hash.hashPrimaty(number, tab,i)];
            i++;
        }
        return isContain;
    }
}
