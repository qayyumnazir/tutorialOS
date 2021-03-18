import java.util.LinkedList;
import java.util.Queue;

public class fifo_riel {

    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        int[]k = {1,3,0,3,5,6};
        int frame_capacity = 3;
        
        pageFault(k, q,frame_capacity);
    }

    public static void pageFault(int [] arr,Queue<Integer> q,int capacity){
        // for(int i:arr){
        //     a.add(i);
        // }

        int[] frame = new int[0];
        int page_fault = 0;
        int len = frame.length;

        for(int i=0;i<arr.length;i++){
            
            if(!q.contains(arr[i])){
                page_fault++;
                if(len < capacity){
                    q.add(arr[i]);
                    // System.out.println(len);
                }
                else{
                    q.remove();
                    q.add(arr[i]);
                }
                len++;
            }
            

        }
        System.out.println("The total page fault is: "+ page_fault);
        System.out.println("The final page is: "+q);

    }

}
