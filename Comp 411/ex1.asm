

.data 0x0
	string: .space 4
	newLine: .asciiz "\n"
	outHeaderString: .asciiz "P2\n"
.text 0x3000

main:
    #Accounting for the "Magic Number"
    ori $a0, $zero, 0
    ori $v0, $zero, 8 		#System call to read string p
    syscall
    
    ori $v0, $0, 5 		#System call to read integer
    syscall
    
    #Inputs for columns, rows, and maxVal
    
    #Read in the number of columns
    ori $v0, $0, 5 		#System call to read in integer
    syscall
    addiu $t1, $v0, 0 		#Store the number of columns in register t1
    
    #Read in the number of rows
    ori $v0, $0, 5		 #System call to read in integer
    syscall
    addiu $t2, $v0, 0		 #Store the number of rows in register t2
    
    #Read in the maxVal
    ori $v0, $0, 5 		#System call to read in integer
    syscall
    addiu $t3, $v0, 0		 #Store the maxval in register t3
    #Now register t1 has the number of columns, t2 has the number of rows, and t3 has the maxVal
    
    #Print out Magic Char/Number,columns, rows, max value
    
    #print out magic char/number
    li $v0, 4				#Print out P2
    la $a0, outHeaderString
    syscall
    
    #print columns
    addiu $a0, $t1, 0
    jal print
    
    #print rows
    addiu $a0, $t2, 0
    jal print
    
    #print max value
    addiu $a0, $0, 255		#Print 255
    jal print
    
    move $t4, $0			#counter... t4 is now the loop index
    
    mulo $t5, $t3, 100			#multiply maxVal by 100 put it in register 5 to make it easier to do division later
    mulo $t6 $t1, $t2 			#Multiply rows and columns... number of pixels
    
#loop
	b loopcheck
loop:
	#Read in red value
	li $v0, 5				#System call code 5 to read in r, red is in s0
	syscall
	move $s0, $v0
	#Read in green value
	li $v0, 5				#System call code 5 to read in g, green is in s1
	syscall
	move $s1, $v0
	#Read in blue value
	li $v0, 5				#System call code 5 to read in b, blue is in s2
	syscall
	move $s2, $v0
	
	#Multiplication needed to calculate gray value
	mulo $s0, $s0 ,30
	mulo $s1, $s1 ,59
	mulo $s2, $s2 ,11
	
	#Summing up the numbers
	add $s3, $s0, $s1
	add $s3, $s3, $s2
	
	#Multiply by 255
	mulo $s3, $s3, 255
	
	#Divide by 100*ppmmax
	div $s3, $s3, $t5
	
	#print the gray value
	move $a0, $s3
	jal print
	
	addi $t4, $t4, 1
loopcheck:
	bne $t6, $t4, loop
	
exit:

	ori $v0, $0, 10				#System call code 10 for exit
	syscall					#exit the program
	
print:	
	#a0 contains int, this method prints the int and a new line
	li $v0, 1
	syscall
	
	li $v0, 4
	la $a0, newLine
	syscall
	
	jr $ra
