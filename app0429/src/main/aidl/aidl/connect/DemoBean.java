package aidl.connect;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class DemoBean implements Parcelable {

    private String name;

    private int code;
    private List<String> ss;
    private byte[] bArray;
    private List<DemoSonBean> sons;

    public DemoBean() {
    }

    protected DemoBean(Parcel in) {
        name = in.readString();
        code = in.readInt();
        ss = in.createStringArrayList();
        bArray = in.createByteArray();
        sons = in.createTypedArrayList(DemoSonBean.CREATOR);
    }

    public static final Creator<DemoBean> CREATOR = new Creator<DemoBean>() {
        @Override
        public DemoBean createFromParcel(Parcel in) {
            return new DemoBean(in);
        }

        @Override
        public DemoBean[] newArray(int size) {
            return new DemoBean[size];
        }
    };

    public byte[] getbArray() {
        return bArray;
    }

    public void setbArray(byte[] bArray) {
        this.bArray = bArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getSs() {
        return ss;
    }

    public void setSs(List<String> ss) {
        this.ss = ss;
    }


    public List<DemoSonBean> getSons() {
        return sons;
    }

    public void setSons(List<DemoSonBean> sons) {
        this.sons = sons;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(code);
        dest.writeStringList(ss);
        dest.writeByteArray(bArray);
        dest.writeTypedList(sons);
    }
}
