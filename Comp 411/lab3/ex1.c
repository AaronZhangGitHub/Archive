/* Example: analysis of text */

#include <stdio.h>
#include <string.h>

#define MAX 1001 /* The maximum number of characters in a line of input */

main()
{
  char str[MAX], c;
  int i, length;
  int lowercase, uppercase, digits, other;
  
  puts("Type some text (then ENTER):");
  
  /* Save typed characters in text[]: */
    
  fgets(str, MAX, stdin);
 
  
  /* Analyse contents of text[]: */
    
  length = strlen(str); 
  length--;
  for (i = lowercase = uppercase = digits = other = 0; i < MAX; i++)
  {
    c = str[i];
    if (c >= 'a' && c <= 'z'){
     // length+=1;
      lowercase++;}
    else if (c >= 'A' && c <= 'Z'){
      //length+=1;
      uppercase++;}
    else if (c >= '0' && c <= '9'){
      //length+=1;
      digits++;}
    else
    {
      if (c == '\n')
        break;
      //length++;
      other++;
    }
  }
  
  puts("\nYou typed:");
  printf("A string with %d characters\n", length);
  printf("\t%d lower case letters\n", lowercase);
  printf("\t%d upper case letters\n", uppercase);
  printf("\t%d digits\n", digits);
  printf("\t%d others\n", other);
}

