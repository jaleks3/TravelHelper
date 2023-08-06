/**
 *
 *  @author Aleksandrowicz Jakub S24592
 *
 */

package zad1;


public class Main {
  public static void main(String[] args) {
    Service s = new Service("");

    SimpleSwingBrowser viewfx = new SimpleSwingBrowser();

    Controller controller = new Controller(s,viewfx);
  }
}
