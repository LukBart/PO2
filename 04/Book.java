public class Book extends Item{
    private String title;
    private String author;

    public Book (int n, String ID, String a, String t)
    {
        super(n, ID);
        title = t; 
        author = a;
    }
    public Book (Book other)
    {
        super (other);
        title = other.title;
        author = other.author;
    }
@Override
    public String toString ()
    {
        return "[book] author: " + author + ", title: " + title + super.toString();
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
            Book tmp = (Book)o;
            if (this == tmp)
            {
                return true;
            }
            return super.equals(tmp) && title.equals(tmp.title) && author.equals(tmp.author);
        }
        return false;
    }
}
