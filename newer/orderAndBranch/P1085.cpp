//
// Created by Mikasa on 2018/10/9.
//

#include <iostream>

using namespace std;

int main() {
    int a, b;
    int index = -1, degree = -1;
    for (int i = 0; i < 7; i++) {
        cin >> a >> b;
        if (a + b > 8 && a + b > degree) {
            degree = a + b;
            index = i;
        }
    }
    cout<<index+1;
}