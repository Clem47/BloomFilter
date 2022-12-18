/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bloomfilter;

/**
 *
 * @author ccrispel
 */
public abstract class AbstractBloomFilter {
    /**
     * Add value to bloom filter
     * @param number value to add
     */
    public abstract void add(int number);

    /**
     * Check if a value is contain 
     * @param number value to check
     * @return true if the value is contain
     */
    public abstract boolean contain(int number);
    
}
