 public class sort1
     {
    public static void main (String args[])
    {
        int arr[]={56,6,7,3,4,5};
        for (int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                int temp=0;
            
                if(arr[j]<arr[i])
                {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            System.out.println(arr[i]+"");
        }
    }
     }
