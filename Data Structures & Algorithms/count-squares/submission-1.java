class CountSquares {
    Map<Integer,Map<Integer,Integer>> mp;

    public CountSquares() {
        mp=new HashMap<>();
        
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        if(!mp.containsKey(x)){
           mp.put(x,new HashMap<>());
        }
        Map<Integer,Integer> yMap=mp.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        
    }
   
    public int count(int[] point) {
        int qx=point[0], qy=point[1];
        if(!mp.containsKey(qx)){
            return 0;
        }
        int ans=0;
        Map<Integer,Integer> yMap= mp.get(qx);
        for(Map.Entry<Integer,Integer> entry : yMap.entrySet()){
            int y=entry.getKey();
            int freq=entry.getValue();
            
            if(y==qy) continue;
            int side=Math.abs(y-qy);
            //check on right
            int x1=qx+side;
            /* query Point : (qx,qy)
            Vertical point : (qx,y)
            needed : (x1,qy),(x1,y)*/

            ans+=freq
            *mp.getOrDefault(x1,Collections.emptyMap()).getOrDefault(qy,0)
            *mp.getOrDefault(x1,Collections.emptyMap()).getOrDefault(y,0);

            //check on left
            int x2=qx-side;
            /* query Point : (qx,qy)
            Vertical point : (qx,y)
            needed : (x2,qy),(x2,y)*/
            ans+=freq
            *mp.getOrDefault(x2,Collections.emptyMap()).getOrDefault(qy,0)
            *mp.getOrDefault(x2,Collections.emptyMap()).getOrDefault(y,0);

        }
        return ans;

        
    }
}
