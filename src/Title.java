import java.util.Random;

public enum Title {
	TO_KILL_A_MOCKINGBIRD,
	PRIDE_AND_PREJUDICE,
	ANIMAL_FARM,
	GONE_WITH_THE_WIND,
	THE_LORD_OF_THE_RINGS,
	ROMEO_AND_JULIET,
	LORD_OF_THE_FLIES,
	CRIME_AND_PUNISHMENT,
	OF_MICE_AND_MAN,
	BRAVE_NEW_WORLD,
	THE_ADVENTURES_OF_HUCKLEBERRY_FINN,
	A_TALE_OF_TWO_CITIES,
	LOLITA,
	SLAUGHTERHOUS_FIVE,
	CATCH_22,
	DUNE,
	ONE_FLEW_OVER_THE_CUCKOOS_NEST,
	WAR_AND_PEACE,
	DON_QUIXOTE,
	FAHRENHEIT_451,
	THE_OLD_MAN_AND_THE_SEA,
	GREAT_EXPECTATIONS;

	private static final Random rand = new Random();

	public static Title getRandomTitle() {
		return Title.values()[rand.nextInt(Title.values().length)];
	}
}
