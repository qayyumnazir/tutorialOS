
import java.util.LinkedList;
import java.util.Stack;



/**
 * FIFO
 */
public class FIFO {

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

        fifosim(2, a);
    }

    public static void fifosim(int size,LinkedList<String> a)
    {
        //creating the page frame
        String[] frame= new String[size];
        for(int i=0;i<size;i++)
        {
            frame[i]="Empty";
        }
        int num=0;
        int round=a.size();

        for(int i=0;i<round;i+=1)
        {
            //checking if there is an empty space - james arthur
            boolean masuk=false;
            for(int j=0;j<frame.length;j++)
            {
                if(frame[j].equals(a.peekLast()))
                {
                    a.removeLast();
                    masuk=true;
                    break;
                }
                

                if (frame[j].equalsIgnoreCase("empty"))
                {
                    frame[j]=a.removeLast();
                    masuk=true;
                    break;
                    
                }
            

            }
            if(!masuk)
            {
                    if(num>=size)num=0;
                    frame[num]=a.removeLast();
                    num++;
            }


            for(int l=0;l<size;l++)
            System.out.println(l+1+" is "+frame[l]);
            System.out.println("------------------");
        }


    }
}