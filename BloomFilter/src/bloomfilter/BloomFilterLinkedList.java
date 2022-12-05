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
    LinkedList myLinkedList;
    
    public BloomFilterLinkedList(int size){
        myLinkedList = new LinkedList<>();
        for (int i = 0 ;i < size; i++){
            myLinkedList.add(false);
        }
    }
    
    @Override
    public void add(int number){
        myLinkedList.set(Hash.hashArraySize(number, myLinkedList),true);
        myLinkedList.set(Hash.hashHashCode(number, myLinkedList),true);
        myLinkedList.set(Hash.hashPrimaty(number, myLinkedList),true );
    }
    
    @Override
    public boolean countain(int number){
        return myLinkedList.get(Hash.hashArraySize(number, myLinkedList)).equals(true) && 
                myLinkedList.get((Hash.hashHashCode(number,myLinkedList))).equals(true)&& 
                myLinkedList.get((Hash.hashPrimaty(number,myLinkedList))).equals(true);
    }
    
    public LinkedList getLinkedList(){
        return myLinkedList;
    }
}
