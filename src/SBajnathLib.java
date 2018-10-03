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

    //cutOut: returns mainStr with the first occurrence of subStr removed.
    public static String cutOut(String mainStr, String subStr)
    {
        int index = mainStr.indexOf(subStr);
        if (index == -1)
        {
            return mainStr;
        }
        String before = mainStr.substring(0, index);
        String after = mainStr.substring(index + subStr.length());
        return before + after;
    }

    //leastCommonMultiple: Returns the least common multiple shared by all three numbers.
    public static int leastCommonMultiple(int num1, int num2, int num3)
    {
        if (num1 == 0 || num2 == 0 || num3 == 0)
        {
            return 0;
        }
        int LCM = 1;
        while(LCM%num1 != 0 || LCM%num2 != 0 || LCM%num3 != 0)
        {
            LCM++;
        }
        return LCM;

    }

}
