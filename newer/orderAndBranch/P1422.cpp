//
// Created by Mikasa on 2018/10/9.
//

#include <iostream>
#include <iomanip>

using namespace std;

int main(){
    int a;
    double result;
    cin>>a;
    if(a>=401){
        result=150*0.4463+250*0.4663+(a-400)*0.5663;
    }else if (a>=151){
        result=150*0.4463+(a-150)*0.4663;
    } else{
        result=a*0.4463;
    }
    cout<<setiosflags(ios::fixed) << setprecision(1)<<result;
}
