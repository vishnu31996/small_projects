import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String args[]) {
    	int numRows=5;
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        int con=1;
        for(int i=0;i<=numRows;i++)
        {
            List<Integer> li= new ArrayList<Integer>();

            if(i==0)
            {
                li.add(con);
                
            }else{
              List<Integer> temp= list.get(list.size()-1);
                
                     li.add(con);
                      int a=0;
                      int b=0;
                    for(int num:temp)
                    {
                        if(b==0)
                        {
                            b=num;
                        }else{
                            a=b;
                            b=num;
                        }
                       if(a!=0&&b!=0)
                       {
                           li.add(a+b);
                       }
                       
                           
                    }
                     li.add(con);
                
                
            
            }
            list.add(li);
        }
    System.out.println(list);
        
    }
}