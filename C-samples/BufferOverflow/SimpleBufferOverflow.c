#include <stdio.h>
#include <string.h>
// Compile with  gcc SimpleBufferOverflow.c -fno-stack-protector
// Then with Apple clang version 14.0.0 (clang-1400.0.29.202), if I pass
// 1234567812345678 or any 16  alpha numeric characters as long as the 1st 8 charcters 
// matches to the next 8, you could see that Access granted 

int main()
{
  char password[8];
  char input[8];
  strncpy(password, "abcdef", 8);
  printf("Enter password:\n");
  gets(input);

  // Print addresses to make sure that passowrd and input are allocated sequentially:
  printf( "Address of input: %x \n", &input);
  printf( "Address of input+1: %x \n" , (&input)+1 );
  printf("Address of password: %x \n", &password);

  if (strncmp(password, input, 8) == 0)
    printf( "Access granted\n");
  else
      printf( "Access denied\n");

  return 0;
}
