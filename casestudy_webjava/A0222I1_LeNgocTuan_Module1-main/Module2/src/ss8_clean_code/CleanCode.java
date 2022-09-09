package ss8_clean_code;

public class CleanCode {
    private static String same_point = "format %s - All";
    private static String advantage_player = "format Advantage %s";
    private static String win_player = "format Win for %s";
    private String player1Name;
    private String player2Name;

    public String getPoint(int point1, int point2) {
//        Map<Integer, String> namePoint = new HashMap<>();
//        namePoint.put(0, "Love");
//        namePoint.put(1, "Fifteen");
//        namePoint.put(2, "Thirty");
//        namePoint.put(3, "Forty");
//        namePoint.put(4, "Deuce");

        String[] name = {"Love", "Fifteen", "Thirty", "Forty", "Deuce"};

        if (point1 == point2) {
            return (getScoreWhenSamePoint(point1));
        }

        if (canWinGame(point1) || canWinGame(point2)) {
            return (getScoreWhenEitherPlayerCanBeWinner(point1, point2));
        }
//        return String.format("%s - %s", namePoint.get(point1), namePoint.get(point2));
        return String.format("%s - %s", name[point1], name[point2]);
    }

    private String getScoreWhenSamePoint(int point) {
        switch (point) {
            case 0:
                same_point = "Love-All";
                break;
            case 1:
                same_point = "Fifteen-All";
                break;
            case 2:
                same_point = "Thirty-All";
                break;
            case 3:
                same_point = "Forty-All";
                break;
            default:
                same_point = "Deuce";
                break;
        }
        return same_point;
    }

    private String getScoreWhenEitherPlayerCanBeWinner(int point1, int point2) {
        int diff = Math.abs(point1 - point2);
        if (diff == 1 && point1 > point2) return advantage_player = "Advantage Player 1";
        if (diff == 1 && point1 < point2) return advantage_player = "Advantage Player 2";
        if (diff >= 2 && point1 > point2) return win_player = "Player 1 WIN";
        if (diff >= 2 && point1 < point2) return win_player = "Player 2 WIN";
        return "Never";
    }

    private boolean canWinGame(int point) {
        return point >= 4;
    }
}
