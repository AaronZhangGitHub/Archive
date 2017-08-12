#include <stdio.h>
#include <string.h>

main(){
   int integer;
   while(1){
    scanf("%d",&integer);
    integer = fibonacci(integer);
    printf("%d\n", integer);

    if(integer == 0 ){
     break;
    }else{}
  }
}

int fibonacci(int n){
   if(n==0){
     return 0;
   }
   else  if(n==1){
     return 1;
   }
   else{return (fibonacci(n-1)+fibonacci(n-2));}
}
