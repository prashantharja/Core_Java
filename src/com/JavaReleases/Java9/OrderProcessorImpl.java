package com.JavaReleases.Java9;

public class OrderProcessorImpl implements OrderProcessor {

	public static void main(String[] args) {
		
		OrderProcessorImpl processor = new OrderProcessorImpl();
		
	//	processor.runSetupChecks();
		
		
		System.out.println("Processing Standard Order:");
		processor.processStandardOrder("STD123");
		
		System.out.println("\nProcessing Express Order:");
		processor.processExpressOrder("EXP123");
	}

	@Override
	public void saveToDatabase(String orderId) {
		
		System.out.println("Saving order " + orderId + " to the database...");
	}

}
