package aidl.connect;

import android.os.Parcel;
import android.os.Parcelable;

public class DemoSonBean implements Parcelable {

    private String sonName;
    private int sonCode;

    public DemoSonBean() {
    }

    protected DemoSonBean(Parcel in) {
        sonName = in.readString();
        sonCode = in.readInt();
    }

    public static final Creator<DemoSonBean> CREATOR = new Creator<DemoSonBean>() {
        @Override
        public DemoSonBean createFromParcel(Parcel in) {
            return new DemoSonBean(in);
        }

        @Override
        public DemoSonBean[] newArray(int size) {
            return new DemoSonBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sonName);
        dest.writeInt(sonCode);
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public int getSonCode() {
        return sonCode;
    }

    public void setSonCode(int sonCode) {
        this.sonCode = sonCode;
    }
}
