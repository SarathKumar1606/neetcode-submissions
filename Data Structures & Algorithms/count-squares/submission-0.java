class CountSquares {
    HashMap<int[], Integer> mp;

    public CountSquares() {
        mp=new HashMap<>();
        
    }
    
    public void add(int[] point) {
        if(mp.containsKey(point)){
            int freq=mp.get(point);
            mp.put(point,++freq);
        }else{
            mp.put(point,1);
        }
        
    }
    
    public int count(int[] point) {
        return 0;
    }
}
