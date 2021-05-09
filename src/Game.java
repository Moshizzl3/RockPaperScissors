import java.util.ArrayList;

public class Game {

  private UI uI = new UI();

  private GameArena gameArena = new GameArena();

  public void playGame(){
    getUserChoice();
  }

  public void renderMainMenu(){

    String menuHeader = "Main Menu";
    String menuText = "Please enter Option:";
    ArrayList<String> menuOptions = new ArrayList<>();
    menuOptions.add("Play game");

    Menu mainMenu = new Menu(menuHeader,menuText,menuOptions);

    uI.printMainMenu(mainMenu.getMENU_HEADER(), mainMenu.getMENU_TEXT(), mainMenu.getMenuOptions());

  }

  public void getUserChoice() {

    Boolean keepRunning = true;


    while (keepRunning) {

      renderMainMenu();
      int userInput = uI.validIntInput();

      switch (userInput) {
        case 1:
          gameArena.loadArena();
          break;
        case 0:
          uI.printALine("Thanks for playing");
          keepRunning = false;
          break;
        default:
          uI.printALine("Not a valid input, please try again!");
          break;
      }

    }

  }

}
