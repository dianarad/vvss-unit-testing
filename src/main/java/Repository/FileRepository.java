package Repository;

/**
 * Created by drad on 11/03/2018.
 */

import Model.BaseEntity;

import java.io.IOException;
import java.util.ArrayList;

public interface FileRepository<T extends BaseEntity> extends BaseRepository<T>{
    void openFile(String mode) throws IOException;
    void closeFile(String mode) throws IOException;
}
