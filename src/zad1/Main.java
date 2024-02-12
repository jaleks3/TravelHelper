/**
 *
 *  @author Aleksandrowicz Jakub S24592
 *
 */

package zad1;


import zad1.Controller.Controller;
import zad1.Service.Service;
import zad1.View.SimpleSwingBrowser;

public class Main {
  public static void main(String[] args) {
    Service s = new Service("");

    SimpleSwingBrowser viewfx = new SimpleSwingBrowser();

    Controller controller = new Controller(s,viewfx);
  }
}
