package in.co.nitro.data.stockbeat;

public class Instrument {

	private String _id;
	private String description;
	private double lastTradedPrice;
	private double lowerLimit;
	private double higherLimit;
	private NotifyTypeEnum notificationType;
	
	public enum NotifyTypeEnum {
		OFF,
		LIMIT,
		ALWAYS
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLastTradedPrice() {
		return lastTradedPrice;
	}

	public void setLastTradedPrice(double lastTradedPrice) {
		this.lastTradedPrice = lastTradedPrice;
	}

	public double getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public double getHigherLimit() {
		return higherLimit;
	}

	public void setHigherLimit(double higherLimit) {
		this.higherLimit = higherLimit;
	}

	public NotifyTypeEnum getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotifyTypeEnum notificationType) {
		this.notificationType = notificationType;
	}
}
