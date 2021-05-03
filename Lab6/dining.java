import java.util.Random;
// import java.util.concurrent.Semaphore;

public class dining {
    public static void main(String args[]){
        Philosopher philosophers[] = new Philosopher[5];
        Semaphore forks[] = new Semaphore[philosophers.length];

        // create forks and assign to array
        for(int i=0;i<forks.length;i++){
            forks[i] = new Semaphore(1);
        }

        // create five philosophers
        for(int i=0;i<philosophers.length;i++){
            philosophers[i] = new Philosopher(i, forks);
            philosophers[i].start();
            // System.out.println(i);
            // philosophers[i].stops();
        }

        // for(int i=0;i<philosophers.length;i++){
        //     philosophers[i].stops();
        // }
        // System.out.println("All stop eating");
    }
}

// public class Philosopher implements Runnable {
//     private Object rightFork;
//     private Object leftFork;

//     public Philosopher(Object rightFork, Object leftFork){
//         this.rightFork = rightFork;
//         this.leftFork = leftFork;
//     }

//     public void run(){

//     }

//     public void do(String work) throws Exception {
//         System.out.print(Thread);
//     }
// }

class Semaphore {
    private int fork;

    public Semaphore(int fork){
        this.fork = fork;
    }

    public synchronized void pickFork(){
        while(fork == 0){
            try{
                System.out.println("Fork is in use");
                // wait until semaphore is free(the thread action)
                wait();
            }catch(InterruptedException e){

            } //thrown when the thread is waiting
        }
        fork--;
    }

    public synchronized void putFork(){
        fork++;
        notify();
    }
}

class Philosopher extends Thread{
    private int philo_forkID;
    private Semaphore forks[];

    private boolean exit;

    public Philosopher(int philo_forkID, Semaphore forks[]){
        this.philo_forkID = philo_forkID;
        this.forks = forks;
        exit = false;
    }

    public void run(){
        while(!exit){
            System.out.println("Philosophers "+philo_forkID+" is thinking");
            try{
                Thread.sleep(new Random().nextInt(1000)+50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Philosopher "+philo_forkID+" is hungry");

            forks[philo_forkID].pickFork();
            System.out.println("Philosoper "+philo_forkID+" pick up the fork "+philo_forkID);

            forks[(philo_forkID+1)%5].pickFork();
            System.out.println("Philosopher "+philo_forkID+" pick up the fork "+(philo_forkID+1)%5);

            System.out.println("Philosopher "+philo_forkID+" is eating");

            try{
                Thread.sleep(new Random().nextInt(1000)+50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            forks[philo_forkID].putFork();
            System.out.println("Philosopher "+philo_forkID+" put down the fork "+philo_forkID);
            
            forks[(philo_forkID+1)%5].putFork();
            System.out.println("Philosopher "+philo_forkID+" put down the fork "+(philo_forkID+1)%5);
        }
    }

    public void stops(){
        exit = true;
        try{
            Thread.sleep(3000);
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        // System.out.println("All stop eating");
    }
}