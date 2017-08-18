package io.rocketchat.core.uploader;

import io.rocketchat.common.listener.Listener;
import io.rocketchat.core.model.FileObject;

/**
 * Created by sachin on 17/8/17.
 */
public class IFileUpload {

    public interface UfsCreateListener extends Listener {
        void onUfsCreate(FileUploadToken token);
    }

    public interface UfsCompleteListener extends Listener {
        void onUfsComplete(FileObject file);
    }
}
