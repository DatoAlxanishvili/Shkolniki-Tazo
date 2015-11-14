package com.geolab.schooldhelper.Data;

/**
 * Created by dalkh on 14-Nov-15.
 */
public class FormulaObj {
    private String image, description;





    public FormulaObj(String description, String image) {
        this.image=image;
        this.description=description;
    }


    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image=image;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}

