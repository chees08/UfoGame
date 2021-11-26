# UfoGame

Naci Burak KARABULUT          Kutay Cavusoglu           Utku Berk Simsek            Bahtiyar Ali Alhas


UFO Game Logs
================================================================

Why A game ? :After some long consideration we decided to go with developing a game for this assignment since it will be a good  chance to demonstrate and to implement what we learned  during lectures and also go beyond

Why Ufo Game:It seemed like a good concept and a theme for a first attempt to make a game APK

1-) We downloaded GDX  to use its library,After some investigation we learned , libGDX is Cross-Platform Java Development framework based on OpenGL that works in every OS . Its perfect for the game we decided to build

2-) Decided to use Oreo as Android version to make it backward compatible 

3-) We decided to make Different from portrait mode , we did this in order to make user use the phone horizontal Since it will be the best position to play our game properly, we achieved id with this code : android:screenOrientation="landscape" 

4-) For in game assets and art work ,we took pixel arts and images from "OpenGameArt.Org", its a convenient website with free to use assets 

5-) we added PNG files as assets in the Asset folder , these PNG files consist of background, Meteor and UFO

6-)Thanks to  GDX we start with method , these are Create,Render and Dispose  
Create:represents Actions will be held from the very beginning of our game
Render: Represents mostly entire action , and also actions will running the entire game 
Dispose: Represents everything that ends their span

7-)We needed to learn some key points to make a game especially SPRITEBATCH
What it does; it batches all your sprites into a single draw call Each time we call draw instead of drawing to the screen it adds ours quad vertices to a buffer.Its simply the most efficient way 
Note:From this moment we made a shortcut for SpriteBatch and called it batch from batch begin to batch end , everything in between will be  grouping/batching all this data together and sending it in as Draw call(s)

8-)After adding PNG's we firstly defined our Background.png as a texture  and then used 'Draw' in render method ,then we determined the height width using :Getwidth & GetHeight    
This way we  obtain space background we started to render

9-)after we insert our background png, we started adjusting Floats , this will determine the position and size , in this part we are using library code from Gdx.getwitdh ..., it will adjust the backgrond as full size to fit for full size
we tested the emulator for the background (it worked)

10-)now its time to adjust the UFO

11-) Firstly we insert our UFO with the very same code like last time but the differences being , we divided the matrix such as x,y and also height and width, this will allow us to place The UFO according the orinal size of the device, so UFO will be at preferred position regardless to the size of the device

12-)now since we have our UFO , now we have to make it Fly ! , in order to do this , we are using "Justtouched" method , 

13-) First touch should start the game , not make the ufo fly(jump) , for this we are using if & else statement

14-)after starting the game , we we will make it fly, just like the previous code, but this time with every touch our UFO will change its position , every touch will increase the velocity value ,

15-)UFO can fly (a little :D )  but we have to also make it Fall, we have to fake the gravity , to do this we create another float as gravity  , we are adding current velocity which is 0.1 to velocity

16-)previously we noted that UFO can fly  'a little' its because it cannot yet fly more then once,to make it fly everytime we touch it has to reduce velocity by -5

17-)there is gravity, the UFO is flying, it's time to include the meteors in the game, this time it will be a little more difficult , because this time we will create more than one set, which will not be a single set of meteors, and we do it with loops with this way we get rid of long efforts.

18-)we create the textures and draw them under gameState1 so that the meteors appear after the game starts.

19-)in order for meteors to appear at different points, we add different variables to the x and y axes 

20-)we have named the meteors in the form of enemy ufo
    We used the code ''enemyX -= 10'' in this way, their position became variable on the horizontal axis
   (we tried entering different coordinates at first, but this way was much more convenient, it took a while to solve it) in this way, we created an opponent for the player.
21-)Currently, our meteor set is on a single meridian, so we are randomising its positions on the parallel in order to make it more challenging.

22-)we are preparing 4 different meteor sets for use also on widescreen devices, one of which enters a loop that will re-enter from the left side when it exits from the right side.
We make this possible with the float command, which receives enemies according to the numberofEnemies code.
(Float [] enemyX = new float [numberofenemies])

23-)we decouple the distance command so that the distance between the meteorites is not always the same.
we need to make it proportional so that there are no consecutive distances on large screens
Therefore, we create a difference of half the screen
(Distance = Gdx.graphics.getWidth()/2)

24-)we didn't define a startup for enemyx, so it's his turn
Since this is an array, we need to define it in the array, so we create a loop
As long as I is smaller than the number of enemies, we make it continue, and each time we add one to i 
(int i = 0 i<numberofenemies I++)

