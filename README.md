# fizzbuzz
A Spring Boot implementation to provide a RESTful implementation of the classic FizzBuzz programming test.

For a range of contiguous positive numbers, output should be returned for each number containing :-
* number
* 'fizz' for numbers that are multiples of 3
* 'buzz' for numbers that are multiples of 5
* 'fizzbuzz' for numbers that are multiples of 15

A report will also be generated containing counts of the following values found within the generated output :-
* number
* fizz
* buzz
* fizzbuzz

An example :-

Range 1 to 20 should provide the following JSON output :-

{"range" : "1 2 3 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz",<br/>
 "fizz" : "4",<br/>
 "buzz" : "3",<br/>
 "fizzbuzz" : "1",<br/>
 "integer" : "12"}

Error messages should be returned as JSON objects to the client, for example :-

{"error" : "Both start and end values need to be provided" }<br/>
{"error" : "The start number must be less than the end number" }<br/>
{"error" : "The start and end values must both be positive values and greater than zero" }
