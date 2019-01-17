public class Fibonacci {

	public static void main (String[]args) {
		long currentTerm = Long.parseLong(args[0]);
		BigInteger previousTerm = new BigInteger("1");
		BigInteger twoBack = new BigInteger("0");
		if (currentTerm == 0) {
			previousTerm = twoBack;
		}

		for (int i = 2; i <= currentTerm; i++) {
			BigInteger currentTotal = previousTerm.add(twoBack);
			twoBack = previousTerm;
			previousTerm = currentTotal;
		}
		System.out.println(previousTerm);
	}
}