25-)to automatically determine the difference between each set of meteorites, we use the distance command that we used earlier in a new decode :
beel.getWidth() / 2+i* distance ;
So this is the place where I made the initialization of the loop

26-)we have initialized it, but we haven't drawn it yet, now it's his turn :
We are rewriting our for loop (int i = 0; i < numberofEnemies; i++)
In this process, we also encountered an error that it didn't recognize the code because we left the drawings out of parentheses, we immediately got into it fixed (so there is no problem yet :-) )

27-)while we were trying how the game works, we realized at this point that Y axis was not working as random , we had to make the y axis random, this point is a little long and complicated ,
We need to create a priority float array
there will be 4 competitors, so we create a 4-line enemyOffSet, now it's time to randomize them, we start with the first offset, where we will create a random number and create a y-axis with this number :
‘Enemyoffset[I] = (random.nextFloat()) *(gdx.graphics.getHeight()); ‘

28-)There are meteors and our ufo on the horizon, they are flying and floating already, now we need to figure out what will happen when they cross, we will use collision detection for this
In this, we create a ''Circle'' for our enemies and characters in a series
(Enemycircles)

29-)we have made a Circle for the opponent, lets come to our dear Alien, we are using close entry for it :
ufo Circle = new Circle ();
Enemy Circles = new Circle [Number of Enemies]

30-)There are a few lacks on circles, one of them is that they are not drawn yet, we used a ShapeRenderer to draw.
The Shape Renderer.setColor(Col.)
shapreRenderer.circle(ufoCircle.x,ufoCircle.radius)
in this way, we have drawn the circles evenly.
(yes, after these stages, a black circle is formed above our character, but we will not show it to the user)

31-)we will check it in the loop to recognize collisions, we will use an Intersector for this, we write together those who are likely to collide.
(Example:Intersector.overlaps(ufoCircle,enemycircles2[I])

32-)in order to start again at the end of the game, and either we need to add a purposeful login command that was opened when we first entered it, we complete it using this command
else if (gamestate==0)
If (Gdx.introduction, justtouched())
The same thing with gameState = 1 and 2
1 is for the first start stage 2 is the time you will use to restart

32-)its time to make the scoreboard, the way we want to track the score is by counting each time our UFO passes a set of Meteor Column 

33-)We started with creating a simple int and called it score, from beginning of the game it will be equal to =0,

34-)we need another integer that will be effective to increase the int score , we called this scoredEnemy

35-)with the way our game works, best way to calculate score is by each time Our Meteor (EnemyX < The position of our UFO on X axis, ) increase score by 1 (score++)

36-)since we have multiple enemies we want every Scored enemy to be summed and if its smaller  then total enemy set -1 increase  Scored enemy by 1 (ScoredEnemy++) , Else scored enemy will be NEUTRALISED(will be equal to 0) this way only after each enemy set passes the UFO x axis the score will be increased 

37-)we made scores equal back to 0 once game status is ==2 so it will start from 0 once new games starts

38-)Our score increases now , but we have to display it ,after some search we find best way, BitmapFont , after entering parameters such as color and scale  on create method we have to draw it , just like draw our UFO , after entering String.ValueOf(score) we put it to left bottom corner of our screen

39-)And its displays score!

40-) lASTLY BUT NOT LEAST, our game technically can be game over but we wanted to visualise it , just like previously do display our score , we made another Bitmapfont , after entering parameters , we draw 'Game over' to right under gamestatus==2


===============================================================================================
Bug Fixes and Improvements according to feedback from Teacher

*Our bird could go up infinity, we left it this way to make it easier to test our score Algorithm, after we made sure it all was working , we simply made it Bounce from Upper edge by adjusting ufoY And by making velocity 0  so it will make the bounce looking effect

*Splash screen :we wanted to make a quick splash screen right after our APK would lunch , and we made it happen quick open screen before switching to main activity ,  we created a second activity to make this Splash screen , the way it happens is really simple, right APK launches SplashScreen Activity opens first and then starts main activity by new intent, 

To edit We make changes from Manifestfolder, we change Intent folder to firstly  display the splashScreen Activity,

After we made changes, We change APK icon and Splash screen image from Res folder,

*Toast, we added Toast to splash screen activity , we learned how to make Toast from our second class, Toast.makeText , we made it last long , so toast would still be there for a little while more to be seen in after switching to main activity which initialises our game 

*lastly the Start button ; this part is complicated due one reason , GDX is simply blocked our every attempt to switch between splash screen activity , to main menu activity with button to Main activity that lunches our game , we made a button , but with button version the game simply doesn't lunches , we tried reducing activity but it didn't worked since GDX based framework makes its own method and folder , but an example with button saved as a separate branch

Hope you liked it

Thank you 









 
