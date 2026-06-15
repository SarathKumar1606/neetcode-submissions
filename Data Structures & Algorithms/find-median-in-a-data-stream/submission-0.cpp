class MedianFinder {
private:
    priority_queue<int,vector<int>> maxheap;
    priority_queue<int,vector<int>, greater<>> minheap;
public:
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        maxheap.push(num);
        if(!maxheap.empty() && !minheap.empty() && maxheap.top()>minheap.top()){
            minheap.push(maxheap.top());
            maxheap.pop();
        }
        if(maxheap.size()>minheap.size()+1){
            minheap.push(maxheap.top());
            maxheap.pop();
        }else if(minheap.size()>maxheap.size()+1){
            maxheap.push(minheap.top());
            minheap.pop();
        }
    }
    
    double findMedian() {
        if(maxheap.size()>minheap.size()){
            return maxheap.top();
        }else if(maxheap.size()<minheap.size()){
            return minheap.top();
        }
        return (maxheap.top()+minheap.top())/2.0;
        
    }
};
