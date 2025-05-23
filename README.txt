Authors: Raffi Poghosyan, Aida Kirakosyan, Mari Minasyan.
2025, American University of Armenia

Monopoly Game

How to run:
For simplicity, you can create a new project in your IDE and add the source code, along with the rest of the provided files to that new project (otherwise you will need to specify the root directory as CLASSPATH). In the class Board specify the path of the data.txt file. The board configuration file, stored in data.txt, must be located at the root directory, e.g., where the directory "out" is placed (it becomes the classpath when the program is run). If the project includes UI resources (such as a game logo), they should also be placed at the same root level to be accessible during runtime. You can overwrite the runtime parameters in main() by uncommenting the indicated line. Doing so results in permanent command-line interface (CLI) launch. Otherwise, runtime arguments passed to main() will determine whether the program is launched in UI or CLI mode.

Changelog:
Player now supports building houses and hotels on owned properties and includes logic to manage "Get Out of Jail Free" card. The Player class also includes new helper methods such as want() and doneWhatWanted() for extended interaction in trades. Game logic has been updated to support rent calculations, property trading, and building mechanics. Dice rolls now support doubles and penalty rules (e.g., going to jail on two consecutive doubles). Game.rollDiceAction() centralizes the player's turn logic and integrates jail handling. Added Game.trade() and Game.executeTrade() for property exchanges. The Board class loads square data from an external file and supports property lookup by name or color group. ChanceCard effects are randomized and support various actions such as collecting money, paying fees, moving, or going to jail. Chance cards shuffled at the beginning of the game. Console interface allows text-based gameplay including options to buy, build, sell, and trade. 

Resources used:
https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
https://www.codejava.net/java-core/the-java-language/java-8-lambda-listener-example
