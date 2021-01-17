#include<iostream>
#include<cmath>
using namespace std;
int N;
int map[20][20];
int path[10];
int people[20]{ 1, };
int diffMin=INT16_MAX;

void findDiff() {
	int start = 0;
	int link = 0;
	for (int i = 0; i < N; i++) {
		if (people[i] == 0) {//link team
			for (int j = 0; j < N; j++) {
				if (people[j] == 0) {
					link += map[i][j];
				}
			}
		}
		else if (people[i] == 1) {//start team
			for (int j = 0; j < N; j++) {
				if (people[j] == 1) {
					start += map[i][j];
				}
			}
		}
	}

	int diff = abs(start - link);
	if (diffMin > diff) {
		diffMin = diff;
	}
}
void dfs(int now) {
	int half = N / 2;
	if (now == half) {
		findDiff();
		return;
	}
	int last = path[now - 1];
	for (int i = 0; i < N; i++) {
		if (last >= i)continue;
		if (people[i] == 1)continue;
		people[i] = 1;
		path[now] = i;
		dfs(now + 1);
		people[i] = 0;
		path[now] = -1;
	}

}
int solution() {
	dfs(1);
	return diffMin;
}
int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}
	int ans = solution();
	cout << ans;
}