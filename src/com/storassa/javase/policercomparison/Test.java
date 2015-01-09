package com.storassa.javase.policercomparison;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		IETFPolicer policer = new IETFPolicer();
		policer.setCbs(20);
		policer.setCir(1);
		policer.setPbs(45);
		policer.setPir(2);

		System.out.println("CBS = " + policer.getCbs() + "; CIR = " + policer.getCir());
		System.out.println("PBS = " + policer.getPbs() + "; PIR = " + policer.getPir());

		policer.start();
		System.out.println("P bucket size: " + policer.getPBucket());
		System.out.println("C bucket size: " + policer.getCBucket());

		while (true) {
			Thread.sleep(5000);

			System.out.println("P bucket size: " + policer.getPBucket());
			System.out.println("C bucket size: " + policer.getCBucket());
			
			System.out.println("Packet with size 12 passed as " + policer.check(12));
			
			System.out.println("P bucket size: " + policer.getPBucket());
			System.out.println("C bucket size: " + policer.getCBucket());
		}
		
		// policer.stop();
	}
}
