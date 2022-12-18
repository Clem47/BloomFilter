/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.util.LinkedList;

/**
 *
 * @author ccrispel
 */
public class BloomFilterLinkedList extends AbstractBloomFilter {
    LinkedList<Boolean> myLinkedList;
    private final int K;
    
    public BloomFilterLinkedList(int size, int k){
        myLinkedList = new LinkedList<>();
        K = k;
        for (int i = 0 ;i < size; i++){
            myLinkedList.add(false);
        }
    }
    
    /**
     * Add value to bloom filter
     * @param number value to add
     */
    @Override
    public void add(int number){
        for(int i = 1; i <= K ; i++){
            myLinkedList.set(Hash.hashPrimaty(number, myLinkedList,i),true );
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
            isContain = isContain && myLinkedList.get(Hash.hashPrimaty(number,myLinkedList,i));
            i++;
        }
        return isContain;
    }
}
