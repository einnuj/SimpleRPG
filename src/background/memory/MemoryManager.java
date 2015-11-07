package background.memory;

/**
 * I know memory means something else when we're talking about software, but
 * it works here to mean data. This is purely for reading/writing data.
 *
 * Created by Junnie on 11/6/2015.
 */
public enum MemoryManager {
    INSTANCE;

    private MemoryManager() {
        // Initialization
    }

    public void read() {}

    public void write() {}
}
