#include <stdio.h>

main(){
 int inp,fibpr;
 inp=1;
 while(inp !=0){
  printf("Enter a number:\n");
  scanf("%d",&inp);
  fibpr = fibonacci(inp);
  printf("fibonacci(%i) = %i\n",inp,fibpr);
 }
}
int fibonacci(int n){
  if(n==0){return 0;}
  else if(n==1){return 1;}
  return fibonacci(n-1)+fibonacci(n-2);
}
