/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.io.FileWriter;
import java.util.Random;

/**
 *
 * @author ccrispel
 */
public class Benchmark {
     
    private final static int N = 6000;
    private final static int K = 5;
    private final static int TAB_VALUE = 30;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{

            //------------------------------------------------------------------------------
            
            FileWriter outputFileContain = new FileWriter("contain.csv");
            outputFileContain.append("Iteration");
            outputFileContain.append(";");
            outputFileContain.append("Array");
            outputFileContain.append(";");
            outputFileContain.append("ArrayList");
            outputFileContain.append(";");
            outputFileContain.append("LinkedList");
            outputFileContain.append("\n");

             //------------------------------------------------------------------------------

            FileWriter outputFileFalsePositive = new FileWriter("falsePositive.csv");
            outputFileFalsePositive.append("Iteration");
            outputFileFalsePositive.append(";");
            outputFileFalsePositive.append("False Positive");
            outputFileFalsePositive.append("\n");

            //------------------------------------------------------------------------------

            Benchmark.addBenchmark(outputFileContain, outputFileFalsePositive); 
            outputFileContain.flush();
            outputFileContain.close();

            outputFileFalsePositive.flush();
            outputFileFalsePositive.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * calculate time for 1 contain
     * @param i  i emme iteration
     * @param bloomFilter instace of bloomfilter that we check
     * @return time for 1 contain
     */
    private static long containBloomFilterBenchmark(int tab[], AbstractBloomFilter bloomFilter ){
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.contain(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
    }
    
    /**
     * calculate time for 1 add
     * @param i  i emme iteration
     * @param bloomFilter instace of bloomfilter that we check
     * @return time for 1 add
     */
    private static long addOnBloomFilterBenchmark(int tab[],AbstractBloomFilter bloomFilter){
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.add(tab[i]);
            timeTab[i] = System.nanoTime() - time;
        }
        return avg(timeTab); 
    }

    /**
     * calculate time for 1 add and do false positve
     * @param i  i emme iteration
     * @param bloomFilter instace of bloomfilter that we check
     * @param outputFileFalsePositive file were we write
     * @return time for 1 add
     */
    private static long addOnBloomFilterBenchmark(int tab[],AbstractBloomFilter bloomFilter, FileWriter outputFileFalsePositive ){
        long timeTab[] = new long[TAB_VALUE];
        for(int i = 0; i< tab.length-1; i++){
            long time = System.nanoTime();
            bloomFilter.add(tab[i]);
            timeTab[i] = System.nanoTime() - time;
            Benchmark.falsePositive(i+1, bloomFilter, outputFileFalsePositive); 
        }
        return avg(timeTab); 
    }

    /**
     * Add time off adds to an CSV
     * @param outputFileContain File for contains
     * @param outputFileFalsePositive file for false positive
     */
    private static void addBenchmark(FileWriter outputFileContain , FileWriter outputFileFalsePositive ){
        BloomFilterLinkedList bloomFilterLinkedList = new BloomFilterLinkedList(N,K);
        BloomFilterArrayList bloomFilterArrayList = new BloomFilterArrayList(N,K);
        BloomFilterArray bloomFilterArray = new BloomFilterArray(N,K);
        Random ran = new Random();
        try{
            FileWriter outputFileAdd = new FileWriter("add.csv");
            outputFileAdd.append("Iteration");
            outputFileAdd.append(";");
            outputFileAdd.append("Array");
            outputFileAdd.append(";");
            outputFileAdd.append("ArrayList");
            outputFileAdd.append(";");
            outputFileAdd.append("LinkedList");
            outputFileAdd.append("\n");
            for(int i = 0; i< 1000; i++){
               int tab[] = new int[TAB_VALUE];
                for(int j = 0; j< tab.length-1; j++){
                    //tab[j] = ran.nextInt();
                    tab[j] = j+1;
                }
                outputFileAdd.append(""+(i+1));
                outputFileAdd.append(";");
                outputFileAdd.append(""+addOnBloomFilterBenchmark(tab,bloomFilterArray));
                outputFileAdd.append(";");
                if(i == 0)
                    outputFileAdd.append(""+addOnBloomFilterBenchmark(tab,bloomFilterArrayList,outputFileFalsePositive));
                else
                    outputFileAdd.append(""+addOnBloomFilterBenchmark(tab,bloomFilterArrayList));
                outputFileAdd.append(";");
                outputFileAdd.append(""+addOnBloomFilterBenchmark(tab,bloomFilterLinkedList));
                outputFileAdd.append("\n");
                Benchmark.containBenchmark(tab, i,outputFileContain,bloomFilterArray,bloomFilterArrayList,bloomFilterLinkedList);
            }
            outputFileAdd.flush();
            outputFileAdd.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Add time off contain to an CSV
     * @param tab array with all values added
     * @param i i eme iteration
     * @param outputFileContain file were we write
     * @param bloomFilterArray instance of bloomfilter with array
     * @param bloomFilterArrayList instance of bloomfilter with array list
     * @param bloomFilterLinkedList instance of bloomfilter with linled list
     */
    private static void containBenchmark(int tab[], int i, FileWriter outputFileContain,  
                                        BloomFilterArray bloomFilterArray,  BloomFilterArrayList bloomFilterArrayList,
                                        BloomFilterLinkedList bloomFilterLinkedList  ){
        try{
            outputFileContain.append(""+(i+1));
            outputFileContain.append(";");
            outputFileContain.append(""+containBloomFilterBenchmark(tab,bloomFilterArray));
            outputFileContain.append(";");
            outputFileContain.append(""+containBloomFilterBenchmark(tab,bloomFilterArrayList));
            outputFileContain.append(";");
            outputFileContain.append(""+containBloomFilterBenchmark(tab,bloomFilterLinkedList));
            outputFileContain.append("\n");    
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    
    /**
     * Print the % off false positve contain in bloomfilter CSV
     * @param i  i emme iteration
     * @param bloomFilter instace of bloomfilter that we check
     * @param outputFileFalsePositive file were we write
     */
    private static void falsePositive(int i,AbstractBloomFilter bloomFilter , FileWriter outputFileFalsePositive){
        try{
            float cpt = 0;
            int nbTest = 50000;
            for(int j = 0 ; j < nbTest; j++){
                if(bloomFilter.contain(j)){
                    cpt += 1;
                }
            }
            cpt = ((cpt- i) /  nbTest) * 100;
            
            outputFileFalsePositive.append(""+(i));
            outputFileFalsePositive.append(";");
            outputFileFalsePositive.append(""+cpt);
            outputFileFalsePositive.append("\n"); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Do the average of time 
     * @param tab contain all the times
     * @return the average time 
     */
    private static long avg(long tab[]){
        long val = 0;
        for( int i = 0; i< tab.length-1 ; i++){
            val += tab[i];
        }
        return val/TAB_VALUE;
    }
}
