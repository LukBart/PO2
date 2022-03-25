public class Laptop extends Item
{
    private String mark;

    public Laptop (int n, String ID, String b)
    {
        super(n, ID);
        mark = b;
    }

    public Laptop (Laptop other)
    {
        super(other);
        mark = other.mark;
    }

    @Override
    public String toString ()
    {
        return "[Laptop] mark: " + mark + super.toString();
    }
@Override
    public boolean equals (Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (o.getClass() == this.getClass())
        {
            Laptop tmp = (Laptop)o;
            if (this == tmp)
            {
                return true;
            }
            return super.equals(tmp) && mark.equals(tmp.mark);
        }
        return false;
    }
}