//
// Created by Mikasa on 2019/3/21.
//

#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main() {
    string s;
    cin >> s;
    char *temp = (char *) malloc(15 * sizeof(char));
    strcpy(temp, s.c_str());
    string s1(temp);
    s.erase(1, 1);
    s.erase(4, 1);
    s.erase(9, 1);
    int check = 0;
    for (int i = 0; i < 9; i++) {
        check += (s[i] - 48) * (i + 1);
    }
    check %= 11;
    if (check == 10) {
        if (s[9] != 'X') {
            cout << s1.substr(0, 12) + 'X';
        } else {
            cout << "Right";
        }
    } else if (s[9] - 48 == check) {
        cout << "Right";
    } else {
        cout << s1.substr(0, 12) + (char) (check + 48);
    }
    return 0;
}