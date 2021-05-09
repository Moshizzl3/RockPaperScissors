public class Human implements Player {

  private String name;
  private UI ui = new UI();
  private int score = 0;

  public Human(String name){
    this.name = name;
  }

  public int getScore(){
    return this.score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public void addToScore (){
    this.score ++;
  }

  @Override
  public int takeTurn(){
    int playerChoice = ui.validIntInput();
    boolean keepRunning = true;

    while (keepRunning)
      if (playerChoice < 1 || playerChoice > 3){
        ui.printALine("Not a valid input, please try again");
        playerChoice = ui.validIntInput();
      }
    else {
        keepRunning = false;
      }
    return playerChoice;
  }

}
