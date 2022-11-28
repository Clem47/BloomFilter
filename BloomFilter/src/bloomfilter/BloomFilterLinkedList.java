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
    
    public BloomFilterLinkedList(){
        myLinkedList = new LinkedList<>();
    }
    @Override
    public void add(int number){
    myLinkedList.add(Hash.hashArraySize(number, myLinkedList),true);
    myLinkedList.add(Hash.hashHashCode(number),true);
    myLinkedList.add(Hash.hashPrimaty(number),true );
    }
    @Override
    public boolean countain(int number){
        return false;
    }
}
