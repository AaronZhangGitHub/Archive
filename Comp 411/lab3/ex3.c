main(){

#include <stdio.h>
 int A[3][3];
 int B[3][3];
 int C[3][3];
 int i,k,temp,j;
 char mtRep[3];
 temp=0;
 printf("Please enter the values for A[0..2][0..2], one row per line:\n");
 printf("Please enter the values for B[0..2][0..2], one row per line:\n");
 for(i=0;i<6;i++){
  if(i<3){
   for(k=0;k<3;k++){
     scanf("%d",&temp);
     A[i][k] = temp;
   }
  }else{
   for(k=0;k<3;k++){
     scanf("%d",&temp);
     B[i-3][k] = temp;
   }
  }
 }
 for(i = 0;i<3;i++){
   if(i==0){
   printf("A=");}
   printf("\n");
   for(k=0;k<3;k++){
     printf("   %3i", A[i][k]);
   }
 }

 for(i = 0; i<3; i++){
   if(i==0){
    printf("\n");
    printf("B=");}
    printf("\n");
    for(k=0;k<3;k++){
      printf("   %3i", B[i][k]);
    }
 }
 printf("\n");
  /* multiply C = A.B: */
  
  for (i = 0; i < 3; i++)
    for (j = 0; j < 3; j++)
    {
      C[i][j] = 0;
      for (k =0; k < 3; k++)
        C[i][j] += A[i][k] * B[k][j];
    }

  for(i=0;i<3;i++){
    if(i==0){
     printf("C=A.B="); }
     printf("\n");
     for(k=0;k<3;k++){
     printf("   %3i", C[i][k]);
    }
 }
  printf("\n");
   /* multiply C = B.A: */
  
  for (i = 0; i < 3; i++)
    for (j = 0; j < 3; j++)
    {
      C[i][j] = 0;
      for (k =0; k < 3; k++)
        C[i][j] += B[i][k] * A[k][j];
    }
  for(i=0;i<3;i++){
    if(i==0){
     printf("C=B.A=");}
     printf("\n");
     for(k=0;k<3;k++){
     printf("   %3i",C[i][k]);
     }
   }
  printf("\n");  
}
