public class SBajnathLib
{
    // isPrime identifies prime numbers by checking if any numbers less than n evenly divide into n.
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
            // This loop uses the previous method to check which numbers are prime.
            if (isPrime(prime))
            {
                System.out.println(prime);
                i++;
                // i counts how many times a prime number is printed.
            }
            prime ++;
        }
    }
    //sumUpTo: Returns sum of numbers from 0 to input
    public static int sumUpTo(int num)
    {
        int sum = 0;
        int a = 0;
        while (a<= num)
        {
            // sum is the total sum, and a is the number that needs to be added to sum in the next loop.
            sum+=a;
            a++;
        }
        return sum;
    }

    //dateStr: Converts mm/dd/yyyy to dd - mm - yyyy
    public static String dateStr(String str)
    {
        // This method separates the date into month, day, and year, and then rearranges the date into a different format.
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
            // if subStr is not found in mainStr, no changes are made.
        }
        // The method creates a new string that is the same as mainStr, but without the first instance of subStr.
        String before = mainStr.substring(0, index);
        String after = mainStr.substring(index + subStr.length());
        return before + after;
    }

    //leastCommonMultiple: Returns the least common multiple shared by all three numbers.
    public static int leastCommonMultiple(int num1, int num2, int num3)
    {
        if (num1 == 0 || num2 == 0 || num3 == 0)
        // if any of the 3 numbers are equal to 0, the least common multiple of all 3 will be 0.
        {
            return 0;
        }
        int LCM = 1;
        while(LCM%num1 != 0 || LCM%num2 != 0 || LCM%num3 != 0)
        {
            //This loop looks for the lowest integer greater than 0 that is divisible by all three numbers.
            LCM++;
        }
        return LCM;

    }


    //quadSolver - Returns string response with the roots of the quadratic equation described.
    public static String quadSolver(double a, double b, double c)
    {
        // This method uses the quadratic formula to find the roots and to determine whether the roots are real or imaginary.
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

    // stringUnion: Returns int number of unique letters shared by at least two of the words.
    public static int stringUnion(String word1, String word2, String word3)
    {
        String Used = "";
        int count = 0;
        String character = "";
        // The three loops compare each word to each of the other two words for any characters that appear in both words. Each loop only compares two words at a time.
        // "Used" contains all characters that have already been identified as unique characters in at least two words. This prevents double counting.
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

    //CaesarCipher - shifts a given letter by a given amount in the alphabet. This accounts for a letter being shifted past z.
    public static String CaesarCipher (String letter, int shift)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index = alphabet.indexOf(letter);
        shift = (shift + index)%26;
        letter = alphabet.substring(shift, shift+1);
        return letter;
    }


    //vigCipher - Returns encrypted message using the Vigenere Cipher.
    public static String vigCipher(String message, String key)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encrypted = "";
        String keyword = key.toLowerCase();
        message = message.toLowerCase();
        if(key.length() < message.length())
        {
            //For the Vigenere Cipher, the key and message must be the same length.
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
            //A Caesar Cypher is applied to each letter in the message, and each shift is determined by each letter's corresponding letter in the keyword.
            encrypted = encrypted + CaesarCipher(message.substring(i,i+1),alphabet.indexOf(keyword.substring(i,i+1)));
        }
        return encrypted;
    }
}
