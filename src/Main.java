import java.io.*;
import java.lang.String;

/**
 *class containing set
 */

class Set
{
    /**
     * Subclass describing node in set
     */
    class SetNode
    {
        public int key;
        public boolean deleted; //true if node is deleted
        SetNode(int val) {
            key = val;
            deleted = false;
        }

    }

    /**
     *
     * @param val stored value
     * @return index of this element in hash table
     */
    private int indexOf(int val)
    {
        int index=val%capacity;
        int start = index; //starting index
        while(hashTable[index]!=null) //searching for fiiting place
        {
            if (hashTable[index].key == val)
                break;

            index += start;
        }

        return index;
    }
    private int capacity; //size of set
    private SetNode[] hashTable;

    /**
     *
     * @param cap capacity of set
     */
    Set(int cap)
    {
        capacity=cap;
        hashTable=new SetNode[cap];
    }

    /**
     *Pushess new value to set
     * @param val value that will pe pushed to set
     */
    public void push(int val)
    {
        int index = indexOf(val); //searching for index of element
        if(hashTable[index]==null) //if fitting place is empty
        {
            hashTable[index]=new SetNode(val);
            return;
        }
        hashTable[index].deleted=false; //if was found in table
    }

    /**
     * deletes value from set
     * @param val value to be deleted
     */
    public void delete(int val)
    {
        int index=indexOf(val);
        if(hashTable[index]!=null) //if was found in table
        {
            hashTable[index].deleted=true;
        }
    }

    /**
     * Searches  for value in set
     * @param val value to search
     * @return true if value was found, false if not found
     */
    public boolean contains(int val)
    {
        int index=indexOf(val);
        if(hashTable[index]==null) //if no element found
            return false;
        if(hashTable[index].deleted) //if it was deleted
            return false;

        return true; //in other cases
    }

}


public class Main {

    public static void main(String[] args)
    {
        Set set=new Set(1000001);
        set.push(6);
        System.out.println(set.contains(6)+" "+set.contains(9));


    }
}
