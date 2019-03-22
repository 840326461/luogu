//
// Created by Mikasa on 2019/3/21.
//

#include <iostream>

using namespace std;

int main(){
    int k;
    cin>>k;
    int i=1;
    double result=0;
    while(true){
        result+=1.0/i;
        if(result>k){
            cout<<i;
            break;
        }
        i++;
    }
    return 0;
}