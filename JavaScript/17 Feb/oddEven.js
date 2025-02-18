function evenOdd(n){
    
    ans=0  
    if(n>0)
    {
        lastNumber = n % 10
        firstNumber = Math.floor(n/10)
        ans = firstNumber + lastNumber
    }

    if (ans % 2 == 0){
        console.log("Number is even")
    }
    else{
        console.log(" number is odd")
    }

} 

evenOdd(22)