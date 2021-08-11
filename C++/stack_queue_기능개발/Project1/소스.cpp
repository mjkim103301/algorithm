#include <string>
#include <vector>
#include<iostream>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int>endDay;
    int size = speeds.size();
    for (int i = 0; i < size; i++) {

        int progress =100- progresses[i];
        int speed = speeds[i];
        int temp = progress / speed;
        if (progress % speed != 0) {
            temp++;
        }
        endDay.push_back(temp);
    }
    int max = endDay[0];
    int count = 0;
    for (int i = 0; i < size; i++) {
        if (endDay[i] > max) {
            max = endDay[i];
            answer.push_back(count);
            count = 1;
        }
        else {
            count++;
        }
    }
    answer.push_back(count);
    return answer;
}
int main() {
    vector<int> progresses;
    vector<int> speeds;
    progresses.push_back(93);
    progresses.push_back(30);
    progresses.push_back(55);

    speeds.push_back(1);
    speeds.push_back(30);
    speeds.push_back(5);

    vector<int> answer = solution(progresses, speeds);
    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i] << " ";
    }
    return 0;
}