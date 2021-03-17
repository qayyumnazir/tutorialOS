
import java.util. *;
public class BestFit {
    
    public static void main(String[] args) {
        LinkedList<String> ll1 = new LinkedList<String>();
        ll1.add("J1 10");
        ll1.add("J2 20");
        ll1.add("J3 30");
        ll1.add("J4 10");
        int a = ll1.size();
        boolean[] adaxada2 = {false,false,false,false};
        String[] susun = new String[a];

        for(int i=0;i<a;i++)
        susun[i]=ll1.get(i);
        bubbleSortModified(susun);
       
        LinkedList<String> ll2 = new LinkedList<String>();
        ll2.add("A 30");
        ll2.add("B 15");
        ll2.add("C 50");
        ll2.add("D 20");
        int b = ll2.size();
        boolean[] adaxada = {false,false,false,false};
        String ayat;

        String[] susun2 = new String[b];

        for(int i=0;i<b;i++)
        {
        susun2[i]=ll2.get(i);
        //System.out.println(susun2[i]);
        }
       bubbleSortModified2(susun2);

       ll1.clear();
       ll2.clear();

       for(int i=0;i<a;i++)
       {
           ll1.add(susun[i]);
           ll2.add(susun2[i]);
       }


     
 
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

    static void bubbleSortModified(String arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) 
                if (Integer.parseInt(arr[j].substring(3,5)) > Integer.parseInt(arr[j+1].substring(3,5)) ) 
                { 
                    // swap arr[j+1] and arr[j] 
                    String temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    
            }
        }

        static void bubbleSortModified2(String arr[]) 
        { 
            int n = arr.length; 
            for (int i = 0; i < n-1; i++) 
                for (int j = 0; j < n-i-1; j++) 
                    if (Integer.parseInt(arr[j].substring(2,4)) > Integer.parseInt(arr[j+1].substring(2,4)) ) 
                    { 
                        // swap arr[j+1] and arr[j] 
                        String temp = arr[j]; 
                        arr[j] = arr[j+1]; 
                        arr[j+1] = temp; 
                    } 
        
                }
            }
