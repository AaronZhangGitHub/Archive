#include <stdio.h>

main(){
  float inp, sum, mean, product;
  float flArray[5];
  int i;
  sum = 0;
  product = 1;

  printf("Enter five floating-point numbers:\n");

  for(i=0;i<5;i++){  
   scanf("%f", &inp);
   flArray[i] = inp;
   sum+=inp;
   product*=inp;
 } 
 mean = sum/5;

 printf("Sum is %.4f\n",sum);
 printf("Mean is %.4f\n",mean);
 printf("Product is %.4f\n",product);

}
