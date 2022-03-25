import java.util.*;

public class Box extends Item{
    private int capacity;
    private List<Item> items = new ArrayList<Item>();
    private int usedCapacity;

    public Box (int v, String ID, int c) {
        super (v, ID);
        capacity = c;
        usedCapacity = 0;
    }
    public Box (Box other) {
        super(other);
        capacity = other.capacity;
        usedCapacity = other.capacity;
        items = (ArrayList)(((ArrayList)other.items).clone());
    }

    public void addItem(Item i)
    {
        if (i.getClass() == this.getClass()){
            if(((Box)i).containsItem(this)){
                System.out.println("Cannot put this box into a box when a box is in this box?");
                return;
            }
        }
        if (i == this) {
            System.out.println("Cannot put box in same box?");
        }
        else if (usedCapacity + i.getVolume() <= capacity) {
            usedCapacity += i.getVolume();
            items.add(i);
        }
        else {
            System.out.println("Cannot add more items to the box");
        }
    }
@Override
    public String toString ()
    {
        String tmp = "";
        tmp += "[Box] capacity: " + capacity + ", items:[\n";
        for (Item i: items)
        {
            tmp += "\t" + i + "\n";
        }
        tmp += "]" + super.toString();
        return tmp;
    }

    public int getUsedCapacity ()
    {
        return usedCapacity;
    }

@Override
    public boolean equals (Object o)
    {
        if (o == null) {
            return false;
        }
        if (o.getClass() == this.getClass()) {
            Box tmp = (Box)o;
            if (this == tmp) {
                return true;
            }
            boolean b = true;
            for (int i = 0; i < items.size() && i < tmp.items.size() && b; i++) {
                b = items.get(i).equals(tmp.items.get(i));
            }
            if(b) {
                return super.equals(tmp) && capacity == tmp.capacity && usedCapacity == tmp.usedCapacity;
            }
        }
        return false;
    }
    public void removeItem (Item i)
    {
        if (this.containsItem(i)){
            if (!items.remove(i)){
                for (Item item : items) {
                    if (item.getClass() == this.getClass()) {
                        ((Box) item).removeItem(i);
                    }
                }
            }else
            usedCapacity -= i.getVolume();
        }
    }

    public int getVolume () {
        return super.getVolume() + usedCapacity;
    }

    public boolean containsItem (Item i) {
        boolean b = false;
        for (Item item : items) {
            if (item.equals(i)) {
                return true;
            } else if (item.getClass() == this.getClass()) {
                b = ((Box) item).containsItem(i);
            }
        }
        return b;
    }
}
