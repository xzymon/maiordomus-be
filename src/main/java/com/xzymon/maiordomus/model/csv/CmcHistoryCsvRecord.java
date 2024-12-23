package com.xzymon.maiordomus.model.csv;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CmcHistoryCsvRecord {
	//"01""DATA/CZAS";
	@CsvBindByPosition(position = 0)
	private String orderTimestamp;

	//"02""TYP";
	@CsvBindByPosition(position = 1)
	private String orderType;

	//"03""ZLECENIE#";
	@CsvBindByPosition(position = 2)
	private String order;

	//"04""TRANSAKCJA#";
	@CsvBindByPosition(position = 3)
	private String transaction;

	//"05""ZLECENIE POWIĄZANE#";
	@CsvBindByPosition(position = 4)
	private String relatedOrder;

	//"06""INSTRUMENT";
	@CsvBindByPosition(position = 5)
	private String instrument;

	//"07""JEDNOSTKI/IL.";
	@CsvBindByPosition(position = 6)
	private String volume;

	//"08""CENA";
	@CsvBindByPosition(position = 7)
	private String price;

	//"09""TOLERANCJA CENA";
	@CsvBindByPosition(position = 8)
	private String priceTolerance;

	//"10""STOP LOSS";
	@CsvBindByPosition(position = 9)
	private String stopLoss;

	//"11""TAKE PROFIT";
	@CsvBindByPosition(position = 10)
	private String takeProfit;

	//"12""DEPOZYT ZABEZPIECZAJĄCY (PLN)";
	@CsvBindByPosition(position = 11)
	private String securityDepositPln;

	//"13""KURS WYMIANY";
	@CsvBindByPosition(position = 12)
	private String exchangeRate;

	//"14""WARTOŚĆ POZYCJI (PLN)";
	@CsvBindByPosition(position = 13)
	private String orderValuePln;

	//"15""ZAKSIĘGOWANA KWOTA (PLN)";
	@CsvBindByPosition(position = 14)
	private String postedValuePln;

	//"16""SALDO (PLN)";
	@CsvBindByPosition(position = 15)
	private String balancePln;

	//"17""WARTOŚĆ WYŁĄCZAJĄC OPŁATĘ";
	@CsvBindByPosition(position = 16)
	private String valueWithoutCommission;

	//"18""OPŁATA";
	@CsvBindByPosition(position = 17)
	private String commission;

	//"19""KOSZTY UTRZYMANIA POZYCJI - WARTOŚĆ POZYCJI";
	@CsvBindByPosition(position = 18)
	private String maintenanceChargeValue;

	//"20""STAWKA ZA UTRZYMANIE POZYCJI";
	@CsvBindByPosition(position = 19)
	private String dailyMaintenanceChargeRate;

	//"21""KOSZTY UTRZYMANIA POZYCJI (PLN)";
	@CsvBindByPosition(position = 20)
	private String maintenanceChargePln;

	//"22""KOSZTY UTRZYMANIA POZYCJI - SUMA (PLN)";
	@CsvBindByPosition(position = 21)
	private String maintenanceChargeSumPln;

	//"23""OPŁATA";
	@CsvBindByPosition(position = 22)
	private String charge2;

	//"24""ZWROT %";
	@CsvBindByPosition(position = 23)
	private String revenueInPercents;

	//"25""KIERUNEK";
	@CsvBindByPosition(position = 24)
	private String direction;

	//"26""WYPŁATA GDY ZYSK";
	@CsvBindByPosition(position = 25)
	private String profitPayoff;

	//"27""WYPŁATA GDY BEZ ZMIANY";
	@CsvBindByPosition(position = 26)
	private String neutralPayoff;

	//"28""OTWARCIE";
	@CsvBindByPosition(position = 27)
	private String opening;

	//"29""WYGAŚNIĘCIE";
	@CsvBindByPosition(position = 28)
	private String expiration;

	//"30""ROZLICZENIE";
	@CsvBindByPosition(position = 29)
	private String clearance1;

	//"31""CENA ROZLICZENIA";
	@CsvBindByPosition(position = 30)
	private String clearance1Price;

	//"32""WYNIK";
	@CsvBindByPosition(position = 31)
	private String outcome;

	//"33""WYPŁATA";
	@CsvBindByPosition(position = 32)
	private String payoff;

	//"34""TYP";
	@CsvBindByPosition(position = 33)
	private String type;

	//"35""WYGAŚNIĘCIE";
	@CsvBindByPosition(position = 34)
	private String expiration2;

	//"36""CENA WYKONAWCZA";
	@CsvBindByPosition(position = 35)
	private String executionPrice;

	//"37""ROZLICZENIE";
	@CsvBindByPosition(position = 36)
	private String clearance2;

	//"38""CENA ROZLICZENIA";
	@CsvBindByPosition(position = 37)
	private String clearance2Price;

	//"39""ZYSK";
	@CsvBindByPosition(position = 38)
	private String profit;

	//"40""STRATA"
	@CsvBindByPosition(position = 39)
	private String loss;

}
