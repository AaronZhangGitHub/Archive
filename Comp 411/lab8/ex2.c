#include <stdio.h>
#include <string.h>
void bedtimestory(char words[20][15], int current, int number);

int main(){
	char names[20][15];
	int num;
	
	for (num=0; num<20; num++){
		fgets(names[num], 15, stdin);
		names[num][strlen(names[num])-1] = '\0'; 
		if (!strcmp(names[num], "END")){
			break;
		}
	}
	bedtimestory(names, 0, num);
}

void bedtimestory(char words[20][15], int current, int number){
	int j;
	for (j = 0; j < current; j++){
		printf("  ");
	}
	if (current == 0) {
		printf("A %s couldn't sleep, so her mother told a story about a little %s,\n", words[current], words[current+1]);
		bedtimestory(words, current+1, number);
		printf("... and then the %s fell asleep.\n", words[0]);
		return;
	}
	else if (current < number-1){
		printf("who couldn't sleep, so the %s's mother told a story about a little %s,\n", words[current], words[current+1]);
		bedtimestory(words, current+1, number);
	}
	else {
		printf("... who fell asleep.\n");
		return;
	}
	for (j = 0; j < current; j++){
		printf("  ");
	}
	
	printf("... and then the little %s fell asleep;\n", words[current]);
}

