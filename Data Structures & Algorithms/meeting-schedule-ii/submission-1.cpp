/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        vector<int> start, end;
        for(auto &i : intervals){
            start.push_back(i.start);
            end.push_back(i.end);
        }
        sort(start.begin(),start.end());
        sort(end.begin(),end.end());
        int s=0, e=0, count=0, maxc=0,n=intervals.size();
        while(s<n && e<n){
            if(start[s]<end[e]){
                s++;
                count++;
                 maxc=max(count,maxc);
            }else{
                e++;
                count--;
            }
           

        }
        return maxc;
    }
};
