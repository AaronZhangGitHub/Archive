#include <stdio.h>

main(){
  int inp,i;
  inp = 0;
  printf("Number [1-100]: ?\n");
  scanf("%d", &inp);
  while(inp!=0){
   if(inp==1){
    printf("Non-prime (special case)\n");
  }else if(inp==2){
    printf("Prime\n");
  }else{
    for(i=2;i<inp;i++){
       if(inp % i ==0){
          printf("Non-prime, divisible by %i\n",i);
          break;
         }else if (i==inp-1){
             printf("Prime\n");
           }
      }
  }
  printf("Number [1-100]: ?\n");
  scanf("%d", &inp);
 }
  printf("Done\n");
}
