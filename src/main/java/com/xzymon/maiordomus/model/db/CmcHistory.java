package com.xzymon.maiordomus.model.db;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cmc_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CmcHistory {

	@Id
	@GeneratedValue(generator = "cmc_history_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	//"01""DATA/CZAS";
	@Timestamp
	@Column(name = "order_timestamp")
	private LocalDateTime orderTimestamp;

	//"02""TYP";
	@Column(name = "order_type")
	@Enumerated(EnumType.STRING)
	private CmcOrderType orderType;

	//"03""ZLECENIE#";
	@Column(name = "order_no")
	private String orderNo;

	//"04""TRANSAKCJA#";
	@Column(name = "transaction")
	private String transaction;

	//"05""ZLECENIE POWIĄZANE#";
	@Column(name = "related_order")
	private String relatedOrder;

	//"06""INSTRUMENT";
	@ManyToOne
	@JoinColumn(name = "valor_id")
	private StockValor instrument;

	//"07""JEDNOSTKI/IL.";
	@Column(name = "volume")
	private BigDecimal volume;

	//"08""CENA";
	@Column(name = "price")
	private BigDecimal price;

	//"09""TOLERANCJA CENA";
	@Column(name = "price_tolerance")
	private BigDecimal priceTolerance;

	//"10""STOP LOSS";
	@Column(name = "stop_loss")
	private BigDecimal stopLoss;

	//"11""TAKE PROFIT";
	@Column(name = "take_profit")
	private BigDecimal takeProfit;

	//"12""DEPOZYT ZABEZPIECZAJĄCY (PLN)";
	@Column(name = "security_deposit_pln")
	private BigDecimal securityDepositPln;

	//"13""KURS WYMIANY";
	@Column(name = "exchange_rate")
	private BigDecimal exchangeRate;

	//"14""WARTOŚĆ POZYCJI (PLN)";
	@Column(name = "order_value_pln")
	private BigDecimal orderValuePln;

	//"15""ZAKSIĘGOWANA KWOTA (PLN)";
	@Column(name = "posted_value_pln")
	private BigDecimal postedValuePln;

	//"16""SALDO (PLN)";
	@Column(name = "balance_pln")
	private BigDecimal balancePln;

	//"17""WARTOŚĆ WYŁĄCZAJĄC OPŁATĘ";
	@Column(name = "value_without_commission")
	private BigDecimal valueWithoutCommission;

	//"18""OPŁATA";
	@Column(name = "commission")
	private BigDecimal commission;

	//"19""KOSZTY UTRZYMANIA POZYCJI - WARTOŚĆ POZYCJI";
	@Column(name = "maintenance_charge_value")
	private BigDecimal maintenanceChargeValue;

	//"20""STAWKA ZA UTRZYMANIE POZYCJI";
	@Column(name = "daily_maintenance_charge_rate")
	private BigDecimal dailyMaintenanceChargeRate;

	//"21""KOSZTY UTRZYMANIA POZYCJI (PLN)";
	@Column(name = "maintenance_charge_pln")
	private BigDecimal maintenanceChargePln;

	//"22""KOSZTY UTRZYMANIA POZYCJI - SUMA (PLN)";
	@Column(name = "maintenance_charge_sum_pln")
	private BigDecimal maintenanceChargeSumPln;

	//"23""OPŁATA";
	@Column(name = "charge2")
	private BigDecimal charge2;

	//"24""ZWROT %";
	@Column(name = "revenue_in_percents")
	private BigDecimal revenueInPercents;

	/*
	//"25""KIERUNEK";
	@Column(name = "direction")
	private String direction;

	//"26""WYPŁATA GDY ZYSK";
	@Column(name = "profit_payoff")
	private BigDecimal profitPayoff;

	//"27""WYPŁATA GDY BEZ ZMIANY";
	@Column(name = "neutral_payoff")
	private BigDecimal neutralPayoff;

	//"28""OTWARCIE";
	@Column(name = "opening")
	private String opening;

	//"29""WYGAŚNIĘCIE";
	@Column(name = "expiration")
	private String expiration;

	//"30""ROZLICZENIE";
	@Column(name = "clearance1")
	private String clearance1;

	//"31""CENA ROZLICZENIA";
	@Column(name = "clearance1_price")
	private String clearance1Price;

	//"32""WYNIK";
	@Column(name = "outcome")
	private String outcome;

	//"33""WYPŁATA";
	@Column(name = "payoff")
	private String payoff;

	//"34""TYP";
	@Column(name = "type")
	private String type;

	//"35""WYGAŚNIĘCIE";
	@Column(name = "expiration2")
	private String expiration2;

	//"36""CENA WYKONAWCZA";
	@Column(name = "execution_price")
	private String executionPrice;

	//"37""ROZLICZENIE";
	@Column(name = "clearance2")
	private String clearance2;

	//"38""CENA ROZLICZENIA";
	@Column(name = "clearance2_price")
	private String clearance2Price;

	//"39""ZYSK";
	@Column(name = "profit")
	private String profit;

	//"40""STRATA"
	@Column(name = "loss")
	private String loss;
	 */
}
