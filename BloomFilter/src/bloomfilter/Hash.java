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
    
    public static int hashPrimaty(int number,Collection array){
        if (number < 0){
            return (((-number*A-B)*11) %  97) % array.size()  ;
        }
        return ((number*A-B) %  97) % array.size()  ;
    }
    
    public static int hashPrimaty(int number, boolean[] array){
        if (number < 0){
            return (((-number*A-B)*13) %  97) % array.length  ;
        }
        return ((number*A-B) %  97) % array.length;
    }
    
    
    public static int hashArraySize(int number , boolean[] array){
            if (number < 0){
            return ((-number*A-B)*13) % array.length  ;
        }
        return (number*A-B) % array.length;
    }
    
    public static int hashArraySize(int number ,Collection array){
        if (number < 0){
            return ((-number*A-B)*13) % array.size()  ;
        }
        return (number*A-B) % array.size();
    }
    
    public static int hashHashCode(int number,Collection array){
        if (number < 0){
            Integer myNumber = -number;
            return  (myNumber.hashCode()*13) % array.size();
        }
        Integer myNumber = number;
        return  myNumber.hashCode()% array.size();
    }
    
    public static int hashHashCode(int number, boolean[] array){
        if (number < 0){
            Integer myNumber = -number;
            return  (myNumber.hashCode()*13) % array.length;
        }
        Integer myNumber = number;
        return  myNumber.hashCode() % array.length ;
    }
}
