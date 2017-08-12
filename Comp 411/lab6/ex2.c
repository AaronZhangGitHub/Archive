#include <stdio.h> /*Need for I/O functions*/

main(){
  int x1, x2, y1, y2, columns, rows, maxVals; //cropping values
  int i , j, grayValue, cropCol, cropRow;
  scanf("%d%d%d%d%d%d%d",&x1,&x2,&y1,&y2,&columns,&rows,&maxVals);
  cropCol = x2-x1+1;
  cropRow = y2-y1+1;
  printf("%c%d\n%d\n%d\n%d\n",'P',2,cropCol,cropRow,maxVals);

  for(i=0;i<rows;i++){//iterate through the rows
      for(j=0;j<columns;j++){
          scanf("%d",&grayValue);
        if(j>=x1 && j<=x2 && i>=y1 && i<=y2){
          printf("%d\n",grayValue);
        }
     }
  }
}
