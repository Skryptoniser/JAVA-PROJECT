
/**
 *
 * @author Loukik Khandare
 */
import java.util.*;
public class BloodRelation
{ int famSize, index1=-1,index2=-1;
int matrix[][];
Vector<Integer> v1 = new Vector<Integer>(20);
Vector<Integer> v2 = new Vector<Integer>(20);
    BloodRelation(int vex)
    {  
        this.famSize=vex;
        this.matrix=new int[vex][vex];
        for(int i=0;i<vex;i++)
    for(int j=0;j<vex;j++)
        
        matrix[i][j]=0;
    
    }

       void displayMatrix() 
    {
        for (int n = 0; n < famSize; n++) 
        {
            for (int m = 0; m < famSize; m++) 
            {
                System.out.print(matrix[n][m]+ "  ");
            }
            System.out.println();
        }
        System.out.println(v1);
        System.out.println(v2);
    }
    void connect(int source, int destination)
     {
        matrix[source-1][destination-1] = 1;
    }
    
    public void checkA(int a)
    { 
        
       int t1=0,cnt1=0;
         boolean condi1=true;
      while(condi1!=false)
         {
         for(int i=0;i<famSize;i++)//checking for a
       { 
               if(matrix[i][a]==1)
              {
                  if(cnt1==1)
                  {
                      v1.add(i);
                      index1++;
                      checkA(v1.lastElement());
                       
                      cnt1=-1;
                  }
                  else
                  { t1=i;
                  v1.add(a);
                      index1++;
                      v1.add(i);
                      index1++;
                      
                      cnt1++;
                      checkA(v1.lastElement());
                  }
                 }
       }
         if(cnt1==0)
           { condi1=false;
             v1.add(a);
           }
           if(cnt1==-1)
               break;
         
         
         
         }
    
     }
    
    
     public void checkB(int b)
   
     { 
       int t2=0,cnt2=0;
         boolean condi2=true;
     while(condi2!=false)
         {
         {
         for(int i=0;i<famSize;i++)//checking for b
       { 
               if(matrix[i][b]==1)
              {
                  if(cnt2==1)
                  {
                      v2.add(i);
                      index2++;
                      checkB(v2.lastElement());
                      cnt2=-1;
                  }
                  else
                  { t2=i;
                      
                  v2.add(b);
                  index2++;
                      
                      v2.add(i);
                      index2++;
                      cnt2++;
                      checkB(v2.lastElement());
                  }
                 
                 }
              
        }
         
           if(cnt2==0)
           { condi2=false;
               v2.add(b);
           }
      if(cnt2==-1)
               break;
     }
         }
       
     }
     
      void finalCheck()
     { boolean fin=false;
         if(v1.size()>v2.size())
     { 
         for(int i=0;i<v1.size();i++)
         {
         
         for(int j=0;j<v2.size();j++)
         {
         if(v2.get(j)==v1.get(i))
         {
             fin=true;
         break;
         }
         
         }
         if(fin==true)
             break;
         }
         
         }
         else
         {
         for(int i=0;i<v2.size();i++)
         {
         
         for(int j=0;j<v1.size();j++)
         {
         if(v1.get(j)==v2.get(i))
         {
             fin=true;
         break;
         }
         
         }
         if(fin==true)
             break;
         }
         }
         if(fin==true)
             System.out.println("They are blood relatives.");
         else
             System.out.println("They are not blood relatives.");
         }
     
     
    
    
    
    public static void main(String[] args)
    { Scanner sc=new Scanner(System.in);
        System.out.println("Enter Family Size.");
        
       BloodRelation br=new BloodRelation(sc.nextInt());//27
       
      br.connect(1,3);
      br.connect(2,3);
      br.connect(3,5);
      br.connect(4,5);
      br.connect(6,8);
      br.connect(7,8);
      br.connect(10,13);
      br.connect(11,13);
      br.connect(6,4);
      br.connect(7,4);
      br.connect(8,16);
      br.connect(9,16);
      br.connect(8,12);
      br.connect(9,12);
      br.connect(12,27);
      br.connect(13,27);
      br.connect(14,9);
      br.connect(15,9);
      br.connect(14,17);
      br.connect(15,17);
      br.connect(19,18);
      br.connect(20,18);
      br.connect(17,23);
      br.connect(18,23);
      br.connect(19,21);
      br.connect(20,21);
      br.connect(23,25);
      br.connect(24,25);
      br.connect(21,26);
      br.connect(22,26);    
      System.out.println("Enter two ids to be checked.");
      int a=sc.nextInt()-1;
      int b=sc.nextInt()-1;
         
      br.checkA(a);
      br.checkB(b);
    
  
      br.finalCheck();
    }
    
}
