#include <stdio.h>
#include <conio.h>
void func1(char* c);
void func2(char* c);
void func3(char* c);
int main()
{
    char str[100],* ptr;
    int i=0;
    scanf("%s",str);
    ptr=str;
    void (*funcPtr[3])(char*);
    funcPtr[0]=func1;
    funcPtr[1]=func2;
    funcPtr[2]=func3;
    /* void (*funcPtr)(char*);
       funcPtr=func1;
       (*funcPtr)(str);*/
  while(i<3)
    (*funcPtr[i++])(str);
  getch();
  return 0;
}
void func1(char *c)
{
    int i=0;
    while(*(c+i))
            printf("%c",*(c+(i++)));
    printf("\n");      
}
void func2(char *c)
{
    int i=0;
    while(c[i])
      printf("%c",c[i++]);
    printf("\n");
}

void func3(char *c)
{    
     while(*c!='\0') // While(*ptr) is also fine bcoz ASCII value of '\0' is 0
    {
       printf("%c",*c);
       c++;
    }
    printf("\n"); 
}

