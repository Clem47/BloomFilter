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
    public abstract void add(int number);
    public abstract boolean countain(int number);
    
}
