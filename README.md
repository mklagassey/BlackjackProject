# Blackjack

## ---Overview---
Your standard game of 21 where the player is dealt 2 cards, face up, while the dealer gets 2 also, one face down. The player then decides whether to ask for more cards, one at a time until they are satisfied with their hand. Finally, the dealer keeps taking a card until their hand is worth at least 17, at which point, if no one has busted, hand scores are compared and the player either wins, loses or draws.

### Technology used:
* Java
* Enums
* Abstract classes
* Loops
* Conditionals

### Topics covered:
* OOP:
  * Encapsulation
  * Abstraction
  * Inheritance
* Debugging
* Collections
  * Lists

### Lessons learned:
This was a very interesting project as I've done the same thing with [Ruby](https://github.com/mklagassey/Launch-School/tree/master/RB101/lesson_6) but didn't use OOP. I found that although the basic game loops and logic were the same (because it's the same game), separating the concerns was the real challenge. Whereas before I had simply kept everything in one, long linear file, I now had to decide not just what methods were just control flow and which ones were unique to an object, but *which* objects should they be in? After many iterations and a few dead ends, I started to really see the advantages of OOP. In my Ruby project, I'd had to comb through my code when I changed almost anthing, looking for broken references. But once I got the inheritance issues worked out with my cards, hands and players, changing one of their functions was relatively easy and more importantly, didn't break the rest of the code (usually)!


### To Do
1) Add the soft ace, really gotta get on that (but luckily, it will be much easier than in my last project since it will only require modifying how the hand calculates its own value. rather than every single check in a monolithic code)
2) Add betting, complete with a wallet
3) Add memory for things like names and win/loss record using the I/O writer to a player stats file
