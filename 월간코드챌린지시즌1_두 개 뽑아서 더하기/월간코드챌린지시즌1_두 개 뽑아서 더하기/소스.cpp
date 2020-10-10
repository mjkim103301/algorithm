#include <string>
#include <vector>
#include <iostream>
#include<set>
using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    set<int> s;
    int size = numbers.size();
    for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
            s.insert(numbers[i] + numbers[j]);
        }
    }
    for (set<int>::iterator it = s.begin(); it != s.end(); it++) {
        answer.push_back(*it);
   }
    return answer;
}
int main() {
    vector<int> numbers;
    numbers.push_back(2);
    numbers.push_back(1);
    numbers.push_back(3);
    numbers.push_back(4);
    numbers.push_back(1);

    vector<int>answer = solution(numbers);
    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i] << " ";
    }
}