#Aaron Zhang
#Lab Mini Project
#ex1.asm

.data 0x0
	newLine:	.asciiz "\n"
	moveDisk:	.asciiz "Move disk "
	fromPeg:	.asciiz " from Peg "
	toPeg:		.asciiz " to Peg "
	
.text 0x3000

main:

	li $v0, 5	#System call to scan in number of disks
	syscall
	
	move $a0, $v0	#Disk number 
	
	li $a1, 1	#a1 is peg 1
	li $a2, 2	#a2 is peg 2
	li $a3, 3	#a3 is peg 3
	
	jal Hanoi	#jump and link to he hanoi program to move the disks
	
	j finish
	
Hanoi:

	subu $sp, $sp, 20
	sw $ra, ($sp)
	sw $a0, 4($sp)
	sw $a1, 8($sp)
	sw $a2, 12($sp)
	sw $a3, 16($sp)
	
	li $t0,1
	beq $a0,$t0, oneDisk
	
	subu $a0, $a0, 1
	move $t0, $a2
	move $a2, $a3
	move $a3, $t0
	
	jal Hanoi
	
	addiu $a0, $a0, 1
	move $t0, $a0
	
	li $v0, 4
	la $a0, moveDisk #print
	syscall
	
	li $v0, 1
	move $a0, $t0
	syscall
	
	li $v0, 4
	la $a0, fromPeg #print
	syscall
	
	li $v0, 1
	move $a0, $a1
	syscall
	
	li $v0, 4
	la $a0, toPeg #print
	syscall
	
	li $v0, 1
	move $a0, $a2
	syscall
	
	li $v0, 4
	la $a0, newLine #print
	syscall
	
	
	move $a0, $t0
	subu $a0, $a0, 1
	move $t0, $a2
	move $a2, $a1
	move $a1, $a3
	move $a3, $t0
	
	jal Hanoi
	
	lw $ra, ($sp)
	lw $a0, 4($sp)
	lw $a1, 8($sp)
	lw $a2, 12($sp)
	lw $a3, 16($sp)
	addu $sp, $sp, 20
	
	jr $ra
	
	
oneDisk:
	move $t0, $a0
	
	li $v0, 4
	la $a0, moveDisk
	syscall
	
	li $v0, 1
	move $a0, $t0
	syscall
	
	li $v0, 4
	la $a0, fromPeg
	syscall
	
	li $v0, 1
	move $a0, $a1
	syscall
	
	li $v0, 4
	la $a0, toPeg
	syscall
	
	li $v0, 1
	move $a0, $a3
	syscall
	
	li $v0, 4
	la $a0, newLine
	syscall
	
	lw $ra, ($sp)
	lw $a0, 4($sp)
	lw $a1, 8($sp)
	
	
	lw $a2, 12($sp)
	lw $a3, 16($sp)
	addu $sp, $sp, 20
	
	jr $ra
	
finish:
	li $v0, 10
	syscall
	
	
