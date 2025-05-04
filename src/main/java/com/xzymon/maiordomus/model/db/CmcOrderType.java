package com.xzymon.maiordomus.model.db;

public enum CmcOrderType {
	NOT_ENOUGH_CASH("Odrzucono Zlecenie: brak wystarczających środków"),
	LIQUIDATION("Likwidacja"),
	TAKE_PROFIT_MODIFIED("Zmodyfikowano Take Profit"),
	REMIT("Wpłata"),
	CLOSE("Zamknięcie Transakcji"),
	BUY("Transakcja Kupna"),
	SELL_MODIFIED("Zmodyfikowano Transakcję Sprzedaży"),
	SELL("Transakcja Sprzedaży"),
	STOP_LOSS("Stop Loss"),
	MAINTENANCE_COST("Koszty Utrzymania Pozycji"),
	ACTIVATION("Aktywowano"),
	BUY_MODIFIED("Zmodyfikowano Transakcję Kupna"),
	STOP_LOSS_MODIFIED("Zmodyfikowano Stop Loss"),
	TAKE_PROFIT("Take Profit"),
	DEACTIVATION("Zablokowano");

	private String name;

	CmcOrderType(String name) {
		this.name = name;
	}

	public static CmcOrderType getByName(String name) {
		for (CmcOrderType type : CmcOrderType.values()) {
			if (type.getName().equals(name)) {
				return type;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}
}
