public class MyHashSetLinear {
    String arr[] = new String[30];

    public void add(String name){
        int i = hash(name);
        if(i == Integer.MIN_VALUE)return;
        if(arr[i] == null){
            arr[i] = name;
        }
        else{
            if(!arr[i].equals(name)){
                for(i = i +1 ;i<arr.length;i++){
                    if(arr[i] == null){
                        arr[i] = name;
                        return;
                    }
                }
                for(int j = 0;j<i;j++){
                    if(arr[i] == null){
                        arr[i] = name;
                        return;
                    }
                }
            }
        }
    }

    public boolean search(String name){
        boolean flag = false;
        int i = hash(name);
        if(i != Integer.MIN_VALUE && arr[i] != null) {
            if (arr[i] == name)
                return true;
            for(i = i +1 ;i<arr.length;i++){
                if(arr[i].equals(name)){
                    return true;
                }
            }
            for(int j = 0;j<i;j++){
                if(arr[j] == name){
                    return true;
                }
            }
        }

        return flag;
    }

    private int hash(String name){
        if(name == null)
            return Integer.MIN_VALUE;
        int hash = 0;
        for(var ch : name.toCharArray()){
            hash += ch;
        }
        return Math.abs(hash) % arr.length;
    }

    public void print(){
        for(var x: arr){
            System.out.println(x);
        }
    }
}
