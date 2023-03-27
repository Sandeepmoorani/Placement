
import java.util.Scanner;

class Hash_List {

    static private class ListNode {
        Object key;
        Object value;
        ListNode next;
    }

    private ListNode[] List; // a hash List represeted by array of list

    private int count; // counts pairs in hash:

    public Hash_List() {
        List = new ListNode[64]; // auto initial value size;
    }

    public Hash_List(int capacity) {
        List = new ListNode[capacity]; // user required initial value size;
    }

    public void dump() {

        for (int i = 0; i < List.length; i++) {
            
            System.out.print(i + ":");
            
            ListNode list = List[i]; // For traversing linked list value i.
            
            while (list != null) {
            
            System.out.print(" (" + list.key + "," + list.value + ")");
            
            list = list.next;
            
            }
            
            System.out.println();
            
            }
    }

    public void put(Object key, Object value) {
        int bucket = hash(value);
        ListNode list = List[bucket]; // for traversing the linked list at appropraiate positoin

        while (list != null) {
            if (list.value.equals(value))
                break;
            list = list.next;
        }

        if (list != null)
            list.value = value;

        else {
            if (count >= 0.75 * List.length)
                resize();

            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = List[bucket];
            List[bucket] = newNode;
            count++;
        }
    }

public Object get(Object key) {
    int bucket = hash(key);
    ListNode list=List[bucket];  //for traversing the linked list at appropraiate positoin

while(list!=null){

    if(list.key.equals(key))

        return list.value;
    
    
    list=list.next;
}
 
return null;
}


    public void remove(Object key) {
        int bucket = hash(key);
        if (List[bucket] == null)
            return;

        if (List[bucket].key.equals(key)) {
            List[bucket] = List[bucket].next;
            count--;
            return;
        }

        ListNode prev = List[bucket];
        ListNode current = prev.next;

        while (current != null && !current.key.equals(key)) {
            current = current.next;
            prev = current;
        }

        if (current != null) {
            prev.next = current.next;
            count--;
        }
    }

    public boolean containsKey(Object key) {
        int bucket = hash(key);
        ListNode list = List[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return true;
            list = list.next;
        }
     
    return false;   
    }

private int hash(Object key){

    return (Math.abs(key.hashCode()%List.length));
}


    private void resize() {
        ListNode[] newList = new ListNode[List.length * 2];
        for (int i = 0; i < List.length; i++) {
            ListNode list = List[i];
            while (list != null) {
                ListNode next = list.next;
                int hash = (Math.abs(list.key.hashCode())) % newList.length;
                list.next = newList[hash];
                newList[hash] = list;
                list = next;

            }
        }
        List = newList;
    }

    public void update(Object key, Object value) {
        if (containsKey(key)) {
            this.remove(key);
            this.put(key, value);
        }

        else {
            System.out.println("value does not exit");
        }

    }

    public int size() {
        return count;
    }
}

 

public class HashTable {
    public static void main(String[] args) {
      
try (Scanner textIO = new Scanner(System.in)) {
    Hash_List List = new Hash_List(5);
    
    Object key,value;
    
    while (true) {
    
    System.out.println("\n Menu:");
    
    System.out.println(" 1.  Add_into_hash(key,value)");
    
    System.out.println(" 2.  get_from_hash(key)");
    
    System.out.println(" 3.  Contains_in_hash(key)");
    
    System.out.println(" 4.  Remove_from_hash(key)");
    
    System.out.println(" 5. Show Complete Contents Of Hash List.");

    System.out.println(" 6. Update_in_hash(key) ");

    System.out.println(" 7. EXIT");
    
    System.out.print("Enter your command: ");
    
    switch (textIO.nextInt()) {
    
    case 1:
    
    System.out.print("\n key = ");
    
    key = textIO.next();
    
    System.out.print(" value = ");
    
    value = textIO.next();
    
    List.put(key,value);
    
    
    break;
    
    case 2:
    
    System.out.print("\n key = ");
    
    key = textIO.next();
    
    System.out.println("The value at key "+key+"   is " + List.get(key));
    
    break;
    
    case 3:
    
    System.out.print("\n key = ");
    
    key = textIO.next();
    
    System.out.println(" containsKey(" + key + ") is "+ List.containsKey(key));
    
    break;
    
    case 4:
    
    System.out.print("\n key = ");
    
    key = textIO.next();
    
    List.remove(key);
    
    break;
    
    case 5:
    
    List.dump();
    
    break;
    
    case 6:
    System.out.print("\n key to Update = ");
    key = textIO.next();
    System.out.print("\n Enter the New value  = ");
    value = textIO.next();
    List.update(key,value);
    break;
    case 7:
    return;
    
    default:
    
    System.out.println(" Illegal command.");
    
    break;
    
    }
    
    System.out.println("\nHash List size is " + List.size());
    
    }
}
    }
}