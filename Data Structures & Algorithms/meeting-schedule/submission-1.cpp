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
    bool canAttendMeetings(vector<Interval>& intervals) {
        int i=1, n=intervals.size();
        sort(intervals.begin(),intervals.end(),[](auto a, auto b){
            return a.end<b.end;
        });
        int end=intervals[0].end;
        while(i<n){
            if(intervals[i].start<end){
                return false;
            }else{
                end=intervals[i].end;
            }
            i++;
        }
        return true;
        
    }
};
