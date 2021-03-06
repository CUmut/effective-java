package Chapter2.item8;

public class Room {

	/*In summary, don’t use cleaners, or in releases prior to Java 9, finalizers, except as a safety net or to terminate noncritical native resources. Even then, beware the indeterminacy and performance consequences.
*/
	
	private static final Cleaner cleaner = Cleaner.create();

	// Resource that requires cleaning. Must not refer to Room!
	private static class State implements Runnable {
		int numJunkPiles; // Number of junk piles in this room

		State(int numJunkPiles) {
			this.numJunkPiles = numJunkPiles;
		}

		// Invoked by close method or cleaner
		@Override
		public void run() {
			System.out.println("Cleaning room");
			numJunkPiles = 0;
		}
	}

	// The state of this room, shared with our cleanable
	private final State state;

	// Our cleanable. Cleans the room when it’s eligible for gc
	private final Cleaner.Cleanable cleanable;

	public Room(int numJunkPiles) {
		state = new State(numJunkPiles);
		cleanable = cleaner.register(this, state);
	}

	@Override
	public void close() {
		cleanable.clean();
	}
}
