bool isPalindrome(int x){
    int long temp,rev=0,rem=0;
    temp=x;
    if(x<0)
        return 0;
    while(x>0){
        rem=x%10;
        rev=rev*10+rem;
        x/=10;
    }
    if(temp==rev)
        return 1;
    else
        return 0;

}