enum class BeltColor(val color: String, val order: Int) {
    WHITE("white", 0),
    YELLOW("yellow", 1),
    ORANGE("orange", 2),
    GREEN("green", 3),
    PURPLE("purple", 4),
    BLUE("blue", 5),
    BLUE_LEADER("blue leader", 6),
    BROWN("brown", 7),
    RED("red", 8),
    RED_LEADER("red leader", 9),
    DPTY_BLACK("deputy black", 10),
    BLACK("black", 11)
}

enum class Rank(val rank: String, val order: Int) {
    NONE("none", 0),
    NINTH("9th", 1),
    EIGHTH("8th", 2),
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
