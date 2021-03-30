public class roundRobin_riel {
    public static void main(String []args){
        System.out.println("Assume the arrival time for all process is 0");
        int process[] = {1,2,3,4,5};
        int burstTime[] = {6,4,8,3,9};
        int timeSlice = 2; //time quantum

        findAverageTime(process, process.length, burstTime, timeSlice);
    }

    public static void waitingTime(int process[],int numOfProcess,int burstTime[],int waitTime[],int timeQuantum){
        int remainingBurstTime[] = new int[numOfProcess];
        for(int i=0;i<numOfProcess;i++){
            remainingBurstTime[i] = burstTime[i];
        }

        int time = 0;

        while(true){
            boolean processOver = true;
            for(int i=0;i<numOfProcess;i++){
                // must be bigger than 0 to start each process
                if(remainingBurstTime[i] > 0){
                    processOver = false;
                    if(remainingBurstTime[i] > timeQuantum){
                        time += timeQuantum;
                        remainingBurstTime[i] -= timeQuantum;
                    }
                    //the last quantum for the process
                    else{
                        time += remainingBurstTime[i];
                        waitTime[i] = time - burstTime[i];
                        remainingBurstTime[i] = 0;
                    }
                }
            }
            if(processOver == true){
                break; //the process is over
            }
        }
    }

    public static void turnAroundTime(int process[],int numOfProcess,int burstTime[],int waitTime[],int turnTime[]){
        for(int i=0;i<numOfProcess;i++){
            turnTime[i] = burstTime[i] + waitTime[i];
        }
    }

    public static void findAverageTime(int process[],int numOfProcess,int burstTime[],int timeQuantum){
        int waitTime[] = new int[numOfProcess];
        int turnTime[] = new int[numOfProcess];
        int total_waitingTime = 0;
        int total_turnAroundTime = 0;

        waitingTime(process, numOfProcess, burstTime, waitTime, timeQuantum);

        turnAroundTime(process, numOfProcess, burstTime, waitTime, turnTime);

        System.out.println("Process ID\tBurst time\tWaiting time\tTurn around time");

        for(int i=0;i<numOfProcess;i++){
            total_waitingTime += waitTime[i];
            total_turnAroundTime += turnTime[i];
            System.out.println(i+1+"\t\t"+burstTime[i]+"\t\t"+waitTime[i]+"\t\t"+turnTime[i]);
        }

        System.out.println("Average waiting time: "+total_waitingTime/numOfProcess);
        System.out.println("Average turn around time: "+total_turnAroundTime/numOfProcess);
    }
}
