//
// Created by Mikasa on 2019/3/21.
//

#include <iostream>

using namespace std;

int main() {
    int x, n;
    int result = 0;
    cin >> x >> n;
    x = 8 - x;
    n -= x;

    if (x > 2) {
        result += (250 * (x - 2));
    }

    x = n % 7;
    n = n / 7;
    result += (x >= 5 ? 1250 : x * 250);
    result += n * 250*5;
    cout << result;
    return 0;
}