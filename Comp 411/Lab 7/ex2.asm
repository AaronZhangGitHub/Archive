.data
	strings: .space 32
	newline: .asciiz "\n"
.text
main:
	add $t1, $0, $0		#offsetting for when we acsess index of array
	add $t4, $0, $0		#register t4 stores the asc value for when to exit
	add $t2, $0, 1 		#out 1 into register t2
	la $t7, newline
	li $v0, 8
	la $a0, strings
	li $a1, 32
	syscall			#read string
	lw $a0, strings		#store string in a0 to pass in
	j a_to_i
fJump:
	add $a0, $v0, 0
	add $v0, $0, 1
	j factorial
a_to_i:	
	add $s0, $a0, $0
	lb $s0, ($t1)
	add $v0, $s1, $0	#store value in v0 to return
	add $t4, $s1, $0
	blt $s0, 48, fJump
	bgt $s0, 59, fJump
		
	#multiplies value by 10
	mul $s1, $s1, 10
	#removes the '0' which is 48
	addi $s0, $s0, -48
	#adds the new character value into s1
	add $s1, $s1, $s0	
	#add 1 into the index
	addi $t1, $t1, 1
	
	j a_to_i
factorial:
	move $s0, $a0		#n
	addi $a0, $a0, -1	#n-1 is in register a0
	blez $s0, exit		#if s0 is 0 than branch to factZero
	
	mul $v0, $v0, $s0	#multiplies 
	beq $s0, $t2, print
	
	j factorial		#jumps back if the blez condition is not met
factZero:
print:
	add $a0, $v0, $0
	li $v0, 1
	syscall		#System call for printing integer	
	add $s1, $0, $0
	add $t1, $0, $0
	beq $a0, $0, exit
	li $v0, 4
	la $a0, newline
	syscall			#print new line
	j main
exit:
	#print the 0
	li  $v0, 1           # service 1 is print integer
    	addi $a0, $zero, 1  # load desired value into argument register $a0, using pseudo-op
    	syscall
    	
    	#Exit
	li $v0, 10
	syscall
	
	
