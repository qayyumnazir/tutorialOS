import java.util.ArrayList;

public class bestFit_na{
    public static void main(String[] args){
        System.out.println("First Fit Process:");
        int partition[]={200, 700, 300, 100, 600};
        int job[]={212, 417, 112, 426, 200};
        int num_process=job.length; //number of process
        int num_block=partition.length; //slot of blocks

        bestfit(partition,job,num_process,num_block);
    }

    public static void bestfit(int partition[],int job[],int num_process,int num_block){
        ArrayList<Integer> block=new ArrayList<>();
        for(int i=0;i<num_process;i++){
            int best=-1; //do the checking start with 0
            for(int j=0;j<num_block;j++){
                if(job[i]<=partition[j]) {
                    if (best == -1) {
                        best = j;
                    } else if (partition[best] > partition[j]) { //choose the smaller block size
                        best = j;
                    }
                }
            }
            if(best != -1){
                block.add(i,best); //add at index i
                partition[best] =-1; //remove block(cannot choose anymore)
            }
            else
                block.add(i,-1); //index not allocated
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