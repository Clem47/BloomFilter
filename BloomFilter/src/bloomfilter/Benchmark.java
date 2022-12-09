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
        try{
            FileWriter outputFileContain = new FileWriter("contain.csv");
            outputFileContain.append("Iteration");
            outputFileContain.append(",");
            outputFileContain.append("Array");
            outputFileContain.append(",");
            outputFileContain.append("ArrayList");
            outputFileContain.append(",");
            outputFileContain.append("LinkedList");
            outputFileContain.append("\n");
            Benchmark.addBenchmark(outputFileContain); 
            outputFileContain.flush();
            outputFileContain.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static long containArrayBenchmark(int tab[]){
        AbstractBloomFilter bloomFilter = new BloomFilterArray(N,K);
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.contain(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
    }
    
    private static long containArrayListBenchmark(int tab[]){
        AbstractBloomFilter bloomFilter = new BloomFilterArrayList(N,K);
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.contain(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
        
    }
    
    private static long containLinkedListBenchmark(int tab[]){
        AbstractBloomFilter bloomFilter = new BloomFilterLinkedList(N,K);
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.contain(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
    }
    
        private static long addArrayBenchmark(int tab[]){
        AbstractBloomFilter bloomFilter = new BloomFilterArray(N,K);
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.add(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
    }
    
    private static long addArrayListBenchmark(int tab[]){
        AbstractBloomFilter bloomFilter = new BloomFilterArrayList(N,K);
        
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.add(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
        
    }
    
    private static long addLinkedListBenchmark(int tab[]){
        AbstractBloomFilter bloomFilter = new BloomFilterLinkedList(N,K);
       
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.add(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
    }
    
    
    private static void addBenchmark(FileWriter outputFileContain ){
        Random ran = new Random();
        try{
            FileWriter outputFileAdd = new FileWriter("add.csv");
            outputFileAdd.append("Iteration");
            outputFileAdd.append(",");
            outputFileAdd.append("Array");
            outputFileAdd.append(",");
            outputFileAdd.append("ArrayList");
            outputFileAdd.append(",");
            outputFileAdd.append("LinkedList");
            outputFileAdd.append("\n");
            for(int i = 0; i< 1000; i++){
                int tab[] = new int[TAB_VALUE];
                for(int j = 0; j< tab.length-1; j++){
                    tab[j] = abs(ran.nextInt());
                    }
                outputFileAdd.append(""+(i+1));
                outputFileAdd.append(",");
                outputFileAdd.append(""+addArrayBenchmark(tab));
                outputFileAdd.append(",");
                outputFileAdd.append(""+addArrayListBenchmark(tab));
                outputFileAdd.append(",");
                outputFileAdd.append(""+addLinkedListBenchmark(tab));
                outputFileAdd.append("\n");
                Benchmark.containBenchmark(tab, i,outputFileContain);
            }
            outputFileAdd.flush();
            outputFileAdd.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static void containBenchmark(int tab[], int i, FileWriter outputFileContain ){
        try{
            outputFileContain.append(""+(i+1));
            outputFileContain.append(",");
            outputFileContain.append(""+addArrayBenchmark(tab));
            outputFileContain.append(",");
            outputFileContain.append(""+addArrayListBenchmark(tab));
            outputFileContain.append(",");
            outputFileContain.append(""+addLinkedListBenchmark(tab));
            outputFileContain.append("\n");    
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    
    private static long avg(long tab[]){
        long val = 0;
        for( int i = 0; i< tab.length-1 ; i++){
            val += tab[i];
        }
        return val/TAB_VALUE;
    }
}
