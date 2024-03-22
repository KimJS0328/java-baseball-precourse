public class BaseballResult {
	private int strike;
	private int ball;

	public BaseballResult() {
		this.strike = 0;
		this.ball = 0;
	}

	public void addOneStrike() {
		++strike;
	}

	public void addOneBall() {
		++ball;
	}

	public boolean isThreeStrike() {
		return strike == 3;
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}
}
