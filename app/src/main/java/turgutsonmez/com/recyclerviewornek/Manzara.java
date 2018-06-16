package turgutsonmez.com.recyclerviewornek;

import java.util.ArrayList;

public class Manzara {

  private int imageID;
  private String title;
  private String description;

  public int getImageID() {
    return imageID;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public void setImageID(int imageID) {
    this.imageID = imageID;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  //Static demek; bu sınıftan herhangi bir nesne yaratmadan da bu methodu kullanabilirsin.

  public static ArrayList<Manzara> getData() {

    ArrayList<Manzara> dataList = new ArrayList<>();
    int[] resimler = {
      R.drawable.cart,
      R.drawable.check_icon, R.drawable.checkicon,
      R.drawable.downswipearrow,
      R.drawable.forwardtick, R.drawable.hearticon
    };
    for (int i = 0; i < resimler.length; i++) {
      Manzara gecici = new Manzara();
      gecici.setImageID(resimler[i]);
      gecici.setTitle("Manzara " + i);
      gecici.setDescription("Tanım Bilgisi " + i);

      dataList.add(gecici);
    }
    return dataList;
  }

}
