// IVideo.aidl
package aidl.connect;

// Declare any non-default types here with import statements
import aidl.connect.DemoBean;
import aidl.connect.DemoSonBean;
interface IVideo {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt,String aString);

    void getDemoBean(in DemoBean bean);

     void getDemoSonBean(in DemoSonBean bean);
}
