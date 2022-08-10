/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_log;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    
//        System.out.println("encrypt message"+encrypt(53,59,200));
//        double en = encrypt(53,59,200) ; 
//         System.out.println( "decrypt message"+encrypt(53,59,en));

//       generateKey(17,11);
       
     //  a = in.nextLine();
//     a="hello";
//              int arr[]  = new int  [a.length()];
//       
//       for (int i=0; i < a.length() ; i++ ) 
//       {
//        System.out.println(Integer.valueOf(a.charAt(i)));
//        arr[i] = a.charAt(i); 
//        
//       }
//       for (int i=0; i < a.length() ; i++ ) 
//       {
//        System.out.print((char)(arr[i]+5));
//         
//        
//       }
      
   
    public  String encryptString(String msg )
    {
        double arr [] = new double[msg.length()] ; 
        double en [] = new double[msg.length()] ; 
        char ch [] = new char [msg.length()] ; 
        
        for (int i = 0 ; i < msg.length() ; i++)
        {
            arr[i] = Integer.valueOf(msg.charAt(i));
            
        }
         for (int i = 0 ; i < msg.length() ; i++)
        {
            en[i] = encrypt(79,83,arr[i]);
        }
         for (int i = 0 ; i < msg.length() ; i++)
        {
            ch[i] = (char)en[i];
           
        }
          msg = String.valueOf(ch) ; 
       return msg ; 
    }
   public  String decryptString(String msg )
    {
        double arr [] = new double[msg.length()] ; 
        BigInteger en [] = new BigInteger[msg.length()] ; 
        char ch [] = new char [msg.length()] ; 
        
        for (int i = 0 ; i < msg.length() ; i++)
        {
            arr[i] = Double.valueOf(msg.charAt(i));

        }
         for (int i = 0 ; i < msg.length() ; i++)
        {
            en[i] = decrypt(79,83,arr[i]);

        }
         for (int i = 0 ; i < en.length ; i++)
        {
            msg = String.valueOf(en[i]);
            ch[i] =(char)en[i].intValue();
            
           
        }
          msg = String.valueOf(ch) ; 
       return msg ; 
    }
   
   public  double  encrypt (int p , int q , double msg)
   {
       Scanner sc=new Scanner(System.in);
		int n,z,d=0,e,i;
		
		
		double c;
		BigInteger msgback; 
		
		
		n=p*q;
		z=(p-1)*(q-1);
		

		for(e=2;e<z;e++)
		{
			if(gcd(e,z)==1)            // e is for public key exponent
			{				
				break;
			}
		}
						
		for(i=0;i<=9;i++)
		{
			int x=1+(i*z);
			if(x%e==0)      //d is for private key exponent
			{
				d=x/e;
				break;
			}
		}
				
		c=(Math.pow(msg,e))%n;
              
                return c ; 

	}
   
 public  BigInteger  decrypt (int p , int q , double c)
   {
       Scanner sc=new Scanner(System.in);
		int n,z,d=0,e,i;
		
		

		BigInteger msgback; 
		
		
		n=p*q;
		z=(p-1)*(q-1);
		

		for(e=2;e<z;e++)
		{
			if(gcd(e,z)==1)            // e is for public key exponent
			{				
				break;
			}
		}
						
		for(i=0;i<=9;i++)
		{
			int x=1+(i*z);
			if(x%e==0)      //d is for private key exponent
			{
				d=x/e;
				break;
			}
		}
				
                                // decrypt 
                //converting int value of n to BigInteger
		BigInteger N = BigInteger.valueOf(n);
		//converting float value of c to BigInteger
		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		msgback = (C.pow(d)).mod(N);
		
                return msgback ; 

	}
	static int gcd(int e, int z)
	{
		if(e==0)
			return z;	
		else
			return gcd(z%e,e);
	}
}
    

    

