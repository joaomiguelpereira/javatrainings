package eu.jpereira.trainings.jee.mdb.queues.model.orders;

public enum OrderStatus {

	PLACED {

		OrderStatus nextState() {
			return PROCESSING;
		}
	},
	PROCESSING {

		OrderStatus nextState() {
			return PROCESSED;
		}
	},
	PROCESSED {
		OrderStatus nextState() {
			return CLOSED;
		}
	},
	CLOSED {
		OrderStatus nextState() {
			return CLOSED;
		}
	};

	OrderStatus nextState() {
		return PLACED;
	}
}
