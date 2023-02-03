class Solution {
    public String convert(String s, int numRows) {
        
        int len = s.length();
        if(numRows==1)return s;
        StringBuilder res = new StringBuilder();
        int rotLen=2*numRows-2;
       for(int i = 1;i<=numRows;i++){
           
               Boolean down = true;
               int cdDown = rotLen - (i-1)*2;
               int cdUp = rotLen - cdDown;
               
               for(int j = i-1;j<s.length();){
                   res.append(s.charAt(j));
                   if(i==1||i==numRows){
                       j+=rotLen;
                   }else if(down){
                       j+=cdDown;
                       down = false;
                   }
                   else{
                       j+=cdUp;
                       down = true;
                   }
               }
           
       }
        return res.toString();
    }
}