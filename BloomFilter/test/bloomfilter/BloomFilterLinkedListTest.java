/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bloomfilter;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ccrispel
 */
public class BloomFilterLinkedListTest {
    
    public BloomFilterLinkedListTest() {
    }

    @Test
    public void testAdd() {
        int size = 1024;
        BloomFilterLinkedList test = new BloomFilterLinkedList(size);
        LinkedList array = test.getLinkedList();
        int val = 9;
        
        test.add(val);
       
        assertEquals(array.get(Hash.hashArraySize(val, array)),true);
        assertEquals(array.get(Hash.hashHashCode(val, array)),true);
        assertEquals(array.get(Hash.hashPrimaty(val, array)),true);
        
        val = 56982;
        
        test.add(val);
        
        assertEquals(array.get(Hash.hashArraySize(val, array)),true);
        assertEquals(array.get(Hash.hashHashCode(val, array)),true);
        assertEquals(array.get(Hash.hashPrimaty(val, array)),true);
        
        val = -5;
        
        test.add(val);
        
        assertEquals(array.get(Hash.hashArraySize(val, array)),true);
        assertEquals(array.get(Hash.hashHashCode(val, array)),true);
        assertEquals(array.get(Hash.hashPrimaty(val, array)),true);
        
        val= 5;
        
        assertEquals(array.get(Hash.hashArraySize(val, array)),false);
        assertEquals(array.get(Hash.hashHashCode(val, array)),false);
        assertEquals(array.get(Hash.hashPrimaty(val, array)),false);
        
    }
    
}
