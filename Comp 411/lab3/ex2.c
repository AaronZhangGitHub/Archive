/* Example: analysis of text */

#include <stdio.h>
#include <string.h>

#define MAX 1001 /* The maximum number of characters in a line of input */

main()
{
  char str[MAX], c;
  int i, length,check;
  check = 1;

  puts("Type some text (then ENTER):");
  
  /* Save typed characters in text[]: */
    
  fgets(str, MAX, stdin);
 
  
  /* Analyse contents of text[]: */
    
  length = strlen(str); 
  length--;

  puts("Your input in reverse is:");
  for(i=0;i<length;i++){
    printf("%c", str[length-1-i]);  }
  printf("\n");

  for(i=0;i<length;i++){
    if(str[i]!=str[length-1-i]){
      check = 0;
    }
  }
  if(check==1){printf("Found a palindrome!\n");}
}

