public class Timer {
	private static long startTime = 0;
	
	public static void start() {
		if (startTime != 0) throw new RuntimeException("This should not happen");
		startTime = System.currentTimeMillis();
	}
	
	public static void end(String message) {
		Long time = System.currentTimeMillis() - startTime; 
		startTime = 0;
		System.out.println(message + " finished in: " + time + " milliseconds");
	}
} 

