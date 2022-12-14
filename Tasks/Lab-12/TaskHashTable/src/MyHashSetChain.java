import java.util.LinkedList;

public class MyHashSetChain {
    LinkedList<String> set[] = new LinkedList[30];

    public void add(String name){
        int i = hash(name);
        if(i == Integer.MIN_VALUE)return;
        if(set[i] == null)
            set[i] = new LinkedList<>();
        if(!set[i].contains(name)){
            set[i].addLast(name);
        }
    }

    public boolean search(String name){
        int i = hash(name);
        if(i != Integer.MIN_VALUE && set[i] != null){
            for(var x : set[i].toArray()){
                if(x.equals(name))
                    return true;
            }
        }
        return false;
    }

    private int hash(String name){
        if(name == null)
            return Integer.MIN_VALUE;
        int hash = 0;
        for(var ch : name.toCharArray()){
            hash += ch;
        }
        return Math.abs(hash) % set.length;
    }

}
