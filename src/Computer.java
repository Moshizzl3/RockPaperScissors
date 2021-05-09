import java.util.Random;

public class Computer implements Player {

  private String name = "Computer";
  private int score = 0;

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
    Random random = new Random();
    int computerChoice = random.nextInt(3) + 1;
    return  computerChoice;
  }
}
