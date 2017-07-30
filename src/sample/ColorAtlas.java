package sample;

import java.util.ArrayList;

/**
 * Created by anton on 30.07.2017.
 */
public class ColorAtlas {
    int quant;
    private ArrayList<UColor> atlas = new ArrayList<>();
    private ArrayList<String> namesOfColor = new ArrayList<>();

    public String addColor(UColor color) {
        if (namesOfColor.contains(color.getName())) {
            return "has been added early";
        }
        atlas.add(quant, color);
        namesOfColor.add(quant, color.getName());
        quant++;
        return "success";
    }

    public UColor getColor(String name) {
        //добавить проверку соответствия name
        return atlas.get(namesOfColor.indexOf(name));
    }

    public UColor giveNearColor(UColor color) {
        double[] dE76 = new double[quant];
        for (int x = 0; x < atlas.size(); x++) {
            dE76[x] = color.dE76(atlas.get(x));
        }
        double minDE76 = dE76[0];
        return null;
    }
}
