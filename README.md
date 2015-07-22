# DCC224 Shuffle a list

[Daily code challenge 224](https://www.reddit.com/r/dailyprogrammer/comments/3e0hmh/20150720_challenge_224_easy_shuffling_a_list/)

My solution was pretty basic but I had some fun with it. I have two methods to create a "seed" to be used to order the string. The first is pretty simple, it takes the current time seconds and mods it by the amount of words. The second is similar but the number it gets is the sum of the location of the first occurance of 'e' (line by line) on random wikipedia article. This is then modded by the amount of words. This isn't a perfect solution, while the process uses another api to generate a random occurance it relies on a network call which can slow things down quite a bit.
