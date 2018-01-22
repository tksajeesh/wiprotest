package com.wipro.test.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.wipro.test.Utils;

/**
 * This is a ViewModel for the row of the recycler view of the facts.
 * Created by Vishwajit on 19/01/18
 */

public class FactsModel implements Parcelable {

    private String title;
    private String description;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * To check whether any one of the value in the model is present.
     *
     * @return {@link boolean}
     */
    public boolean isEmpty() {
        return Utils.isEmptyOrNull(title) && Utils.isEmptyOrNull(description) && Utils.isEmptyOrNull(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.imageUrl);
    }

    public FactsModel() {
    }

    private FactsModel(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Parcelable.Creator<FactsModel> CREATOR = new Parcelable.Creator<FactsModel>() {
        @Override
        public FactsModel createFromParcel(Parcel source) {
            return new FactsModel(source);
        }

        @Override
        public FactsModel[] newArray(int size) {
            return new FactsModel[size];
        }
    };
}
