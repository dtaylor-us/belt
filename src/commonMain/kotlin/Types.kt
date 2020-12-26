enum class BeltColor(val color: String, val order: Int) {
    WHITE("white", 0),
    YELLOW("yellow", 1),
    GREEN("green", 2),
    PURPLE("purple", 3),
    BLUE("blue", 4),
    BLUE_LEADER("blue leader", 4),
    BROWN("brown", 5),
    RED("red", 6),
    RED_LEADER("red leader", 7),
    DPTY_BLACK("deputy black", 8),
    BLACK("black", 9)
}

enum class Rank(val rank: String, val order: Int) {
    NONE("none", 0),
    NINTH("9th", 1),
    EIGTH("8th", 2),
    SEVENTH("7th", 3),
    SIXTH("6th", 4),
    FIFTH("5th", 5),
    FOURTH("4th", 6),
    THIRD("3rd", 7),
    SECOND("2nd", 8),
    FIRST("1st", 9),
}

enum class Level(val level: String, val order: Int) {
    BEGINNER("beginner", 0),
    INTERMEDIATE("intermediate", 1),
    ADVANCED("advanced", 2)
}
