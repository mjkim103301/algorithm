#include <string>
#include <vector>
#include<iostream>
#include<math.h>
using namespace std;

vector<int> remain;
int solution(int n) {
	int answer = 0;
	int size = 0;
	while (n >= 3) {
		remain.push_back(n % 3);
		n /= 3;
	}

	remain.push_back(n);
	size = remain.size();
	for (int i = 0; i < size; i++) {
		int value = remain[i]*pow(3, size - i - 1);
		answer += value;
	}
	return answer;

}
int main() {
	int n = 45;
	cout << solution(45);
}