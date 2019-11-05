package com.openclassrooms.entrevoisins.model;

import android.os.Parcel;
import android.os.Parcelable;


import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour implements Parcelable {

    /**
     * Identifier
     */
    private Integer id;

    /**
     * Full name
     */
    private String name;

    /**
     * Avatar
     */
    private String avatarUrl;

    /**
     * Place
     */
    private String place;

    /**
     * Number
     */
    private String cellphone;

    /**
     * facebook
     */
    private String facebook;

    /**
     * F about me
     */
    private String about;



    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param avatarUrl
     */
    public Neighbour(Integer id, String name, String avatarUrl,String cellphone, String place, String facebook , String about) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.cellphone = cellphone;
        this.place = place ;
        this.facebook = facebook;
        this.about = about;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getPlace() { return place; }

    public String getCellphone() { return cellphone;}

    public String getFacebook() {
        return facebook;
    }

    public String getAbout() {
        return about;
    }


    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.avatarUrl);
        parcel.writeString(this.cellphone);
        parcel.writeString(this.place);
        parcel.writeString(this.facebook);
        parcel.writeString(this.about);

    }

    public static final Creator<Neighbour> CREATOR = new Creator<Neighbour>() {
        @Override
        public Neighbour createFromParcel(Parcel in) {
            return new Neighbour(in);
        }

        @Override
        public Neighbour[] newArray(int size) {
            return new Neighbour[size];
        }
    };


    protected Neighbour(Parcel in) {
        id = in.readInt();
        name = in.readString();
        avatarUrl = in.readString();
        cellphone = in.readString();
        place = in.readString();
        facebook = in.readString();
        about = in.readString();
    }

}
