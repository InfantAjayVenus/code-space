# Euclid's Algorithm for GCD
>The Euclid's algorithm (or Euclidean Algorithm) is a method for efficiently finding the greatest common divisor (GCD) of two numbers. The Euclidean algorithm is one of the oldest algorithms in common use. It appears in Euclid's Elements (c. 300 BC).

The GCD of two integers X and Y is the largest integer that divides both of X and Y (without leaving a remainder). Greatest Common Divisor is, also, known as greatest common factor (gcf), highest common factor (hcf), greatest common measure (gcm) and highest common divisor.

## Key Idea
 Euclidean algorithm is based on the principle that the greatest common divisor of two numbers does not change if the larger number is replaced by its difference with the smaller number.

>Example: GCD(20, 15) = GCD(15, 10) = 5

## Algorithm
The Euclidean Algorithm for calculating GCD of two numbers A and B can be given as follows:

    If A=0 then GCD(A, B)=B since the Greatest Common Divisor of 0 and B is B.

    If B=0 then GCD(a,b)=a since the Greates Common Divisor of 0 and a is a.

    Let R be the remainder of dividing A by B assuming A > B. (R = A % B)

    Find GCD( B, R ) because GCD( A, B ) = GCD( B, R ). Use the above steps again.
