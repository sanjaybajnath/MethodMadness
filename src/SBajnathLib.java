public class SBajnathLib
{
    //Methods:
    public static boolean isPrime (int n)
    {
        for (int i = 2; i<n; i++)
        {
            if (n%i == 0)
            {
                return false;
            }
        }
        return true;
    }
    // primePrinter: Prints the first num primes
    public static void primePrinter(int num)
    {
        int i = 0;
        int prime = 0;
        while (i <= num)
        {
            if (isPrime(prime))
                {
                    System.out.println(prime);
                    i++;
                } 
            prime ++;
        }            
    }
    
}
