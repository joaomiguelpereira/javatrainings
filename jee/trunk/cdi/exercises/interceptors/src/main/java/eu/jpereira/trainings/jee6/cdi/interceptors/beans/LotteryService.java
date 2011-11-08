package eu.jpereira.trainings.jee6.cdi.interceptors.beans;

public class LotteryService {

	public void sendPrizeTo(String name) {
		System.out.println("Sending prize to: " + name);
	}
}
