/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djshortpath;

/**
 *
 * @author DicksonHarleyMatthew
 */
public class DJShortPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        int[] meh = {1,2,3,4,6,9,11,12,16,22,24,25,30,33,42};
        Heap blah = new Heap(meh);
        
        blah.insert(2);
        
        int[] poo = blah.toArray();
        
        for (int i = 0; i < poo.length; i++) {
            System.out.println(poo[i]);
        }
        
    }
    
}

class Heap {
    // binary heap implementation
    private int[] sumArray;
    
//    public Heap(int n) {
//        
//        this.insert(n);
//    
//    }
    
    public Heap(int[] n) {
        
        sumArray = n;
        
//        int arLen = n.length;
//        for (int i = 0; i < arLen; i++) {
//            this.insert(n[i]);
//        }
        
    }
    
    public void insert(int n){
        
        int iNode;
        if ((sumArray.length % 2) == 0) iNode = (sumArray.length) / 2;
        else iNode = (sumArray.length - 1) / 2;
       
        int lastValue = n;  
        int[] tempArray = new int[(sumArray.length + 1)];
        
        if (iNode > 1) {
            while (n < sumArray[iNode]) {
                int tempInt = sumArray[iNode];
                sumArray[iNode] = n;
                if (lastValue < tempInt) lastValue = tempInt;
            } 
            iNode /= 2;
        }
        
        System.arraycopy(sumArray,0,tempArray,0,(tempArray.length - 1));
        tempArray[(tempArray.length - 1)] = lastValue;
        sumArray = tempArray.clone();
        
    }
    
    public int[] toArray() {
        return sumArray;
    }

}
