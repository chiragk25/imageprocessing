package imageprocessing;

import javax.media.jai.util.ImagingListener;

public class MyErrListener implements ImagingListener {
  public boolean errorOccurred(String arg0, Throwable arg1, Object arg2, boolean arg3)
      throws RuntimeException {
    // Do nothing.
    return false;
  }
}
