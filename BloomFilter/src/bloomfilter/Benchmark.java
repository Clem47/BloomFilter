/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.io.File;
import java.io.FileWriter;
import static java.lang.Math.abs;
import java.util.Random;

/**
 *
 * @author ccrispel
 */
public class Benchmark {
     
    private final static int N = 10000;
    private final static int K = 5;
    private final static int TAB_VALUE = 7000;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random ran = new Random();
        try{
            FileWriter outputFile = new FileWriter("test.csv");
            outputFile.append("Iteration");
            outputFile.append(",");
            outputFile.append("Array");
            outputFile.append(",");
            outputFile.append("ArrayList");
            outputFile.append(",");
            outputFile.append("LinkedList");
            outputFile.append("\n");
            for(int i = 0; i< 1000; i++){
                int tab[] = new int[TAB_VALUE];
                for(int j = 0; j< tab.length-1; j++){
                    tab[j] = abs(ran.nextInt());
                    }
                outputFile.append(""+(i+1));
                outputFile.append(",");
                outputFile.append(""+ArrayBenchmark(tab));
                outputFile.append(",");
                outputFile.append(""+ArrayListBenchmark(tab));
                outputFile.append(",");
                outputFile.append(""+LinkedListBenchMark(tab));
                outputFile.append("\n");
            }
            outputFile.flush();
            outputFile.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static long ArrayBenchmark(int tab[]){
        AbstractBloomFilter bloomFilter = new BloomFilterArray(N,K);
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.add(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        //System.out.println("Array add : " + avg(timeTab) +" ns");
        
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.contain(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
    }
    
    private static long ArrayListBenchmark(int tab[]){
        AbstractBloomFilter bloomFilter = new BloomFilterArrayList(N,K);
        
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.add(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        //System.out.println("ArrayList add : " + avg(timeTab) +" ns");
        
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.contain(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
        
    }
    
    private static long LinkedListBenchMark(int tab[]){
        AbstractBloomFilter bloomFilter = new BloomFilterLinkedList(N,K);
       
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.add(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        //System.out.println("LinkedList add : " + avg(timeTab) +" ns");
        
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.contain(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
        
    }
    
    private static long avg(long tab[]){
        long val = 0;
        for( int i = 0; i< tab.length-1 ; i++){
            val += tab[i];
        }
        return val/TAB_VALUE;
    }
}
