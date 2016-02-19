package org.mariotaku.twidere.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@JsonObject
@ParcelablePlease
public class ParcelableMediaUpdate implements Parcelable {

    @SuppressWarnings("NullableProblems")
    @NonNull
    @JsonField(name = "uri")
    public String uri;
    @JsonField(name = "type")
    public int type;

    public ParcelableMediaUpdate() {
    }

    public ParcelableMediaUpdate(@NonNull final String uri, final int type) {
        this.uri = uri;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ParcelableMediaUpdate{uri=" + uri + ", type=" + type + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParcelableMediaUpdate that = (ParcelableMediaUpdate) o;

        if (type != that.type) return false;
        return uri.equals(that.uri);

    }

    @Override
    public int hashCode() {
        int result = uri.hashCode();
        result = 31 * result + type;
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        ParcelableMediaUpdateParcelablePlease.writeToParcel(this, dest, flags);
    }

    public static final Creator<ParcelableMediaUpdate> CREATOR = new Creator<ParcelableMediaUpdate>() {
        public ParcelableMediaUpdate createFromParcel(Parcel source) {
            ParcelableMediaUpdate target = new ParcelableMediaUpdate();
            ParcelableMediaUpdateParcelablePlease.readFromParcel(target, source);
            return target;
        }

        public ParcelableMediaUpdate[] newArray(int size) {
            return new ParcelableMediaUpdate[size];
        }
    };
}