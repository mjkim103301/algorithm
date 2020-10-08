#include <string>
#include <vector>
#include <iostream>
#include<map>
#include <list>
#include<iostream>
#include<algorithm>
using namespace std;
map<string, int> m;
map<string, int> m_c;

struct node {
    int index;
    string genre;
    int play;
};

list<node> l;

bool cmp2( node p1, node p2) {
    if (m[p1.genre] > m[p2.genre]) {
       return true;
    }
    else if (m[p1.genre]==m[p2.genre]){
        if (p1.play > p2.play) {
            return true;
        }
        else if (p1.play == p2.play) {
            return p1.index < p2.index;
        }
        else {
            return false;
        }
    }
    else {
        return false;
    }
}
vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
 
    int size = genres.size();
    for (int i = 0; i < size; i++) {
        m[genres[i]] += plays[i];
        m_c[genres[i]]++;
        l.push_back({ i, genres[i], plays[i] });
    }
    l.sort(cmp2);
    //sort(l.begin(), l.end(), cmp2);
    int count = 0;
    string temp_genre= l.front().genre;
    while (!l.empty()) {
        node tempNode = l.front();
        if (tempNode.genre == temp_genre && count<2) {
            count++;
            answer.push_back(tempNode.index);
        }
        else if (tempNode.genre != temp_genre) {
            count=1;
            answer.push_back(tempNode.index);
            temp_genre = tempNode.genre;
        }
        
        l.pop_front();
       
    }

    return answer;
}
int main() {
    vector<string> genres;
    vector<int> plays;
    genres.push_back("classic");
    genres.push_back("pop");
    genres.push_back("classic");
    genres.push_back("classic");
    genres.push_back("pop");
    plays.push_back(500);
    plays.push_back(600);
    plays.push_back(150);
    plays.push_back(800);
    plays.push_back(2500);
    vector<int> sol;
    sol = solution(genres, plays);
    int solSize = sol.size();
    for (int i = 0; i <solSize; i++) {
        cout << sol[i] << " ";
    }
    return 0;
}