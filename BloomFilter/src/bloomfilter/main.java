/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

/**
 *
 * @author ccrispel
 */
public class main {
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractBloomFilter bloomArrayList = new BloomFilterArrayList();
        AbstractBloomFilter bloomArray = new BloomFilterArray();
        AbstractBloomFilter bloomLinkedList = new BloomFilterLinkedList();
        bloomArrayList.add(9456);
        bloomArrayList.add(85);
        bloomArray.add(8562);
        bloomArray.add(2);
        bloomLinkedList.add(2048);
        bloomLinkedList.add(56);
       
        System.out.println("--------------------Array List-------------------");
        System.out.println(bloomArrayList.countain(9456));
        System.out.println(bloomArrayList.countain(85));
        System.out.println(bloomArrayList.countain(5));
        System.out.println("-----------------------Tableau----------------");
        System.out.println(bloomArray.countain(8562));
        System.out.println(bloomArray.countain(2));
        System.out.println(bloomArray.countain(2048));
        System.out.println("--------------------Linked List-------------------");
        System.out.println(bloomLinkedList.countain(2048));
        System.out.println(bloomLinkedList.countain(2));
        System.out.println(bloomLinkedList.countain(56));
    }
}
