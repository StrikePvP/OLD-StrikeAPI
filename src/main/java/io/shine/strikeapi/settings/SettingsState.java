package io.shine.strikeapi.settings;

public enum SettingsState {
    ENABLE(2),
    ONLY_FRIENDS(1),
    DISABLE(0);

    private int state;

    private SettingsState(int state){
        this.state = state;
    }

    /**
     * Get state int
     * @return
     */
    public int getState() {
        return state;
    }
}
