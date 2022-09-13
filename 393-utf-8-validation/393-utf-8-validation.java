
class Solution {
    public boolean validUtf8(int[] data) {
    	int count=0;
    	for(int k : data) {
    		if (count==0) {
    			if ((k>>5)==0b110) count=1;
    			else if ((k>>4)==0b1110) count=2;
    			else if ((k>>3)==0b11110) count=3;
    			else if ((k>>7)==1) return false;
    		}
    		else {
    			if ((k>>6)!=0b10) return false;
    			count--;
    		}
    	}
    	return count==0;        
    }
}