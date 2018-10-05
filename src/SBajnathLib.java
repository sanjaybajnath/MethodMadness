// Sanjay Bajnath - Period 9
public class SBajnathLib
{
    /**
     *Checks whether a number is prime or not.
     * @param n The number being tested.
     * @return a boolean indicating whether the n is prime
     */

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

    /**
     * Prints a list of prime numbers. The length of the list is determined by the input.
     * @param num The number of prime numbers being printed.
     */
    public static void primePrinter(int num)
    {
        int count = 0;
        int prime = 2;
        while (count < num)
        {
            if (isPrime(prime))
            {
                System.out.println(prime);
                count++;
            }
            prime ++;
        }
    }


    /**
     * Adds all integers from 0 to the integer in the input.
     * @param num The amount of numbers being added together.
     * @return An integer that is equal to the sum of all integers from 0 to "num"
     */
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

    /**
     * Converts a date from mm/dd/yyyy to dd - mm - yyyy.
     * @param str The date being converted.
     * @return A string with the date in the new format.
     */
    public static String dateStr(String str)
    {
        String mm = str.substring(0, str.indexOf("/"));
        str = str.substring(str.indexOf("/")+1);
        String dd = str.substring(0, str.indexOf("/"));
        return (dd + " - " + mm + " - " + str.substring(str.indexOf("/")+1));
    }

    /**
     * Removes the first instance of subStr from mainStr.
     * @param mainStr The word that is being modified.
     * @param subStr The word being cut out from the main word.
     * @return A string of mainStr without the first instance of subStr.
     */
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

    /**
     * Finds the least common multiple of three integers.
     * @param num1 The first number that must evenly divide the least common multiple.
     * @param num2 The second number that must evenly divide the least common multiple.
     * @param num3 The third number that must evenly divide the least common multiple.
     * @return The smallest integer that is divisible by all three parameters.
     */
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

    /**
     * Uses the quadratic formula to solve for the roots of a quadratic equation.
     * @param a The coefficient for x^2.
     * @param b The coefficient for x.
     * @param c The constant in the equation.
     * @return A string explaining the roots of the equation.
     */
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

    /**
     * Counts how many unique characters are shared by at least two of the three inputted words.
     * @param word1 The first word being examined.
     * @param word2 The second word being examined.
     * @param word3 The third word being examined.
     * @return An integer that is equal to the number of unique characters that appear in at least two words.
     */
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

    /**
     * Uses the Caesar Cipher to shift a single letter.
     * @param letter The letter being shifted.
     * @param shift The magnitude of the shift.
     * @return The letter after it is shifted in the alphabet.
     */
    public static String CaesarCipher (String letter, int shift)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index = alphabet.indexOf(letter);
        shift = (shift + index)%26;
        letter = alphabet.substring(shift, shift+1);
        return letter;
    }


    /**
     * Uses the Vigenere Cipher to encrypt a string.
     * @param message The string that is being encrypted.
     * @param key The key for encryption.
     * @return The encrypted message.
     */
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
