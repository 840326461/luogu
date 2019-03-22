//
// Created by Mikasa on 2019/3/21.
//

#include <iostream>
using namespace std;
int main(){
    double k;
    cin>>k;
    double i=2;
    int count=1;
    double result=0;
    while(true){
        result+=i;
        if(result>=k){
            cout<<count;
            break;
        }
        i*=0.98;
        count++;
    }
    return 0;
}