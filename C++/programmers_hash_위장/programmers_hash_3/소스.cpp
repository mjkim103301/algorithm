#include <string>
#include <vector>
#include <iostream>
#include<string>
#include<map>
using namespace std;


int solution(vector<vector<string>> clothes) {
    map<string, int> m;
    int answer = 1;
    int size = clothes.size();
    for (int i = 0; i < size; i++) {
        if (m.find(clothes[i].back())==m.end()) {
            m.insert(make_pair(clothes[i].back(), 1));
         
       
        }
        else {
            m.find(clothes[i].back())->second += 1;
        }
      
    }
    
    for (auto it = m.begin(); it != m.end(); it++) {
        answer *= it->second+1;
    }
    return answer-1;
}

int main() {
    vector<vector<string>> clothes;
    vector<string> vect1;
    vect1.push_back("yellow_hat");
    vect1.push_back("headgear");
    clothes.push_back(vect1);
    vect1.clear();
    vect1.push_back("blue_sunclasses");
    vect1.push_back("eyewear");
    clothes.push_back(vect1);
    vect1.clear();
    vect1.push_back("grean_turban");
    vect1.push_back("headgear");
    clothes.push_back(vect1);
    vect1.clear();

    cout << solution(clothes);
    return 0;
}