//
// Created by Mikasa on 2018/10/9.
//

#include <iostream>

using namespace std;

int main(){
    int predict;
    int remain=0,credit=0;
    for(int i=0;i<12;i++){
        cin>>predict;
        if(remain+300<predict){
            cout<<-(i+1);
            return 0;
        } else{
            credit+=(remain+300-predict)/100*100;
            remain=(remain+300-predict)%100;
        }
    }
    cout<<remain+credit*1.2;
}