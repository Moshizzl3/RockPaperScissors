import java.util.ArrayList;

public class GameArena {

  private UI ui = new UI();

  private Human human;
  private Computer computer;


  public void createArena() {
    addHumanPlayer();
    renderPlayerOptions();
  }

  public void loadArena(){

    createArena();
    playGame();
  }

  public void addHumanPlayer() {
    this.human = new Human(ui.promtUserForName());
    this.computer = new Computer();
  }

  public void renderPlayerOptions() {

    ui.startGameText();
    String menuHeader = "Game Options";
    String menuText = "Please enter Option:";
    ArrayList<String> menuOptions = new ArrayList<>();
    menuOptions.add("Rock");
    menuOptions.add("Paper");
    menuOptions.add("Scissors");

    Menu mainMenu = new Menu(menuHeader, menuText, menuOptions);

    ui.printMenu(mainMenu.getMENU_HEADER(),mainMenu.getMenuOptions());

  }

  public void gameRound() {

    int humanChoice = human.takeTurn();
    ui.printPlayerChoice(humanChoice);
    int computerChoice = computer.takeTurn();
    ui.printComputerChoice(computerChoice);

    String humanChoiceConverted = convertIntInput(humanChoice);
    String computerChoiceConverted = convertIntInput(computerChoice);

    if (humanChoiceConverted.equals(computerChoiceConverted)) {
      ui.printALine("It's a Tie!");
    } else if (humanChoiceConverted.equals("Rock")) {
      if (computerChoiceConverted.equals("Scissors")) {
        ui.printALine("Rock beats Scissors! You have won!");
        human.addToScore();
      } else if (computerChoiceConverted.equals("Paper")) {
        ui.printALine("Rock doesn't beat Paper, you have lost");
        computer.addToScore();
      }
    } else if (humanChoiceConverted.equals("Scissors")) {
      if (computerChoiceConverted.equals("Paper")) {
        ui.printALine("Scissors beats Paper! You have won!");
        human.addToScore();
      } else if (computerChoiceConverted.equals("Rock")) {
        ui.printALine("Scissors doesn't beat Rock, you have lost");
        computer.addToScore();
      }
    } else if (humanChoiceConverted.equals("Paper")) {
      if (computerChoiceConverted.equals("Rock")) {
        ui.printALine("Paper beats Rock! You have won!");
        human.addToScore();
      } else if (computerChoiceConverted.equals("Scissors")) {
        ui.printALine("Paper doesn't beat Scissors, you have lost");
        computer.addToScore();
      }
    }
  }


  public String convertIntInput(int choice) {
    String choiceText = OutCome.valueOf(choice).toString().toLowerCase();
    choiceText = choiceText.substring(0, 1).toUpperCase() + choiceText.substring(1);
    return choiceText;
  }

  public void createMatch() {

    int amountOfRounds = 3;

    for (int i = 0; i < amountOfRounds; i++) {
      ui.printALine("Round: " + (i + 1));
      ui.printInLine("Please enter your option: ");
      gameRound();
    }
  }


  public void playGame() {

    boolean keepPlaying = true;

    while (keepPlaying) {
      createMatch();
      ui.printScore(human.getScore(), computer.getScore());
      findWinner();
      String userInput = ui.printPlayAgain();

      switch (userInput) {
        case "Y":
          ui.printALine("Heeeeere we go again");
          resetScore();
          break;
        case "N":
          keepPlaying = false;
          ui.printALine("Thanks for playing!");
          resetScore();
          break;
        default:
          ui.printALine("Not a valid input, please try again!");
          break;
      }
    }

  }

  public void resetScore(){
    human.setScore(0);
    computer.setScore(0);
  }


  public void findWinner(){
    if (computer.getScore() == human.getScore()){
      ui.printALine("It's a tie!");
    }else if (computer.getScore() > human.getScore()){
      ui.printALine("The winner is the computer");
    }else if (computer.getScore()< human.getScore()){
      ui.printALine("You have won!");
    }
  }
}

