package com.JavaReleases.Java9;

public interface OrderProcessor {

	void saveToDatabase(String orderId); // Standard abstract method

	// Default Method 1
	default void processStandardOrder(String orderId) {
		// --- SHARED SETUP LOGIC ---
		/*
		 * System.out.println("Connecting to OMS database...");
		 * System.out.println("Validating order ID: " + orderId);
		 */
		// --------------------------

		runSetupChecks();
		System.out.println("Routing standard order to local warehouse.");
		saveToDatabase(orderId);
	}

	// Default Method 2
	default void processExpressOrder(String orderId) {
		// --- SHARED SETUP LOGIC (Duplicated!) ---
		/*
		 * System.out.println("Connecting to OMS database...");
		 * System.out.println("Validating order ID: " + orderId);
		 */
		// ----------------------------------------

		runSetupChecks();
		System.out.println("Routing EXPRESS order to air freight!");
		saveToDatabase(orderId);
	}

	private void runSetupChecks() {
		System.out.println("Connecting to OMS database...");
		System.out.println("Validating order ID...");
	}
}