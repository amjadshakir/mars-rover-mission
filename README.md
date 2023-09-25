# Mars Rover Mission

## How to run the application
The application is dependent on java 17, maven 3 and intellij. PLease install these as a pre-requisite.
Clone the repository locally using the following command.
`git clone git@github.com:amjadshakir/mars-rover-mission.git`

Open the repo using intellij IDE.
Right-click the MarsRoverMissionApp.java and select run the main() method.   

## Key features of the application
The input is taken via console app.
The program will prompt to enter valid value for the maximum x coordinate of the plateau.
The program will prompt to enter valid value for the maximum y coordinate of the plateau.
If the plateau's max x coordinate is negative integer or zero or non integer value, 
the program will prompting for valid input until user gets it right.
If the plateau's max y coordinate is negative integer or zero or non integer value, 
the program will prompting for valid input until user gets it right.

The program will prompt to enter valid value for the x coordinate of the rover.
The program will prompt to enter valid value for the y coordinate of the rover.
If the rover's x coordinate is negative integer or non integer value, 
the program will prompt for valid input until user gets it right.
If the rover's y coordinate is negative integer or non integer value, 
the program will prompt for valid input until user gets it right.

The program will prompt to enter valid value for the direction of the rover.
If the rover's direction is not N or S or W or E or n or s or w or e, 
the program will prompt for valid input until user gets it right.

The program will prompt to enter valid string for the rover movement rule.
If the movement rules contains any other value other than L or M or R or l or m or r one or more times , 
the program will prompt for valid input until user gets it right.

During the rover movement if the rover either hits the boundary or any obstacles, 
the program will print out a message that particular action will be skipped and 
the program will move to the next movement.
The program will print out the final position of the rover and the program will prompt the user to continue or exit. 
If the user chooses to exit, the program will terminate. 
Else the user can continue to deploy another rover on the plateau.  


## The assumptions made for the application
The plateau is rectangular. The lowest coordinates of the plateau is (0,0)

## The approach used for the application
 The user input is taken via a console application

## Future thoughts
Rover can use special cameras and robot arms for collecting samples
 
