package com.example.admin.w1wenavigationdrawer;

import java.util.ArrayList;
import java.util.List;

public class ObjectModel {

    private int imageID;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public static List<ObjectModel> getObjectList() {

        List<ObjectModel> dataList = new ArrayList<>();
        int[] images = getImages();

        for (int i = 0; i < images.length; i++) {
            ObjectModel nature = new ObjectModel();
            nature.setImageID(images[i]);
            dataList.add(nature);
        }
        return dataList;
    }

    private static int[] getImages() {

        int[] images = {
                R.drawable.beach1,
                R.drawable.beach2,
                R.drawable.beach3,
                R.drawable.beach4,
                R.drawable.beach5,
                R.drawable.beach6
        };

        return images;
    }
}
