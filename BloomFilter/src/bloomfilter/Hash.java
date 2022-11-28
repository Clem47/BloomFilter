/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;
import java.util.Collection;

/**
 *
 * @author ccrispel
 */
public class Hash {
    
    private static final int A = 11;
    private static final int B = 3;
    
    private Hash(){};
    
    public static int hashPrimaty(int number){
        return (number*A-B) %  97;
    }
    
    public static int hashArraySize(int number , boolean[] array){
        return (number*A-B) % array.length;
    }
    
    public static int hashArraySize(int number ,Collection array){
        return (number*A-B) % array.size();
    }
    
    public static int hashHashCode(int number){
        Integer myNumber = number;
        return  myNumber.hashCode();
    }
}
