.data
	strings: .space 32
	newline: .asciiz "\n"
.text
main:
	add $t1, $0, $0		#offsetting for when we accsess index of array
	la $t7, newline
	li $v0, 8
	la $a0, strings
	li $a1, 32
	
	syscall			#read string
	lw $a0, strings		#store string in a0 to pass in
	j a_to_i
a_to_i:	
	add $s0, $a0, $0
	lb $s0, ($t1)
	add $v0, $s1, $0	#store value into v0 to return
	
	#branches to print if the value of register s0 is greater than 48 or less than 59
	blt $s0, 48, print	
	bgt $s0, 59, print
	
	#multiplies value by 10
	mul $s1, $s1, 10
	#removes the '0' which is 48
	addi $s0, $s0, -48
	#adds the new character value into s1
	add $s1, $s1, $s0	
	#add 1 into the index
	addi $t1, $t1, 1
	
	j a_to_i
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
	li $v0, 10
	syscall
	
	
