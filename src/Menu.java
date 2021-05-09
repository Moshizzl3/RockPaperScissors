import java.util.ArrayList;

public class Menu {

  private final String MENU_HEADER;
  private String MENU_TEXT;
  private ArrayList<String> menuOptions = new ArrayList<>();

  public Menu(String menuHeader, String menutext, ArrayList<String> menuOptions){
    this.MENU_HEADER = menuHeader;
    this.MENU_TEXT = menutext;
    this.menuOptions = menuOptions;
  }

  public String getMENU_HEADER(){
    return this.MENU_HEADER;
  }

  public String getMENU_TEXT(){
    return this.MENU_TEXT;
  }

  public ArrayList<String> getMenuOptions(){
    return this.menuOptions;
  }

}
