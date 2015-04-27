/*
* 
* HackerEarth Problem for finding the sum of odd elements 
* in odd row of Pyramid for given Height of the Pyramid
*
*/
#include <cstdlib>
#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
    int tc,H,ans=0;
    cin>>tc;
    while(tc-->0)
    {
       cin>>H;
       for(int i=H,k=1,j=1;i>=1;i--)
       {       
               for(j=k;j<=(i+k-1);j++)
                    if((i%2!=0)&&((j-k)==(i/2)))
                       ans+=j;    
               k=j;

       }
       cout<<ans<<endl;
       ans=0;
    }
    system("PAUSE");    
    return 0;
}
