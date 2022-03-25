import java.security.Identity;

public abstract class Item {
    protected int volume;
    protected String itemId;

    public Item (int n, String ID)
    {
        volume = n;
        itemId = ID;
    }

    public Item (Item other)
    {
        volume = other.volume;
        itemId = other.itemId;
    }

    public int getVolume ()
    {
        return volume;
    }

    public String getItemId ()
    {
        return itemId;
    }
@Override
    public String toString ()
    {
        return ", ID: " + itemId + ", volume: " + volume;
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
            Item tmp = (Item)o;
            if (this == tmp)
            {
                return true;
            }
            return volume == tmp.volume && itemId.equals(tmp.itemId);
        }
        return false;
    }

}
