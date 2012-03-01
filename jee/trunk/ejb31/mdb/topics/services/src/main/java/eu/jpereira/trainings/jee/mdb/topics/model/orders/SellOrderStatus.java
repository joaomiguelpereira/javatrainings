package eu.jpereira.trainings.jee.mdb.topics.model.orders;

public enum SellOrderStatus {

	PLACED {

		SellOrderStatus nextState() {
			return PROCESSING;
		}
	},
	PROCESSING {

		SellOrderStatus nextState() {
			return PROCESSED;
		}
	},
	PROCESSED {
		SellOrderStatus nextState() {
			return CLOSED;
		}
	},
	CLOSED {
		SellOrderStatus nextState() {
			return CLOSED;
		}
	};

	SellOrderStatus nextState() {
		return PLACED;
	}
}
