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
        //String month = str.substring(0,2);
        //String day = str.substring(3,5);
        //String year = str.substring(6);
        //return(day + " - "+ month+ " - "+year);
        String mm = str.substring(0, str.indexOf("/"));
        str = str.substring(str.indexOf("/")+1);
        String dd = str.substring(0, str.indexOf("/"));
        return (dd + " - " + mm + " - " + str.substring(str.indexOf("/")+1));
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


    //quadSolver (Quadratic Formula)
    public static String quadSolver(double a, double b, double c)
    {
        double x1 = -1 *b;
        double x2 = -1 *b;
        double d = b * b;
        d = d - (4*a*c);
        if (d > 0)
        {
            x1 = x1 + Math.sqrt(d);
            x1 = x1 / (2*a);
            x2 = x2 - Math.sqrt(d);
            x2 = x2 / (2*a);
            return("The roots of ("+a+")x^2 +("+b+")x + ("+c+") are: x = "+ x1 +" and x = "+ x2+" .");
        }
        if (d < 0)
        {
            d *= -1;
            return("The roots of ("+a+")x^2 +("+b+")x + ("+c+") are imaginary! The roots are x = "+(x1/(2*a))+" + "+(Math.sqrt(d)/2*a)+"i and x = "+(x1/(2*a))+" - "+(Math.sqrt(d)/2*a)+"i.");
        }
        x1 = x1 + Math.sqrt(d);
        x1 = x1 / (2*a);
        return("The equation ("+a+")x^2 +("+b+")x + ("+c+") has a double root! There is only one solution, which is x = "+x1+" .");
    }

    public static int stringUnion(String word1, String word2, String word3)
    {
        String Used = "";
        int count = 0;
        String character = "";
        for (int i = 0; i < word1.length(); i++)
        {
            character = word1.substring(i,i+1);
            if (word2.indexOf(character) != -1 && Used.indexOf(character) == -1)
            {
                count ++;
                Used = Used + character;
            }
        }
        for (int i = 0; i < word1.length(); i++)
        {
            character = word1.substring(i,i+1);
            if (word3.indexOf(character) != -1 && Used.indexOf(character) == -1)
            {
                count ++;
                Used = Used + character;
            }
        }
        for (int i = 0; i < word2.length(); i++)
        {
            character = word2.substring(i,i+1);
            if (word3.indexOf(character) != -1 && Used.indexOf(character) == -1)
            {
                count ++;
                Used = Used + character;
            }
        }
        return count;
    }

    //caesarCipher:
    public static String CaesarCipher (String letter, int shift)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index = alphabet.indexOf(letter);
        shift = (shift + index)%26;
        letter = alphabet.substring(shift, shift+1);
        return letter;
    }


    //vigCipher -
    public static String vigCipher(String message, String key)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encrypted = "";
        String keyword = key.toLowerCase();
        message = message.toLowerCase();
        if(key.length() < message.length())
        {
            for (int i = 0; i < (message.length()-key.length()); i++)
            {
                keyword = keyword + keyword.substring(i,i+1);
            }
        }
        if (keyword.length() > message.length())
        {
            keyword = keyword.substring(0, message.length());
        }
        for (int i = 0; i < message.length(); i++)
        {
            encrypted = encrypted + CaesarCipher(message.substring(i,i+1),alphabet.indexOf(keyword.substring(i,i+1)));
        }
        return encrypted;
    }
}
