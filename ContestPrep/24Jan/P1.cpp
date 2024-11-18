#include <iostream>
#include <vector>
using namespace std;

int main() {
    int T;
    cin >> T;

    while (T > 0) {
        T--;
        int N;
        cin >> N;

        vector<int> hi(N, 0);
        vector<int> res(N, 0);
        for (int i = 0; i < N; i++) {
            cin >> hi[i];
        }

        if (N == 1) {
            cout << hi[0] << endl;;
            continue;
        }

        if (N == 2) {
            cout << -1 << endl;
            continue;
        }

        for (int i = 0; i < N - 2; i++) {
            if (hi[i] == hi[i + 1] || hi[i] == hi[i + 2]) {
                res[hi[i] - 1] = 1;
            }
            if (hi[i + 1] == hi[i + 2]) {
                res[hi[i + 1] - 1] = 1;
            }
        }

        bool allZero = true;
        int lastOneIndex = -1;
        for (int i = 0; i < N; i++) {
            if (res[i] == 1) {
                allZero = false;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            if (res[i] == 1) {
                lastOneIndex = i;
                break;
            }
        }
        for (int i = 0; i < N; i++) {
            if (res[i] == 1 && i != lastOneIndex) {
                cout << i + 1 << " ";
            }
            if (res[i] == 1 && i == lastOneIndex) {
                cout << i + 1 << endl;
            }
        }

        if (allZero) {
            cout << -1 << endl;
            continue;
        }
    }
}