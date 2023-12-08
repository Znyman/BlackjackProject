# BlackjackProject

## Description
This is a simplified Blackjack application which:
1. Initializes `Card` objects that consist of a `Suit` and a `Rank` both of which are `enum`.
2. Shuffles a deck of `Card` objects.
3. Initializes a concrete `BlackjackHand` class that extends an abstract `Hand` class.
3. Deals Card objects to the `Player` and `Dealer`.
4. Determines if the `Player` got Blackjack on the initial deal.
    * If so, the program will determine if the `Dealer` also got Blackjack
        * If the `Dealer` didn't get Blackjack, then the `Player` wins.
        * If the `Dealer` also got Blackjack, then the game results in a standoff.
5. The `Player` can choose to either hit (until they bust) or stand with the cards they have.
6. Once the `Player` either stands or busts, the `Dealer` will play by the rule of 17.
    * If the `Dealer` is below 17 points, they will hit.
    * If the `Dealer` is at or above 17 points, they will stand.
7. Once the `Dealer` finishes their turn, the program will determine a winner.

## Technologies Used
The program consists of several methods, each with various return types, various private attribute declarations with setters and getters, `toString()` methods, print statements, and a Scanner.

Other simple logic, data structures, and OOP concepts included in the program were:
- `abstraction`
- `encapsulation`
- `inheritance`
- `polymorphism`
- `interfaces`
- `enum`
- `if`
- `for each`
- `while`
- `switch`
- `ArrayList`
- `casting`
- `Collections.shuffle()`