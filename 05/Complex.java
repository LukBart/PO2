import java.lang.Math;

public class Complex {
    private double r;
    private double im;
    public Complex (double a, double b){
        r = a;
        im = b;
    }

    public Complex (double a){
        r = a;
        im = 0.;
    }

    public Complex (){
        r = 0.;
        im = 0.;
    }

    @Override
    public String toString (){
        String str = "";
        if (Math.abs (r) < 1e-6 && Math.abs (im) < 1e-6)
            return "0.0";
        if (Math.abs (r) > 1e-6) {
            str += r;
        }

        if (Math.abs (im) > 1e-6 && Math.abs (r) > 1e-6) {
            if (im > 0) {
                str += " + " + im + "i";
            }
            else  {
                str += " - " + Math.abs(im) + "i";
            }
        }
        if (Math.abs (im) > 1e-6 && Math.abs (r) < 1e-6) {
            if (im > 0) {
                str += im + "i";
            }
            else  {
                str += im + "i";
            }
        }

        return str;

        
    }
    @Override
    public boolean equals (Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() == this.getClass()) {
            Complex tmp = (Complex)o;
            if (this == tmp) {
                return true;
            }
            return r == tmp.r && im == tmp.im;
        }
        return false;
    }



    public double getR () {
        return r;
    }

    public double getIm () {
        return im;
    }

    @Override
    public int hashCode (){
        return (int)((r+im)*1000);
    }
}
