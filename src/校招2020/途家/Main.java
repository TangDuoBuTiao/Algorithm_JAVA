package 校招2020.途家;

import java.util.Scanner;

public class Main {
    static int maxn = 1000005;
    static char[] num = new char[maxn];
    static char[] result = new char[maxn];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int m = sc.nextInt();
        char[] c = str.toCharArray();

    }


    /*
    #include<stdio.h>
#include<string.h>
#include<iostream>
using namespace std;
int main()
{
	int x,n,b,i,j;
	char a[1000];
	cin>>n;
	while(n--)
	{
		scanf("%s %d",a,&b);
		x=strlen(a);
		int t=x-b;
		int m=0;
		int max;
		while(t--)//需要挑出x-b位数，第一次从开始到b挑出最大的数并记录下最大数的位置，第二次从上一次最大数位置的下一位开始到b+1位挑出最大数。。依次类推直到t==0时
		{
			max=0;
			for(i=m;i<=b;i++)
			{
				if(a[i]-'0'>max)
				{
					max=a[i]-'0';
					m=i+1;
				}
			}
			cout<<max;
			b++;
		}
		cout<<endl;
	}
	return 0;
}



const int maxn=100000+5;
char num[maxn];
char result[maxn];
void solve(char num[],int leave_num,int count)
{
    int len,Max;
    if(leave_num==0)
    {
        result[count]='\0';
        return ;
    }
    else
    {
        len=strlen(num);
        Max=0;
        for(int i=0;i<len-leave_num+1;i++)
            if(num[i]>num[Max])
                Max=i;
        result[count++]=num[Max];
        solve(num+Max+1,leave_num-1,count);
    }
}
int main()
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int number;
        int len;
        scanf("%s %d",&num,&number);
        len=strlen(num);
        solve(num,len-number,0);
        printf("%s\n",result);
    }
    return 0;
}
     */
}
