//This is a calculator by Rishu Gupta.
//Any use other than intended will be considered as violation of rights
/** @author Rishu Gupta
 * @version 1.0
 * @year 2015
 */



import java.util.*;
public class Calculator
{
    double as[]=new double[41];
    char op[]=new char[40];
    int k,flag,restart;
    double result;
    Calculator()
    {
        k=0;result=0.0;
    }
    Scanner sc = new Scanner (System.in);
    public static void main()
    {
        System.out.println("Loading complete \nEnter \"Exit\" to exit \n********************************************************************\n 1-Make sure you dont use any spaces while calculating. \n 2-Dont use any brackets.Brackets are not supported \n 3-Works like a normal calculater.to get results use = and then press enter\n    ###################################################################################\n.For eg:\n3+3+3+3+3=\nResult=\t 12.0 "); 
      System.out.println("The sign convention is as follows:\n******************************************************\n '^' <Power\n '#' <Squareroot \n '+' <Add\n '-' <Subtract\n '/' <Division\n '*' <multiply");
      Calculator c1=new Calculator();
      do{
       c1.input_calc();
      if(c1.flag==1)
      break;
      if(c1.restart==1)
      continue;
       c1.process();
       c1.waite();
       c1.display();     
        }
        while(c1.flag!=1);
        System.out.println("Bhag Bhosdike");
    }
    
    
    
   private void input_calc()
    {
        k=0;restart=0;
        String s1="";
        System.out.println("Enter calculations:");
        String str=sc.nextLine();
        
        
       if(str.equalsIgnoreCase("Exit"))
       {
           flag=1;
          
        }
       int a=str.length();
       if(str.charAt(a-1)!='=')
       {
           System.out.println("LAPAR JHANDOOS HO KYA???");
           System.exit(0);
        }
        int ip=0;
       for (int i=0;i<a;i++)
       {
          
           char ch=str.charAt(i);
           if(ch!='+'&&ch!='-'&&ch!='/'&&ch!='*'&&ch!='='&&ch!='^'&&ch!='#')
           s1=s1+ch;
           else 
           {
               double temp=0.0;
               try{
               temp=Double.parseDouble(s1);
               as[ip]=temp;
               ip++;
             
               op[k]=ch;
               k++;
            }
            catch (NumberFormatException e)           
            {
                if(ch=='+'||ch=='-'||ch=='#')
                {
                   temp=0.0; 
                   as[ip]=temp;
               ip++;
             
               op[k]=ch;
               k++;
            }
            else 
            {
                System.out.println("Gand na Phulao");
                restart=1;
                break;}
            }
            
               s1="";
            }
        }
    }
    private void process()
    {
        
             for(int i=0;i<k;i++)
        {
            char ch=op[i];
            if(ch=='#')
            {
               int j=i+1;
               as[j]= Math.sqrt(as[j]);
               op[i]=' ';
            }
        }
        
             for(int i=0;i<k;i++)
        {
            char ch=op[i];
            if(ch=='^')
            {
                   int j=i+1;
              while(op[j]==' ')
              j++;
               as[j]= Math.pow(as[i],as[j]);
               as[i]=0.0;
               op[i]=' ';
            }
        }
        
        
        
        for(int i=0;i<k;i++)
        {
            char ch=op[i];
            if(ch=='/')
            {
                int j=i+1;
              while(op[j]==' ')
              j++;
               as[j]=as[i]/as[j];
               as[i]=0.0;
               op[i]=' ';
            }
        }
        
        
        
        for(int i=0;i<k;i++)
        {
            char ch=op[i];
            if(ch=='*')
            {
              int j=i+1;
              while(op[j]==' ')
              j++;
              as[j]=as[i]*as[j];
              as[i]=0.0;
              op[i]=' ';
            }
        }
        
         
            
        for(int i=0;i<k;i++)
        {
            char ch=op[i];
            if(ch=='+')
            {
                int j=i+1;
                while(op[j]==' ')
                j++;
                as[j]=as[i]+as[j];
                as[i]=0.0;
                op[i]=' ';
            }
        }
            
       
        for(int i=k;i>=0;i--)
        {
            char ch=op[i];
            if(ch=='-')
            {
                int j=i+1;
                while(op[j]==' ')
                j++;
                as[j]=as[i]-as[j];
                as[i]=0.0;
                op[i]=' ';
            }
        }
        
    }
    
    void waite()
    {
        try
        { System.out.print("Processing");
            for(int i=0;i<10;i++)
            {
            Thread.sleep(1000);
            System.out.print(".");
        }
        System.out.println();
        Thread.sleep(3000);  
        } 
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }
    void display()
    {
      
        for(int i=0;i<40;i++)
        {
            if(as[i]!=0.0)
            {
                double jj=Math.random();
                op[i]=' ';
                System.out.println ("Result  = \t"+as[i]);
                if (jj<=0.25)
                System.out.println("Itna nahi aata.");
                else
                if(jj>0.25&&jj<=0.5)
                System.out.println("That was so easy!!");
                else
                if(jj>0.5&&jj<=0.75)
                System.out.println("Yeh to sabko pata hai!!!");
                else
                System.out.println("Itne k liye kyu disturb kiya!!!!");
                break;
            }
        }
        
        
    }
               
}
