package eu.jpereira.trainings.jee6.cdi.interceptors.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.interceptors.qualifiers.EuroMillionLottery;
import eu.jpereira.trainings.jee6.cdi.interceptors.qualifiers.JokerLottery;
import eu.jpereira.trainings.jee6.cdi.interceptors.qualifiers.StringKeyLottery;



public @Model
class LotteryManager {

	private @Inject LotteryService loteryService;
	//add
	private String name;
	
	private @Inject
	@EuroMillionLottery
	Lottery euroMillionLotery;

	private @Inject
	@JokerLottery
	Lottery jokerLottery;

	private @Inject @StringKeyLottery Lottery stringKey;
	
	/****Getters and setters****/

	public void sendPrize() {
		this.loteryService.sendPrizeTo(this.name);
	}
	public Lottery getJokerLottery() {
		return jokerLottery;
	}

	public void setJokerLottery(Lottery jokerLottery) {
		this.jokerLottery = jokerLottery;
	}

	public void setEuroMillionLotery(Lottery euroMillionLotery) {
		this.euroMillionLotery = euroMillionLotery;
	}

	public Lottery getEuroMillionLotery() {
		return euroMillionLotery;
	}

	public void setStringKey(Lottery stringKey) {
		this.stringKey = stringKey;
	}

	public Lottery getStringKey() {
		return stringKey;
	}

	public void setLoteryService(LotteryService loteryService) {
		this.loteryService = loteryService;
	}

	public LotteryService getLoteryService() {
		return loteryService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	
}
