#include<iostream>
#include<vector>
using namespace std;

int N;
vector<int> T;
vector<int>P;
vector<int> dp(17);

int solution() {
	for (int i=N; i > 0; i--) {
		int next = T[i] + i;
		if (next> N + 1) {
			dp[i] = dp[i + 1];
		}
		else {
			dp[i] = max(dp[i + 1], dp[next] + P[i]);
		}
	}
	return dp[1];
}

int main() {
	cin >> N;
	T.push_back(0);
	P.push_back(0);
	for (int i = 1; i <= N; i++) {
		int days, money;
		cin >> days >> money;
		T.push_back(days);
		P.push_back(money);
		
	}
	int ans = solution();
	cout << ans;
}