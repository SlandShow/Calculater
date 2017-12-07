# Calculater
Android calculator, based on postfix converter.


This calculater use postfix notation to calculate all stuff.
For example, we have infix notation: `12 - 5 * 2`

First of all, we convert this infix notation to postfix: `12 5 2 * -`

(Use class `PostfixConverter` to convert infiz notation.)

Then calculate this postfix notation using class `PostfixCalculator`.



Example:
```    
// Convert to postfix
PostfixConverter converter = new PostfixConverter(new Scanner(System.in).nextLine());
System.out.println("Postfix notation of current regular: " + converter.getPostfix());
// Calculate
PostfixCalculator calculator = new PostfixCalculator(converter.getPostfix());
System.out.println("Result is " + calculator.getResult());
```          
