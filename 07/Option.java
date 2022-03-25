public enum Option {
    EXIT('q', "Exit program"),
    ADD_TEMP_SENSOR('t', "Add new temperature sensor"),
    ADD_AVG_SENSOR('a', "Add new average sensor"),
    ADD_TEMP_TO_AVG('s', "Add temperature sensor to average sensor"),
    TURN_OFF('f', "Turn sensor off"),
    TURN_ON('o', "Turn sensor on"),
    PRINT_TEMP('p', "Get value from temperature sensor"),
    PRINT_TEMP_LIST('l', "Print list of temperatures in given region");

    private final char character;
    private final String description;

    Option(char character, String description) {
        this.character = character;
        this.description = description;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return "'" + character + "'" + " => " + description;
    }
}
