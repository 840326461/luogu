//
// Created by Mikasa on 2019/3/21.
//

#include <iostream>
using namespace std;
int main(){
    int n,x;
    cin>>n>>x;
    int counter=0;
    for(int i=n;i>=1;i--){
        int b=i;
        while (b>0){
            if(b%10==x)
                counter++;
            b/=10;
        }
    }
    cout<<counter;
    return 0;
}