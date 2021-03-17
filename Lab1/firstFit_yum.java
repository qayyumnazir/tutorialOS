

/**
 * Hello
 */
import java.util. *;
public class FirstFit {

    public static void main(String[] args) {
       LinkedList<String> ll1 = new LinkedList<String>();
       ll1.add("J1 10");
       ll1.add("J2 20");
       ll1.add("J3 30");
       ll1.add("J4 10");
       int a = ll1.size();
       boolean[] adaxada2 = {false,false,false,false};
      
       LinkedList<String> ll2 = new LinkedList<String>();
       ll2.add("A 30");
       ll2.add("B 15");
       ll2.add("C 50");
       ll2.add("D 20");
       int b = ll2.size();
       boolean[] adaxada = {false,false,false,false};
       String ayat;
    

       LinkedList<String> ll3 = new LinkedList<String>();
       
       int j =0;


       for (int i=0;i < a;i++)
       {
           j=0;
           while (j<b)
           {
               
               int i1,i2;
               i1= Integer.parseInt(ll1.get(i).substring(3,5));
               i2= Integer.parseInt(ll2.get(j).substring(2,4));
               if(i1<i2 && adaxada[j]==false)
               {
                ayat= ll1.get(i).substring(0,3)+" is allocated in "+ll2.get(j).substring(0,2);
                ll3.add(ayat);
                adaxada[j]=true;
                adaxada2[i]=true;
                
                break;

               }
 
               j++;
               
           }
           
       }



       
       

       System.out.println(ll3.toString());
       


    }
}