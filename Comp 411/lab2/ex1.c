#include <stdio.h>

main(){
  int inp, i;
  printf("Please enter a number from 1 to 5:\n");
  scanf("%d", &inp);
  if(inp<1 || inp>5){
    printf("Number is not in the range from 1 to 5\n");
 }else{
    for(i=1;i<inp+1;i++){
         printf("%i Hello World\n", i);
       }
 }
}
