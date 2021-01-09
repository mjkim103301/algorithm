#include<iostream>
#include<vector>
#include<cmath>
using namespace std;

int direct[4];
vector<vector<int>> cwheel;
void fillDirect(int start, int direction) {
	int next = start + 1;
	int prev = start - 1;
	direct[start] = direction;
	if (next < 4 && direct[next] == 0 && cwheel[start][2] != cwheel[next][6]) {
		fillDirect(next, direction * -1);
	}
	if (prev >= 0 && direct[prev] == 0 && cwheel[start][6] != cwheel[prev][2]) {
		fillDirect(prev, direction * -1);
	}
}
void rotation() {
	for (int i = 0; i < 4; i++) {
		if (direct[i] == 1) {//시계방향
			int temp = cwheel[i][7];
			for (int j = 7; j > 0; j--) {
				cwheel[i][j] = cwheel[i][j - 1];
			}
			cwheel[i][0] = temp;
		}
		else if (direct[i] == -1) {//반시계방향
			int temp = cwheel[i][0];
			for (int j = 0; j <7; j++) {
				cwheel[i][j] = cwheel[i][j + 1];
			}
			cwheel[i][7] = temp;
		}
	}
}
void directClear() {
	for (int i = 0; i < 4; i++) {
		direct[i] = 0;
	}
}
int solution(vector<vector<int>> wheel, int K, vector<vector<int>>rotate) {
	cwheel = wheel;
	for (int i = 0; i < K; i++) {
		int rotateIndex = rotate[i][0] - 1;
		int direction = rotate[i][1];
		fillDirect(rotateIndex, direction);
		rotation();
		directClear();
	}
	
	int score = 0;
	for (int j = 0; j < 4; j++) {
		if (cwheel[j][0] == 1) {
			score += (int)pow(2, j);
		}
	}
	return score;

}

int main() {
	string wheel;
	vector<int> wheelInside;
	vector<vector<int>>wheelOutside;
	for (int i = 0; i < 4; i++) {
		cin >> wheel;
		for (int j = 0; j < 8; j++) {
			wheelInside.push_back(wheel[j]-'0');
		}
		wheelOutside.push_back(wheelInside);
		wheelInside.clear();
	}
	int K;
	cin >> K;
	vector<int> rotateIn;
	vector<vector<int>>rotateOut;
	int wheelNum;
	int direct;
	for (int i = 0; i < K; i++) {
			cin >> wheelNum;
			rotateIn.push_back(wheelNum);
			cin >> direct;
			rotateIn.push_back(direct);
			rotateOut.push_back(rotateIn);
			rotateIn.clear();
	}
	int ans = solution(wheelOutside, K, rotateOut);
	cout << ans;
}

