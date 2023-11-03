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
[ ] Need update testing for current n players and rounds.

# Known Bugs found to fix.
[fixed] - reset hand cards before a new round.
[fixed] - popCard taking random 32 value get error when less then 32 card (collition by chance) in deck.
[ ] How players will play: 0, 'pato'.
[ ] Printed messgae 'Press enter to next player continue..." after las player playing shoud not be displayed.
[x] Negative bet when not more coins.

# Task Flow Queue
[x] Delete press enter to start.
[x] player auto choose randomly between hit and stand.
[x] implements n rounds in the game.
[x] implements n players.
[x] Fix count score for all players, need implements bust.
[x] Join the table, left the table.
[x] can play next round if player has enough coins.
[ ] Global asking if want to continue next round
    - if yes: continue.
    - if no: all players left the table.
