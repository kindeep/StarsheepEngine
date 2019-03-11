# StarsheepEngine

A game engine for choice based story games. 

The engine is designed to be portable to any Java based OS.

The engine uses MVC: Model View Controller structure. The model remains the same, the 
controller and the View can be implemented differently for different Enviornments.

# Interface: View

This should probably be an interface, implement seperately for different systems. 
Pass in the view as a parameter when initializing game possibly.

# Notes

- Game object should be initialized with GameSoundManager, View, Controller all implemented
for the enviornment.

# Questions

- Do we need to worry about naming conflitcs? as in maybe some other engine might have
a sound manager called GameSoundManager

#UML

image

![UML](notes/UML.png)