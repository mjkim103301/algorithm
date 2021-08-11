#include <string>
#include <vector>
#include<iostream>
#include<stack>
using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    int size = prices.size();
    for (int i = 0; i < size; i++) {
        int price = prices[i];
        int count = 0;
        for (int j = i + 1; j < size; j++) {
           
            int temp = prices[j];
            if (price <= temp) {
                count++;
            }
            else {
                count++;
                break;
            }
        }
        answer.push_back(count);
    }
    return answer;

}
int main() {
    vector<int> prices;
    prices.push_back(1);
    prices.push_back(2);
    prices.push_back(3);
    prices.push_back(2);
    prices.push_back(3);
    vector<int> answer = solution(prices);
    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i] << " ";
    }
    return 0;
}