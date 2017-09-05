package com.example.admin.w1wenavigationdrawer;

import java.util.ArrayList;
import java.util.List;

public class CityModel {

    private int imageID;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public static List<CityModel> getObjectList() {

        List<CityModel> dataList = new ArrayList<>();
        int[] images = getImages();

        for (int i = 0; i < images.length; i++) {
            CityModel nature = new CityModel();
            nature.setImageID(images[i]);
            dataList.add(nature);
        }
        return dataList;
    }

    private static int[] getImages() {

        int[] images = {
                R.drawable.city1,
                R.drawable.city2,
                R.drawable.city3,
                R.drawable.city4,
                R.drawable.city5,
                R.drawable.city7,
                R.drawable.city9,
                R.drawable.city10,
                R.drawable.city11,
        };

        return images;
    }
}
