/* Example: bubble sort strings in array */

#include <stdio.h>  /* Need for standard I/O functions */
#include <string.h> /* Need for strlen() */

#define NUM 25   /* number of strings */
#define LEN 1000  /* max length of each string */
#define LIM 25
main()
{
  char Strings[NUM][LEN];
  char temp[LEN];
  int l ,i, j, k = 0;
  k=1;
  int compare=0;
  printf("Please enter %d strings, one per line:\n", NUM);

  for(i=0;i<NUM;i++){
   fgets(Strings[i],LEN-2,stdin);
  }
  /* Write a for loop here to read NUM strings.

     Use fgets(), with LEN as an argument to ensure that an input line that is too
     long does not exceed the bounds imposed by the string's length.  Note that the
     newline and NULL characters will be included in LEN.
  */

 
  puts("\nHere are the strings in the order you entered:");
 for(i=0;i<NUM;i++){
   printf("%s",Strings[i]);
 }

for(i=0;i<NUM;i++){
 for(j=0;j<NUM;j++){
  compare=strcmp(Strings[i],Strings[j]);
  if(compare<0){
   strcpy(temp,Strings[i]);
   strcpy(Strings[i],Strings[j]);
   strcpy(Strings[j],temp);
  }
 }
}
 /* Bubble sort */
  /* Write code here to bubble sort the strings in ascending alphabetical order

     Your code must meet the following requirements:
        (i) The comparison of two strings must be done by checking them one
            character at a time, without using any C string library functions.
            That is, write your own while/for loop to do this.
       (ii) The swap of two strings must be done by copying them 
            (using a temp variable of your choice) one character at a time,
            without using any C string library functions.
            That is, write your own while/for loop to do this.
      (iii) You are allowed to use strlen() to calculate string lengths.
  */

  
  
  /* Output sorted list */
  
  puts("\nIn alphabetical order, the strings are:");     
  /* Write a for loop here to print all the strings. Feel free to use puts/printf
     etc. for printing each string.
  */
 for(i=0;i<NUM;i++){
   printf("%s",Strings[i]);
 }

  return 0;
}

