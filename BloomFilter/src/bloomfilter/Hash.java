/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;
import static java.lang.Math.abs;
import java.util.Collection;
import java.util.Random;

/**
 *
 * @author ccrispel
 */
public class Hash {
    
    private static int offset;
   
    private Hash(){
        Random rand = new Random();
        offset = rand.nextInt(10); 
    }
    
    public static int hashPrimaty(int number,Collection array, int k){
        return abs(((number*k + offset) %  97) % array.size());
    }
    
    public static int hashPrimaty(int number, boolean[] array, int k){
        return abs(((number*k + offset) %  97) % array.length);
    }
}
