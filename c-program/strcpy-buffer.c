#include <stdio.h>
#include <string.h>
int main() {
 char buffer[4];
 char *tmp="qqqqqqqqqqqqqqqqqwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwqqqqqqq"; // this should be a pointer
 char *r;
 r=strcpy(buffer,tmp);
 return 0;
 }