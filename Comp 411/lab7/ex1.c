#include <stdio.h>
#include <string.h>

main(){
   char string[21];
   int integer;

   while(1){
    fgets(string,21,stdin);
    integer = a_to_i(string);
    printf("%d\n", integer);

    if(integer == 0 ){
     break;
    }else{}
  }
}

int a_to_i(char* str){
   int digit;
   int integer = 0;
   int i = 0;

   while(str[i] != '\n'){
    digit = (int)str[i] - '0';
    integer = integer*10 + digit;
    i++;
   }
   return integer;
}
