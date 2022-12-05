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
   
    private boolean tab[] = new boolean[2048];
    
    public BloomFilterArray(){
        for(int i = 0; i < tab.length-1; i++){
            tab[i] = false;
        }
    }
    
    @Override
    public void add(int number){
        tab[Hash.hashArraySize(number, tab)] = true;
        tab[Hash.hashHashCode(number, tab)] = true;
        tab[Hash.hashPrimaty(number, tab)] = true ;
    }
    
    @Override
    public boolean countain(int number){
        return tab[Hash.hashArraySize(number, tab)] &&
               tab[Hash.hashHashCode(number, tab)] && 
               tab[Hash.hashPrimaty(number, tab)];
    }
}
