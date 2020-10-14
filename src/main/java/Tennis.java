public class Tennis{

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    private final Player player1;
    private final Player player2;

    public Tennis(String namePlayer1, String namePlayer2) {
        if (namePlayer1 == null || namePlayer2 == null)
            throw new IllegalArgumentException("2 Player are needed for one game");
        if (namePlayer1.length()==0 || namePlayer1.length()>100)
            throw new IllegalArgumentException("Name length for first Player has to be between 1 and 100 characters.");
        if (namePlayer2.length()==0 || namePlayer2.length()>100)
            throw new IllegalArgumentException("Name length for second Player has to be between 1 and 100 characters.");
        this.player1 = new Player(namePlayer1, 0);
        this.player2 = new Player(namePlayer2, 0);
    }

    public String getScore() {
        if (player1.getPoints()<4 && player2.getPoints()<4){
            if (player1.getPoints()==3 && player2.getPoints()==3){
                return "Deuce";
            }
            else return scoreExpression(player1, player2);
        } else if (player1.getPoints()-player2.getPoints()<2){
            return "Advantage " + getLeader(player1, player2).getName();
        } else return "Win for "+ getLeader(player1, player2).getName();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.incrementPoints();
        if (playerName.equals(player2.getName()))
            player2.incrementPoints();
    }

    private String scoreExpression(Player player1, Player player2) {
        if (player1.getPoints() == player2.getPoints())
            return player1.getScore() + "-All";
        return player1.getScore() + "-" + player2.getScore();
    }

    private Player getLeader(Player player1, Player player2){
        if (player1.getPoints() > player2.getPoints())
            return player1;
        if (player2.getPoints() > player1.getPoints())
            return player2;
        return null;
    }

}

class Player {
    private final static String[] SCORE_MATRIX = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private final String name;
    private int points;

    public Player(String name, int points){
        this.name=name;
        this.points=points;
    }

    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }
    public void incrementPoints() {
        points++;
    }
    public String getScore(){
        return SCORE_MATRIX[points];
    }
}

final class GameStatus {

    public static boolean max3Points(int pointsPlayer1, int pointsPlayer2){
        return (pointsPlayer1 < 4 && pointsPlayer2 <4);
    }

    public static boolean deuce(int pointsPlayer1, int pointsPlayer2){
        return (pointsPlayer1==pointsPlayer2) && (pointsPlayer1>2);
    }

    public static boolean ended(int pointsPlayer1, int pointsPlayer2){
        if (pointsPlayer1<0 || pointsPlayer2<0)
            throw new IllegalArgumentException("Punkte dürfen nicht negativ sein.");

        int higherPoints = Integer.max(pointsPlayer1, pointsPlayer2);
        int lowerPoints = Integer.min(pointsPlayer1, pointsPlayer2);
        return (higherPoints - lowerPoints) > 1 && (higherPoints>3);
    }
}
