#BlackJack project
This project is about creating a simple version of BlackJack game applying concepts from a java course.

# Features list to implement in.
- [optional] try to implement interfaces.
- Before start the game choose how many players will play the game, preferably [1-3] players.
- set global config for round wait in miliseconds.

# Ideas to improve.
- In the first Table view, only show the cards (hidden and not hidden) from dealer, for table view after each player plays, show those cards in table view.

# Testing
- set a random choose hit/stand, over rounds. (add config to change it faster).

# Known Bugs found to fix.
[fixed] - reset hand cards before a new round.
[fixed] - popCard taking random 32 value get error when less then 32 card (collition by chance) in deck.
[ ] How players will play: 0, 'pato'.
[ ] Printed messgae 'Press enter to next player continue..." after las player playing shoud not be displayed.

# Task Flow Queue
[x] Delete press enter to start.
[x] player auto choose randomly between hit and stand.
[x] implements n rounds in the game.
[ ] implements n players.
    [ ] Fix count score for all players, need implements bust.
