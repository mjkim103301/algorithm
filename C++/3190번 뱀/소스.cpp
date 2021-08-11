#include<iostream>
#include<queue>
using namespace std;
int N;
int K;
int apple[101][101];
int L;
int map[101][101];

struct Node {
	int y, x;
};
queue<Node> snake;
int time;
int direct=1;

int changeT[100];
char changeD[100];
int cmove[4][2] = {
	1,0,
	0,1,
	-1,0,
	0,-1
};
void changeDirect(char ch) {
	if (ch == 'D') {//¿À¸¥ÂÊ
		direct += 3;
		direct %= 4;
		
	}
	else if (ch == 'L') {//¿ÞÂÊ
		direct++;
		direct %= 4;
	}
}
int solution() {
	snake.push({ 1,1 });
	int changeIndex = 0;
	while (true) {
		time++;
		int nowY = snake.back().y+cmove[direct][0];
		int nowX = snake.back().x+cmove[direct][1];
		if (nowY<1 || nowY>N || nowX<1 || nowX>N)break;
		if (map[nowY][nowX] == 1)break;

		if (apple[nowY][nowX] == 0) {
			map[snake.front().y][snake.front().x] = 0;
			snake.pop();
		}else {
			apple[nowY][nowX] = 0;
		}
		
		map[nowY][nowX] = 1;
		snake.push({ nowY, nowX });
		if (time == changeT[changeIndex]) {
			changeDirect(changeD[changeIndex]);
			changeIndex++;
			
		}
		
	}
	return time;
}
int main() {
	cin >> N;
	cin >> K;
	int appleY, appleX;
	for (int i = 0; i < K; i++) {
		cin >> appleY >> appleX;
		apple[appleY][appleX] = 1;
	}
	cin >> L;
	for (int j = 0; j < L; j++) {
		cin >> changeT[j] >> changeD[j];
	}
	int ans = solution();
	cout << ans;
}