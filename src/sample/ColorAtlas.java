package sample;

import java.util.ArrayList;

/**
 * Created by anton on 30.07.2017.
 */
public class ColorAtlas {

    private ArrayList<UColor> atlas = new ArrayList<>();
    private ArrayList<String> namesOfColor = new ArrayList<>();

    public String addColor(UColor color) {
        if (namesOfColor.contains(color.getName())) {
            return "has been added early";
        }
        atlas.add( color);
        namesOfColor.add( color.getName());

        return "success";
    }

    public UColor getColor(String name) {
        // проверка соответствия name
        try {
            UColor color = atlas.get(namesOfColor.indexOf(name));
            if(color.getName()==name){
                return color;
            }
            else return null;
        }catch(Exception e){

        }
        return null;
    }

    public UColor giveNearColor(UColor color) {
        ArrayList<Double> dE76 = new ArrayList<>(atlas.size());
        double minDE76 = 100.0;
        for (int x = 0; x < atlas.size(); x++) {
            double de76 = color.dE76(atlas.get(x));
            dE76.add(de76);
            if(de76 < minDE76) minDE76 = de76;
        }

        return atlas.get(dE76.indexOf(minDE76));
    }
}
