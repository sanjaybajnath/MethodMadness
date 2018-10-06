// Sanjay Bajnath - Period 9
public class testFile
{
    public static void main (String [] args)
    {
       SBajnathLib.primePrinter(10);
       System.out.println(SBajnathLib.sumUpTo(100));
       System.out.println(SBajnathLib.dateStr("01/08/1999"));
       System.out.println(SBajnathLib.dateStr("1/8/1999"));
       System.out.println(SBajnathLib.cutOut("catatonic cat","cat"));
       System.out.println(SBajnathLib.leastCommonMultiple(5,4,3));
       System.out.println(SBajnathLib.quadSolver(1,0,4));
       System.out.println(SBajnathLib.quadSolver(1,4,4));
       System.out.println(SBajnathLib.quadSolver(1,5,6));
       System.out.println(SBajnathLib.stringUnion("hello","hola","nihao"));
       System.out.println(SBajnathLib.vigCipher("attackatdawn","lemon"));
    }
}

