# fizzbuzz
A Spring Boot implementation to provide a RESTful implementation of the classic FizzBuzz programming test.

For a range of contiguous positive numbers, output should be returned for each number containing :-
* number
* 'fizz' for numbers that are multiples of 3
* 'buzz' for numbers that are multiples of 5
* 'fizzbuzz' for numbers that are multiples of 15

A report will also be generated containing counts of the following values found within the generated output :-
* integer 
* fizz
* buzz
* fizzbuzz

The API is invoked as follows :-

http://<<url:port>>/fizzbuzz/v1?start=X&end=Y

An example :-

Range 1 to 20 should provide the following JSON output with a 200 OK status code :-

{"range" : "1 to 20",<br/>
 "result" : "1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16, 17, fizz, 19, buzz",<br/>
 "fizz" : "5",<br/>
 "buzz" : "3",<br/>
 "fizzbuzz" : "1",<br/>
 "integer" : "11"}

Error messages should be returned as JSON objects to the client, with a 400 Bad Request status, for example :-

{"error" : "Both start and end values need to be provided" }<br/>
{"error" : "The start number must be less than the end number" }<br/>
{"error" : "The start and end values must both be positive values and greater than zero" }
