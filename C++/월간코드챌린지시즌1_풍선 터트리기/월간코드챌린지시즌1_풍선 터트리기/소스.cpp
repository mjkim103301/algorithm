#include<iostream>
#include <string>
#include <vector>
#include<algorithm>
using namespace std;

struct Node {
    int index;
    int number;
};
Node arr[1000001];
bool cmp(const Node& c1, const Node& c2) {
    if (c1.number < c2.number) {
        return true;
    }
    else {
        return false;
    }
}
void sorting(vector<int> a, int size) {
    for (int i = 0; i < size; i++) {
        arr[i] = { i, a[i] };
    }
    sort(arr, arr+size, cmp);
}

int solution(vector<int> a) {
    int answer = 0;
    int size = a.size();
    if (size <3 )return size;
    sorting(a, size);
    int arrIndex = 0;
    int minLeft = 0;
    int minRight = arr[arrIndex++].index;
    int count = 0;
   
    for (int i = minLeft+1; i < size-1; i++) {
        if (a[i] < a[minLeft]) {
            minLeft = i;
        }
        else if (minRight > i) {
            if (a[i] > a[minRight]) {
                count++;
            }

        }
        else if(minRight<i){
            while (i > minRight) {
                minRight = arr[arrIndex++].index;
            }           
            if (a[i] > a[minRight]) {
                count++;
            }
        }
    }
    answer = size - count;
    return answer;
}
int main() {
    vector<int> a;
    a.push_back(9);
    a.push_back(-1);
    a.push_back(-5);
    int answer = solution(a);
    cout << answer;
}