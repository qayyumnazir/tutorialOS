public class bankers {
    public static void main(String args[]){
        int numOfProcess = 5;
        int numOfResource = 3;
        int[] available = {3,3,2};
        boolean[] finish = new boolean[5];
        int[][] allocation = {{0,1,0},
                              {2,0,0},
                              {3,0,2},
                              {2,1,1},
                              {0,0,2}};
        int[][] max = {{7,5,3},
                       {3,2,2},
                       {9,0,2},
                       {2,2,2},
                       {4,3,3}};
        

        safety(numOfProcess, numOfResource, allocation, max, available, finish);
    }

    public static void calculateNeed(int numOfProcess, int numOfResource,int[][]max,int[][]allocation,int[][]need){
        for(int i=0;i<numOfProcess;i++){
            // System.out.print(work[i]);
            for(int j=0;j<numOfResource;j++){
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
        // for(int i=0;i<numOfProcess;i++){
        //     // System.out.print(work[i]);
        //     for(int j=0;j<numOfResource;j++){
        //         System.out.println(need[i][j]);
        //     }
        // }
    }

    public static void safety(int numOfProcess, int numOfResource, int[][] allocation,int[][] max, int[] available, boolean[] finish){
        int[] processFinalSequence = new int[numOfProcess];
        int[] work = available;
        for(int i=0;i<numOfResource;i++){
            finish[i] = false;
        }

        int[][] need = new int[numOfProcess][numOfResource];
        calculateNeed(numOfProcess, numOfResource, max, allocation,need);

        int index = 0;
        while(index < numOfProcess){
            boolean flag =  false;
            for(int i=0;i<numOfProcess;i++){
                if(finish[i] == false){
                    int j;
                    for(j=0;j<numOfResource;j++){
                        if(need[i][j] > work[j]){
                            break; // the process have to wait
                        }
                    }
                    if(j == numOfResource){
                        processFinalSequence[index++] = i;
                        finish[i] = true;
                        flag = true;
                        for(j=0;j<numOfResource;j++){
                            work[j] = work[j] + allocation[i][j];
                        }
                    }
                }
            }
            if(flag == false){
                break; // all process is safe
            }
        }

        if(index < numOfProcess){
            System.out.println("The system is not safe");
        }
        else{
            System.out.println("\nThe safe sequence is:");
            for(int i=0;i<numOfProcess;i++){
                System.out.print("Process "+processFinalSequence[i]+" --> ");
            }
            System.out.print("Done\n\n");
        }
    }
}
