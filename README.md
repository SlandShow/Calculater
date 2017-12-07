# Calculater
Android calculator, based on postfix converter.


This calculater use postfix notation to calculate all stuff.
For example, we have infix notation: `12 - 5 * 2`

First of all, we convert this infix notation to postfix: `12 5 2 * -`

(Use class `PostfixConverter` to convert infix notation.)

Then calculate this postfix notation using class `PostfixCalculator`.



### Example:
```   JAVA 
// Convert to postfix
PostfixConverter converter = new PostfixConverter(new Scanner(System.in).nextLine());
System.out.println("Postfix notation of current regular: " + converter.getPostfix());
// Calculate
PostfixCalculator calculator = new PostfixCalculator(converter.getPostfix());
System.out.println("Result is " + calculator.getResult());
```          

If we already have user infix input, we can convert it too:
``` JAVA
String input = "10 + 4 * 2";
PostfixConverter converter = new PostfixConverter(input);
converter.getPostfix(); // Return string "10 4 2 * +"
```

Or we just can calculate postfix notation:
``` JAVA
String postfix = "10 4 2 * +";
PostfixCalculater calculater = new PostfixCalculater(postfix);
calculater.getResult(); // Return number 18
```
