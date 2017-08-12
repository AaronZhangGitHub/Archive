# Below is the expected output.
# 
# Converting pixels to grayscale:
# 0
# 1
# 2
# 34
# 5
# 67
# 89
# Finished.
# -- program is finished running --
#---------------------------------

.data 0x0
	startString:	.asciiz	"Converting pixels to grayscale:\n"
	finishString:	.asciiz	"Finished."
	newline:	.asciiz	"\n"
	pixels:		.word 	0x00010000,	0x010101,	0x6,		0x3333, 
				0x030c,		0x700853,	0x294999,	-1

.text 0x3000

main:
	ori $v0, $0, 4				#System call code 4 for printing a string
	ori $a0, $0, 0x0   	 		#address of startString is in $a0
	syscall						#print the string


	la $t0, pixels #gives register t0 the address of pixels
	
loop:	lw $t4, 0($t0) 
	addi $t7, $0, -1 #Puts the value of -1 into register t7
	beq $t4, $t7, exit #compares register t4 and t7, if they are equal then exit
	
	andi $t1, $t4, 0xff #Blue
	srl $t4, $t4 , 8 #Shifts 8 left so the green is the least sig
	andi $t2, $t4, 0xff #Green, done by masking
	srl $t4, $t4 , 8 #Shifts 8 left so the red is the least sig
	andi $t3, $t4, 0xff #Red, done by masking
	
	
	add $t5, $t1, $t2 
	add $t5, $t5, $t3 #$t5 now holds t1+t2+t3
	
	addi $t6, $0, 3 #Creates a number 3
	divu $t5, $t6 #Divide by 3
	mflo $s0
	mfhi $s1
	
	li $v0, 1
	add $a0, $s0 ,$zero 
	syscall 
	
	la $a0, newline
	
	ori $v0, $0, 4			
	ori $a0, $0, 31		
	syscall		
	
	addi $t0, $t0, 4 #adds 4 into register t0, making use of "shifting"
	beq $t7, $t7, loop #basically a loop while true statement
	
	

exit:

	ori $v0, $0, 4				# System call code 4 for printing a string
	ori $a0, $0, 33			# address of finishString is in $a0; we computed this
								# simply by counting the number of chars in startString,
								# including the \n and the terminating \0

	syscall						#print the string

	ori $v0, $0, 10				#System call code 10 for exit
	syscall						#exit the program
