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
        int prime = 2;
        while (i < num)
        {
            if (isPrime(prime))
            {
                System.out.println(prime);
                i++;
            }
            prime ++;
        }
    }
    //sumUpTo: Sum of numbers from 0 to input
    public static int sumUpTo(int num)
    {
        int sum = 0;
        int a = 0;
        while (a<= num)
        {
            sum+=a;
            a++;
        }
        return sum;
    }

    //dateStr: Converts mm/dd/yyyy to dd - mm - yyyy
    public static String dateStr(String str)
    {
        String month = str.substring(0,2);
        String day = str.substring(3,5);
        String year = str.substring(6);
        return(day + " - "+ month+ " - "+year);
    }

}
