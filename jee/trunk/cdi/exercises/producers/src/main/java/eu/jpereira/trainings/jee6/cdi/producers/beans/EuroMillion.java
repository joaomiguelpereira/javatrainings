package eu.jpereira.trainings.jee6.cdi.producers.beans;


import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.EuroMillionLottery;

@EuroMillionLottery
public class EuroMillion extends AbstractLottery{
	@Override
	public void generateResult() {
		System.out.println("Generating Euro Million key...");
		this.result = "I wish I know that...";
	}

}
