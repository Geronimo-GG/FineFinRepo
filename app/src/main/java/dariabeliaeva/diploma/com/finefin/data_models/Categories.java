package dariabeliaeva.diploma.com.finefin.data_models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dari on 3/20/2016.
 */
public class Categories extends RealmObject {

    enum eType {
        income,
        outcome
    }

    @PrimaryKey
    private int category_id;
    private String cat_name;
    private String icon;
    private String bg_color;
    private String type;

    //perhaps many-to-many with spendings?
    // private RealmList<Spendings> spendings; ...

    public Categories(int category_id, String cat_name, String icon, String bg_color, String type) {
        this.category_id = category_id;
        this.cat_name = cat_name;
        this.icon = icon;
        this.bg_color = bg_color;
        this.type = type;
    }

    public Categories() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBg_color() {
        return bg_color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
