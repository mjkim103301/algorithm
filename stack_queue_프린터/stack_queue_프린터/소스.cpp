#include <string>
#include <vector>
#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

struct Node {
    int name;
    int priority;
};
queue<Node> doc;
bool cmp(const int& c1, const int& c2) {
    if (c1 > c2)return true;
    else return false;
}
int solution(vector<int> priorities, int location) {
    int answer = 0;
    int size = priorities.size();
    int count = 0;  
    int max_index = 0;
    for (int i = 0; i < size; i++) {
        doc.push({ i, priorities[i] });
    }
    sort(priorities.begin(), priorities.end(), cmp);
    while (!doc.empty()) {
        Node front = doc.front();
      
        if (front.priority >= priorities[max_index]) {
            count++;
            if (location == front.name) {
                return count;
            }
            else {
                doc.pop();             
            }
            if (front.priority == priorities[max_index]) {
                max_index++;
            }
        }
        else {
            doc.pop();
            doc.push(front);
        }    
    }
    answer = count;
    return answer;
}
int main() {
    vector<int> priorities;
  /*  priorities.push_back(2);
    priorities.push_back(1);
    priorities.push_back(3);
    priorities.push_back(2);*/
    priorities.push_back(1);
    priorities.push_back(1);
    priorities.push_back(9);
    priorities.push_back(1);
    priorities.push_back(1);
    priorities.push_back(1);
    int answer = solution(priorities, 0);
    cout << answer;
    return 0;
}