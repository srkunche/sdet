package JavaActivities;

//Abstract class
abstract class Book {
  String title;
  //Abstract method
  abstract void setTitle(String s);
  
  //Concrete method
  String getTitle() {
    return title;
  }
}

class MyBook extends Book {
  //Define abstract method
  public void setTitle(String s) {
    title = s;
  }
}

public class Activity2_1 {
  
  public static void main(String []args) {
       String title = "Hover Car Racer";
      Book newNovel = new MyBook();
      newNovel.setTitle(title);
      System.out.println("The title is: " + newNovel.getTitle());
  }
}