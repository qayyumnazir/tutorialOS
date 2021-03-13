import java.util.LinkedList;
import java.util.Queue;

public class LRU {
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();
        a.push("A");
        a.push("B");
        a.push("A");
        a.push("C");
        a.push("A");
        a.push("B");
        a.push("D");
        a.push("B");
        a.push("A");
        a.push("C");
        a.push("D");

        lruSim(2, a);
        
    }

    public static void lruSim(int size,LinkedList<String> a)
    {
        //creating the page frame
        String[] frame= new String[size];
        for(int i=0;i<size;i++)
        {
            frame[i]="Empty";
        }
        int num=0;
        int round=a.size();
        LinkedList<String> susunan= new LinkedList();

        for(int i=0;i<round;i+=1)
        {
            //checking if there is an empty space - james arthur
            boolean masuk=false;
            for(int j=0;j<frame.length;j++)
            {
                if(frame[j].equals(a.peekLast()))
                {
                    String k=a.removeLast();
                    masuk=true;
                    susunan.remove(susunan.indexOf(k));
                    susunan.add(k);

                    break;
                }
                

                if (frame[j].equalsIgnoreCase("empty"))
                {
                    frame[j]=a.removeLast();
                    masuk=true;
                    //update the susunan
                    susunan.add(frame[j]);
                    break;
                    
                }
            

            }
            if(!masuk)
            {
                String temp=susunan.peekFirst();
                for(int ii=0;ii<frame.length;ii++)
                {
                    if(frame[ii].contentEquals(temp))
                    {
                        frame[ii]=a.removeLast();
                        susunan.add(frame[ii]);
                        susunan.removeFirst();
                    }

                }
            }


            for(int l=0;l<size;l++)
            System.out.println(l+1+" is "+frame[l]);
            System.out.println(susunan);
            System.out.println("------------------");
        }


    }


    
}
