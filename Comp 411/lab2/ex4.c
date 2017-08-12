#include <stdio.h>

main(){
  int inp,i;
  int intArr [6];
  printf("Enter six integers:\n");

  for(i=0;i<6;i++){
   scanf("%d", &inp);
   intArr[i] = inp;
  }
  printf("1234567890bb1234567890\n");  
  int  a, b;
  for(i=0;i<6;i++){
   a = intArr[i];
   i++;
   b = intArr[i];
   printf("%10d  %10d\n" ,a,b);
  }
}
