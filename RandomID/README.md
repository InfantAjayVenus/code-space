
# Random ID

A set of simple fast random ID algorithms.

## Documentation

1. `getRandomID`

A simple date based random ID generator.
Encodes each date and time component to Base64 utilizing a custom Base64 encoder.


2. `getShortRandomID`

An ID generator similar to `getRandomId`, but generates a shorter ID.
Encodes the date and time components as a whole, using the custom Base64 encoder.


