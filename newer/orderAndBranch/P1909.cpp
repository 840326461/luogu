//
// Created by Mikasa on 2018/10/9.
//

#include <iostream>

using namespace std;

int main(){
    int n;
    int a,b;
    int result=2147483647;
    cin>>n;
    for(int i=0;i<3;i++){
        cin>>a>>b;
        int temp=(n/a+((n%a)>0?1:0))*b;
        if(result>temp){
            result=temp;
        }
    }
    cout<<result;
}