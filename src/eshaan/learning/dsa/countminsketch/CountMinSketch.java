package eshaan.learning.dsa.countminsketch;

import java.util.Random;

public class CountMinSketch {
    private int[][] table;
    private int width;
    private int depth;
    private int[] hashA;
    private Random random;
    public CountMinSketch (int width, int depth){
        this.width = width;
        this.depth = depth;
        this.table = new int [depth][width];
        this.hashA = new int[depth];
        this.random = new Random();
        for(int i = 0; i<depth; i++){
            hashA[i]=random.nextInt(Integer.MAX_VALUE);
        }
    }

    private int hash(int item, int i){
        //compute initial hash code of the item using Java's built in function
        int hash = Integer.hashCode(item);
        //this line XORs the initial hash code with a random integer from the hashA array. Each ith hash function uses a different random integer to ensure variability.
        //XOR is a common technique used to mix values and spread out the hash codes.
        hash ^= hashA[i];
        //these lines below apply additionla bit manipulation to ensure the hash value is distributed
        //the right shift (>>> 16) spreads the higher bits into the lower bits. This technique, combined with multiplication by a large prime (0x45d9f3b), is used to achieve
        //avalance effect, where small change in the input produce significantly different hash values. This helps in reducing collisions.
        hash = (hash ^ (hash >>> 16)) * 0x45d9f3b;
        //Module opration ensures the hash value falls within the range [0, width-1]. The width represents the number of columns in the count-min Sketch table.
        //The modulo operation confines the hash value to this range
        hash = (hash ^ (hash >>> 16)) % width;
        //below code handle any negative values resulting from the previous module operation. If the hash value is negative adding width ensures it falls within the desired range.
        if(hash < 0){
            hash += width;
        }
        return hash;
    }

    public void add(int item){
        for (int i=0; i<depth; i++){
            int hashValue = hash(item, i);
            table[i][hashValue]++;
        }
    }

    public int estimateCount(int item){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<depth; i++){
            int hashValue = hash(item, i);
            min = Math.min(min, table[i][hashValue]);
        }
        return min;

    }

    public static void main(String[] args){
        //set width according to your memory constraint
        int width = 1000;
        //set depth according to desired accuracy
        int depth = 10;
        CountMinSketch cms = new CountMinSketch(width, depth);
        cms.add(42);
        cms.add(42);
        cms.add(56);
        System.out.println("Estimated count for 42: " + cms.estimateCount(42));
        System.out.println("Estimated count for 56: " + cms.estimateCount(56));
        System.out.println("Estimated count for 100: " + cms.estimateCount(100));
    }
}
