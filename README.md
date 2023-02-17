# GlideGame

Alpha branch: here is what I want to get done for the first stage of testing!

- [ ] Working speed boosts
  - [ ] Particle indications
  - [ ] Make sure the speeds are correct; correspond to OG game
  - [ ] Figure out which ones are yellow boosts and orange boosts, and adjust correspondingly?
- [ ] Working alt boosts
  - [ ] Particle indications
- [ ] Checkpoints (make sure the beacons are powered) (make sure that the range is big enough!)
- [ ] At least the OG three maps working
- [x] Instant death when touching the ground, NOT THE WALLS!!
- [ ] Time attack gamemode
  - [x] Stopwatch in actionbar
  - [ ] Timer stop when player crosses the finish line
    - [ ] Try and calculate a more accurate time? (eg. save the timestamp the game starts and subtract it from the time a player crosses the finish line just in case people finish really close together; the displayed timer is only accurate down to 100ms because of lag reasons)
  - [ ] Speed...somewhere, if I can
  - [ ] Certain amount of time for others to finish after one player has
- [ ] Correctly implemented solo mode

- Challenge: try and implement correct object logic for the game so we can have multiple games running at one time? (basically, every time you start a game, save the object in a var so you can modify it later--associate a Game object with a world)

#

- [ ] Extra credit if I can implement score attack! (idk we have the rings for that though)
