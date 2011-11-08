package eu.jpereira.trainings.jee6.cdi.producers.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.EuroMillionLottery;
import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.JokerLottery;
import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.StringKeyLottery;


public @Model class LotteryManager {

	
	private @Inject @EuroMillionLottery Lottery euroMillion;
	private @Inject @JokerLottery Lottery joker;
	private @Inject @StringKeyLottery Lottery stringKey;

	public void setEuroMillion(Lottery euroMillion) {
		this.euroMillion = euroMillion;
	}
	public Lottery getEuroMillion() {
		return euroMillion;
	}
	
	@SuppressWarnings("unused")
	@PostConstruct
	private void initialize() {
		System.out.println("Initializing JSF Managed Bean...");
	}
	public void setJoker(Lottery joker) {
		this.joker = joker;
	}
	public Lottery getJoker() {
		return joker;
	}
	public void setStringKey(Lottery stringKey) {
		this.stringKey = stringKey;
	}
	public Lottery getStringKey() {
		return stringKey;
	}
	
	
}
