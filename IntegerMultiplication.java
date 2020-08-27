package IntergerMultiplication;

import java.math.BigInteger;

public class IntegerMultiplication {
    
    public static BigInteger pow(int a, int b) {
        if (b == 0) return BigInteger.valueOf(1);
        else if (b == 1) return BigInteger.valueOf(a);
        else {
            BigInteger result = BigInteger.valueOf(a);
            while (b > 1) {
                result = result.multiply(BigInteger.valueOf(a));
                b--;
            }
            return result;
        }
        
    }
    private static int numOfDigits(BigInteger a) {
        int i = 0;
        while (!a.equals(BigInteger.valueOf(0))) {
            a = a.divide(BigInteger.valueOf(10));
            i++;
        }
        return i;
    }
    // x*y = 10^n*ac +10^n/2*(ad+bc)+ bd
    // (ad+bc) called adAddbc
    public static BigInteger intergerMulti(int n, BigInteger x, BigInteger y) {
                
        if (n == 1) {
            
            
                System.out.println("x: " + x + " y: " + y);
                return x.multiply(y);
            
        }
        else {
            
            BigInteger [] aAndB = x.divideAndRemainder(pow(10,n/2));
            BigInteger [] cAndD = y.divideAndRemainder(pow(10,n/2));
            BigInteger a = aAndB[0];
            BigInteger b= aAndB[1];
            BigInteger c = cAndD[0];
            BigInteger d = cAndD[1];
            
            BigInteger ac = intergerMulti(n/2,a,c);
            BigInteger bd = intergerMulti(n/2,b,d);
            
            BigInteger aPlusB = a.add(b);
            BigInteger cPlusD = c.add(d);
            
//            int n1 = numOfDigits(aPlusB);
//            int n2 = numOfDigits (cPlusD);
//            System.out.println("n1: " + n1 + " n2: " + n2);
//            int num = 0;
//            if (n1 > n2) 
//                num = n1;
//            else num = n2;
            
            BigInteger adAddbc =  (intergerMulti(n/2,aPlusB, cPlusD).subtract(ac)).subtract(bd);
//            
            return (ac.multiply(pow(10,n)).add(adAddbc.multiply(pow(10,n/2)))).add(bd);
            
        }
        
    }
    public static void main (String []args) {
       
       
        //BigInteger a = new BigInteger ("3141592653589793238462643383279502884197169399375105820974944592");
        
        //BigInteger b = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        BigInteger a = BigInteger.valueOf(5678);
        BigInteger b = BigInteger.valueOf(1234);
        
        
        System.out.print(intergerMulti(4, BigInteger.valueOf(5678),BigInteger.valueOf(1234)));
        
    }

}
