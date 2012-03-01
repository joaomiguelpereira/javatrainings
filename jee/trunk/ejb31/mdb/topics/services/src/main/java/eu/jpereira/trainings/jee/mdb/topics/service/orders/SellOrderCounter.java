package eu.jpereira.trainings.jee.mdb.topics.service.orders;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SellOrderCounter {

	private Map<SellOrderType, Integer> ordersCount = new HashMap<SellOrderCounter.SellOrderType, Integer>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 344851761605171414L;

		{
			this.put(SellOrderType.BIG, 0);
			this.put(SellOrderType.AVERAGE, 0);
			this.put(SellOrderType.SMALL, 0);
		}
	};

	public enum SellOrderType {
		BIG, SMALL, AVERAGE;
	}

	@Lock(LockType.WRITE)
	public void hitOrderType(SellOrderType type) {
		
		Integer actualCount = this.ordersCount.get(type);
		
		Integer newVal = actualCount+1;
		System.out.println("Seeting actual count... "+newVal);
		this.ordersCount.put(type, newVal);
		System.out.println("Now is: "+this.ordersCount.get(type));
		
		
	}

	public Integer getCountFor(SellOrderType type) {
		System.out.println("Getting count for: "+type);
		return this.ordersCount.get(type);
	}

}
