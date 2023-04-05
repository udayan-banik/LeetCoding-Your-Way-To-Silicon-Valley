class KthLargest {
private:
    int k;
    priority_queue<int, vector<int>, greater<int>> n;
    
public:
    KthLargest(int k, vector<int>& nums) {
        this->k=k;
        
        for(auto i:nums){
            n.push(i);
            if(n.size()>k) n.pop();
        }
        
        // sort(n.begin(),n.end(),greater<int>());
    }
    
    int add(int val) {
        n.push(val);
        
        while (n.size() > k) n.pop();
        
        return n.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */