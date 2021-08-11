#include <string>
#include <vector>
#include<iostream>
#include<queue>
using namespace std;

struct Node {
    int length;
    int weight;
};
queue<Node> q;

int weight_temp = 0;
int Time = 0;
int index = 0;

void insert(int length, int weight) {
    q.push({ length, weight});
    weight_temp += weight;
   
}
void Delete(int front_weight) {
    weight_temp -= front_weight;
    q.pop();

}
int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int size = truck_weights.size();

    insert(Time+bridge_length, truck_weights[index++]);
    Time++;
    while (index<size) {
        if (weight < truck_weights[index])continue;

        if (q.front().length < Time) {
            Delete(q.front().weight);          
        }

        if (weight_temp + truck_weights[index] <= weight) {
            insert(Time + bridge_length, truck_weights[index++]);
            Time++;
        }
        else {
            while (weight_temp + truck_weights[index] > weight) {

               Time += (q.front().length - Time)+1;
                Delete(q.front().weight);
            }
            insert(Time + bridge_length-1, truck_weights[index++]);
        }

    }
    while (!q.empty()) {

        Time += (q.front().length - Time)+1;
        q.pop();
    }
    answer = Time;
    return answer;
}
int main() {
    vector<int> truck_weights;
  /*  truck_weights.push_back(10);
    truck_weights.push_back(10);
    truck_weights.push_back(10);
    truck_weights.push_back(10);
    truck_weights.push_back(10);
    truck_weights.push_back(10);
    truck_weights.push_back(10);
    truck_weights.push_back(10);
    truck_weights.push_back(10);
    truck_weights.push_back(10);*/

    truck_weights.push_back(7);
    truck_weights.push_back(4);
    truck_weights.push_back(5);
    truck_weights.push_back(6);
    int answer = solution(2, 10, truck_weights);
    cout << answer;
    return 0;
}
