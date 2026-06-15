class TimeMap {
private:
    unordered_map<string,vector<pair<string,int>>> mp;
public:
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        mp[key].push_back({value,timestamp});
    }
    
    string get(string key, int timestamp) {
        vector<pair<string,int>> range=mp[key];
        if (range.size()==0) return "";
        int l=0, r=range.size()-1;
        while((r-l)>1){
            int mid=(l+r)>>1;
            if(range[mid].second==timestamp) return range[mid].first;
            if(range[mid].second<timestamp){
                l=mid;
            }else{
                r=mid;
            }
        }
        
        if(range[r].second<=timestamp)
            return range[r].first;
        if(range[l].second<=timestamp)
            return range[l].first;
        return "";

        
    }
};
