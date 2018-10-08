// Sanjay Bajnath - Period 9
public class SBajnathLib
{
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
            return("The roots of ("+a+")x^2 +("+b+")x + ("+c+") = 0 are: x = "+ x1 +" and x = "+ x2+" .");
        }
        if (d < 0)
        {
            d *= -1;
            return("The roots of ("+a+")x^2 +("+b+")x + ("+c+") = 0 are imaginary! The roots are x = "+(x1/(2*a))+" + "+(Math.sqrt(d)/2*a)+"i and x = "+(x1/(2*a))+" - "+(Math.sqrt(d)/2*a)+"i.");
        }
        x1 = x1 + Math.sqrt(d);
        x1 = x1 / (2*a);
        return("The equation ("+a+")x^2 +("+b+")x + ("+c+") = 0 has a double root! There is only one solution, which is x = "+x1+" .");
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
        key = key.toLowerCase();
        message = message.toLowerCase();


        int count = 0;
        String keyword = "";
        for (int i = 0; i< message.length(); i++){
            if (!(message.substring(i, i + 1).equals(" "))) {
                keyword = keyword + key.substring(count%key.length(), (count%key.length()) +1);
                count ++;
            }
            else{
                keyword = keyword + " ";
            }
        }
        System.out.println(keyword);


        for (int i = 0; i < message.length(); i++)
        {
            if (!(message.substring(i,i+1).equals(" "))){
                encrypted = encrypted + CaesarCipher(message.substring(i,i+1),alphabet.indexOf(keyword.substring(i,i+1)));
            }
            else{
                encrypted = encrypted + " ";
            }

        }
        return encrypted;

    }
}
