package com.jin.testoldperson.permission;

/**
 * Created by my on 2017/6/20.
 */

public interface PermissionListener {
    void permissionGrand(int requestCode);
    void permissionDeny(int requestCode);
    void permissionNeverAsk(int requestCode);
    void permissionTip(int requestCode);

}
