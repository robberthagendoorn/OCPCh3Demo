public class Main {
	public static void main(String... args) {
		View view = new View();
		Controller cont = new Controller(view);
		Option option = getOption(args[0]);
		cont.start(option);
	}

	private static Option getOption(String input) {
		Option option = Option.valueOf(input.toUpperCase()); 		
		return option;
	}
}
