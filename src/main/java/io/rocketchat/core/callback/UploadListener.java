package io.rocketchat.core.callback;

import io.rocketchat.common.data.model.ErrorObject;
import io.rocketchat.core.model.FileObject;
import java.io.IOException;

/**
 * Created by sachin on 18/8/17.
 */
public interface UploadListener {
    void onUploadStarted (String roomId, String fileName, String description);
    void onUploadProgress (int progress, String roomId, String fileName, String description);
    void onUploadComplete (FileObject file, String roomId, String fileName, String description);
    void onUploadError(ErrorObject error, IOException e);
}
