class Solution {
    public int[][] reconstructQueue(int[][] people) 
    {
        int n=people.length;
        int index[]=new int[n];
        Arrays.sort(people,(int a[],int b[])->(a[0]-b[0]==0?b[1]-a[1]:a[0]-b[0]));
        Arrays.fill(index,-1);
        for(int i=0;i<n;i++)
        {
            int insert_ind=people[i][1];
            int c=0;
            for(int j=0;j<n;j++)
            {
                if(index[j]==-1)
                    insert_ind--;
                if(insert_ind<0)
                {
                    index[j]=i;
                    break;
                }
            }
        }
        int updated_arr[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
            updated_arr[i][0]=people[index[i]][0];
            updated_arr[i][1]=people[index[i]][1];
        }
        return updated_arr;
    }
}