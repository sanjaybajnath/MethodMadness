// Sanjay Bajnath - Period 9
public class testFile
{
    public static void main (String [] args)
    {
        // The sum of the first 100 integers should be equal to 100(100+1)/2, or 5050.
        System.out.println(SBajnathLib.sumUpTo(100));

        //The LCM of 3, 4, and 5 should be 60.
        System.out.println(SBajnathLib.leastCommonMultiple(5,4,3));

        //In this case, both roots are imaginary.
        System.out.println(SBajnathLib.quadSolver(1,0,4));

        //In this case, both roots are equal.
        System.out.println(SBajnathLib.quadSolver(1,4,4));

        //In this case, there are two different real roots.
        System.out.println(SBajnathLib.quadSolver(1,5,6));

        //According to the example, the output should be 4.
        System.out.println(SBajnathLib.stringUnion("hello","hola","nihao"));

        //In this case, there are spaces in the message being encrypted.
        System.out.println(SBajnathLib.vigCipher("text to encode","key"));

        //In this case, there are no spaces in the message being encrypted.
        System.out.println(SBajnathLib.vigCipher("attackatdawn","lemon"));
    }
}

