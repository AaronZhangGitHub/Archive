#include <stdio.h> /*Need for I/O functions*/

/*
Program to convert a colored image PPM to grayscale PGM
Input is ASCII file format
The PPM or PGM file begins with an identifier called a "magic number" In this case "P3" means the file is ASCII PPM and "P2" means it is a ASCII PGM
next there are two numbers, first is the number of columns, second is the number of rows in the image.
Next is a maximum value which indicated the max value any pixel can have (15 and 255 are typical)
Finally there are the color or gray values for all values... values are ordered by rows from top to bottom

    For a PPM image, each pixel value is listed as the values of its three components, Red, Green and Blue.
    For a PGM image, each pixel value is a single gray value. 
*/
main(){
  char magicChar;
  int magicInt, columns, rows, maxVal;
  int i, j, k, r, g, b, grayValue;
  scanf("%c%d",&magicChar,&magicInt); //Scans the first line, holds the magic number in two variables
  scanf("%d%d",&columns,&rows); //scan the number of columns and rows in the image
  scanf("%d",&maxVal); //scan the max value any pixel can have
  //testing printf("Columns: %d Rows: %d maxVal: %d\n",columns,rows,maxVal);

  printf("%C2\n%d\n%d\n255\n",magicChar,columns,rows);

  for(j=0;j<rows;j++){
    //iterates through row by row
    for(i=0;i<columns;i++){
      //iterates through column by column
      scanf("%d%d%d",&r,&g,&b); //scan the red, green, and blue values of the pixel
       grayValue = ((r*30+g*59+b*11)*255)/(100*maxVal); //gray value for the r,g,b values
       if(grayValue>255){grayValue=255;} //ensures the max gray value is 255
       printf("%d\n", grayValue);//prints the gray value
      }
    }
}
