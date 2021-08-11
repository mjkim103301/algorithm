#include<iostream>
#include<vector>
using namespace std;

int N;
int zeroCnt;
int level;
vector<int> robots;
vector<int> cbelt;

void erase() {
	if (robots[0] >= N - 1) {
		robots.erase(robots.begin());
	}
}
void rotate() {
	int temp = cbelt[2*N-1];
	cbelt.pop_back();
	cbelt.insert(cbelt.begin(), temp);
	int size = robots.size();
	if (size == 0) {
		return;
	}
	for (int i = 0; i < size; i++) {
		robots[i]++;
	}
	erase();
}
void realMove(int i, int location) {
	robots[i]++;
	cbelt[location + 1]--;
	if (cbelt[location + 1] == 0) {
		zeroCnt++;
	}
}
void move() {
	int size = robots.size();
	if (size == 0) {
		return;
	}
	for (int i = 0; i < size; i++) {
		int location = robots[i];
		if (cbelt[location + 1] > 0) {
			if (i > 0 && (robots[i - 1] > (robots[i] + 1))) {
				realMove(i, location);
			}
			else if (i == 0) {
				realMove(i, location);
			}
		}	
	}
	erase();
}
void ride() {
	if (cbelt[0] > 0) {
		cbelt[0]--;
		if (cbelt[0] == 0) {
			zeroCnt++;
		}
		robots.push_back(0);
	}
}
int solution(int n, int k, vector<int> belt) {
	N = n;
	cbelt = belt;
	while (zeroCnt < k) {
		level++;
		rotate();
		move();
		ride();
	}
	return level;
}
int main() {
	int N;
	int K;
	int num;
	vector<int> belt;
	cin >> N;
	cin >> K;
	for (int i = 0; i < 2*N; i++) {
		cin >> num;
		belt.push_back(num);
	}
	int ans = solution(N, K, belt);
	cout << ans;
}
