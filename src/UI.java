import java.util.ArrayList;
import java.util.Scanner;

public class UI {

  private Scanner userInput = new Scanner(System.in);

  public void printMainMenu(String menuHeader, String menuLeadText, ArrayList<String> menuOptions){
    System.out.println(menuHeader);
    printOptions(menuOptions);
    System.out.println("0. Exit");
    System.out.print(menuLeadText + " ");


  }

  public void printMenu(String menuHeader, ArrayList<String> menuOptions){
    System.out.println(menuHeader);
    printOptions(menuOptions);
    System.out.println();

  }

  public void printOptions(ArrayList<String> menuOptions){
    for(int i = 0; i <menuOptions.size(); i++){
      System.out.println((i+1) + ". " + menuOptions.get(i));
    }
  }

  public int validIntInput(){

    while (!userInput.hasNextInt()){
      System.out.println("Not a valid input, please try again");
      userInput.nextLine();
    }

    int temp = userInput.nextInt();
    userInput.nextLine();

    return temp;

  }

  public String promtUserForName(){
    System.out.print("Please enter your name: ");
    return userInput.nextLine();
  }

  public void startGameText(){
    System.out.println();
    System.out.println("Welcome to the legendary arena!");
  }

  public void printPlayerChoice (int choice) {
    String choiceText = OutCome.valueOf(choice).toString().toLowerCase();
    choiceText = choiceText.substring(0,1).toUpperCase() + choiceText.substring(1);
    System.out.println("You have selected: " + choiceText);
  }
  public void printComputerChoice (int choice) {
    String choiceText = OutCome.valueOf(choice).toString().toLowerCase();
    choiceText = choiceText.substring(0,1).toUpperCase() + choiceText.substring(1);
    System.out.println("Computer have selected: " + choiceText);
  }

  public void printALine(String line){
    System.out.println(line + " ");
  }
  public void printInLine(String line){
    System.out.print(line + " ");
  }

  public String printPlayAgain(){
    System.out.print("Do you want to play again, Y/N?");
    return userInput.nextLine().toUpperCase();

  }

  public void printWinner(String name){
    System.out.println("The Winner is: " + name);
  }

  public void printScore(int humanScore, int computerScore){
    System.out.println("Player: " + humanScore);
    System.out.println("Computer: " + computerScore);
  }
}
