import java.math.BigInteger;

public class Main
{
    public static void main (String[] args)
    {
        int p = 397; int q = 103;
        BigInteger n = BigInteger.valueOf(p *q);
        BigInteger phi = BigInteger.valueOf((p-1) * (q-1));

        BigInteger e = BigInteger.valueOf(3);
        while (!phi.gcd(e).equals(BigInteger.valueOf(1)))
        {
            e = e.add(BigInteger.valueOf(2));
        }

        BigInteger d = BigInteger.valueOf(1);
        while (!(d.multiply(e).mod(phi).equals(BigInteger.valueOf(1))))
        {
            d = d.add(BigInteger.valueOf(1));
        }
        System.out.println ("phi = " + phi + "\ne = " + e + "\nd = " + d);

        String word = "Test";
        BigInteger t[] = new BigInteger [word.length()];
        System.out.print ("\nszyfr = ");
        for (int i = 0; i < word.length(); i++)
        {
            t[i] = BigInteger.valueOf(word.codePointAt(i));
            System.out.print (t[i] + ", ");
        }
        System.out.print ("\nszyfr po zakodowaniu = ");
        for (int i = 0; i < t.length; i++)
        {
            t[i] = t[i].modPow (e ,n);
            System.out.print (t[i] + ", ");
        }
        System.out.print ("\nszyfr po zdekodowaniu = ");
        for (int i = 0; i < t.length; i++)
        {
            t[i] = t[i].modPow (d ,n);
            System.out.print (t[i] + ", ");
        }
        String newWord = "";
        for (int i = 0; i < t.length; i++)
        {
            newWord += (char)t[i].intValue();
        }
        System.out.println ("\nkonwersja na tekst: " + newWord);

    }
}