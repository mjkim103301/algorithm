#include<iostream>
#include <string>
#include <vector>

using namespace std;
int map[10001][1001];
int Move[3][2] = {
    1,0,
    0,1,
    -1,-1
};
vector<int> solution(int n) {
    vector<int> answer;
    int size = n;
    int row = -1;
    int col = 0;
    int count = 1;
    int max = (size * (size + 1)) / 2;
    while (count <= max) {
        for (int i = 0; i < 3; i++) {
            for (int j = size; j > 0;j--) {
                row += Move[i][0];
                col += Move[i][1];
                map[row][col] = count++;
               
               
            }
            size--;
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int temp = map[i][j];
            if (temp != 0) {
                answer.push_back(temp);
            }
           
        }
    }
    return answer;
}
int main() {
    vector<int>answer;
    answer = solution(6);
    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i] << " ";
    }
}