import java.util.HashMap;
import java.util.Map;

public enum OutCome {
  ROCK(1),
  PAPER(2),
  SCISSORS(3);

  private int outComeNo;
  private static Map map = new HashMap();

   OutCome(int outComeNo){
    this.outComeNo = outComeNo;
  }

  static {
    for (OutCome outcome: OutCome.values()) {
      map.put(outcome.outComeNo, outcome);
    }
  }

  public static OutCome valueOf(int outComeNo){
    return (OutCome) map.get(outComeNo);
  }
}
