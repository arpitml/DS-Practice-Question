/**
* input: 3 (1 2 3)
* output: 5
*/


class Solution {
    public int numTrees(int n) {
        
        if(n == 0 || n == 1)
            return 1;
        if(n == 2)
            return 2;
        
        int[] numTree = new int[n+1];
        numTree[0] = 1;
        numTree[1] = 1;
        numTree[2] = 2;
    
        for(int num = 3; num <= n ; num++){
    int result = 0;        
            for(int i=0;i<num;i++){
                result = result + (numTree[i] * numTree[num-1-i]); 
            }
            numTree[num] = result;
        }
        return numTree[n];
    }
}
