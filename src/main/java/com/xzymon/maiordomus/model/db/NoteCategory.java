package com.xzymon.maiordomus.model.db;

public enum NoteCategory {
	MARKET_EVENTS("Wydarzenia Rynkowe"),
	POLITICAL_EVENTS("Wydarzenia Polityczne"),
	CFD_TRADES("Zagrania CFD"),
	ANALYST_ANALYSES("Analizy Analityków"),
	ECONOMIC_TRENDS("Trendy Ekonomiczne"),
	MARKET_FORECASTS("Prognozy Rynkowe"),
	NEW_FINANCIAL_INSTRUMENTS("Nowe Instrumenty Finansowe"),
	FINANCIAL_EDUCATION("Edukacja Finansowa"),
	TECHNICAL_ANALYSES("Techniczne Analizy"),
	RISK_PORTFOLIO_MANAGEMENT("Ryzyko i Zarządzanie Portfelem");

	private final String description;

	NoteCategory(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
