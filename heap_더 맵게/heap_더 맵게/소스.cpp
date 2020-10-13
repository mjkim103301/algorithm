#include <string>
#include <vector>
#include <queue>
#include<iostream>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue< int, vector<int>, greater<int>> minHeap;
    for (int item : scoville) {
        minHeap.push(item);
    }
    while (minHeap.top() < K) {
        if (minHeap.size() < 2) {
            return -1;
        }
        int min = minHeap.top();
        minHeap.pop();
        int nextMin = minHeap.top();
        minHeap.pop();
        int input = min + nextMin * 2;
        minHeap.push(input);
        answer++;
       
    }

    return answer;
}
int main() {
    vector<int> scoville;
    scoville.push_back(1);
    scoville.push_back(2);
    scoville.push_back(3);
    scoville.push_back(9);
    scoville.push_back(10);
    scoville.push_back(12);

    int answer = solution(scoville, 7);
    cout << answer;
    return 0;
}