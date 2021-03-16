import java.util.ArrayList;

public class firstFit_na {
    public static void main(String[] args){
        System.out.println("First Fit Process:");
        int partition[]={200, 700, 300, 100, 600};
        int job[]={212, 417, 112, 426, 200};
        int num_process=job.length; //num of process
        int num_block=partition.length; //slot of blocks

        firstfit(partition,job,num_process,num_block);
    }

    public static void firstfit(int partition[],int job[],int num_process,int num_block){
        ArrayList<Integer> block=new ArrayList<>();
        for(int i=0;i<num_process;i++){
            for(int j=0;j<num_block;j++){
                if(job[i]<=partition[j]){
                    block.add(i,j); //add at index i
                    partition[j]=-1;//remove block(cannot choose anymore)
                    break;
                }
                else
                    block.add(i,-1);//index not allocated
            }
        }
        System.out.println("\nProcess No.\tProcess Size\tBlock No.");
        for(int i=0;i<num_process;i++){
            System.out.print(""+(i+1)+"\t\t\t "+job[i]+"\t\t\t ");
            if (block.get(i)!=-1){
                System.out.print(block.get(i)+1);
            }
            else {
                System.out.print("It cannot be allocated");
            }
            System.out.println();
        }
    }
}