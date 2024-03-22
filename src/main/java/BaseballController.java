public class BaseballController {
	private final Baseball model;
	private final BaseballView view;

	public BaseballController(Baseball model, BaseballView view) {
		this.model = model;
		this.view = view;
	}

	public void run() {
		model.init();
		view.printIntro();
		while (true) {
			runOneGame();

			view.printControlGuide();
			int control = view.scanControl();
			while (!model.validateControl(control)) {
				view.printControlError();
				view.printControlGuide();
				control = view.scanControl();
			}

			if (model.isQuit(control)) {
				return;
			}
		}
	}

	private void runOneGame() {
		while (true) {
			BaseballResult result = runOneTurn();
			if (model.isGameWin(model)) {
				view.printOutro();
				return;
			}
			view.printResult(result);
		}
	}

	private BaseballResult runOneTurn() {
		view.printInputGuide();
		int number = view.scanBaseballNumber();
		if (!model.validateNumber(number)) {
			view.printInputError();
			return null;
		}
		return model.compareNumber(number);
	}
}
