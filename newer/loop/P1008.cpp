//
// Created by Mikasa on 2018/10/17.
//

#include <iostream>
#include <cstring>

using namespace std;
int counter[10];
void execute(int x){
    while(x>0){
        counter[x%10]++;
        x/=10;
    }
}

bool judge(){
    if(counter[0]!=0){
        return false;
    }
    for (int i=1;i<9;i++) {
        if(counter[i]!=1){
            return false;
        }
    }
    return true;
}
int main(){
    int a,b,c;
    for(int i=123;i<333;i++){
        a=i;
        b=a+i;
        c=b+i;
        memset(counter,0, sizeof(counter));
        execute(a);
        execute(b);
        execute(c);
        if(judge()){
            cout<<a<<" "<<b<<" "<<c<<endl;
        }
    }
}