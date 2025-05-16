package com.xzymon.maiordomus.mapper.helper;

import java.util.HashMap;
import java.util.Map;

public class CmcInstrumentHelper {
	public static Map<String, String> VALOR_NAME_TO_INSTRUMENT_MAP = new HashMap<>() {{
		put("Rachunek", "Rachunek");
		put("PL", "Akcja polska Notowania");
		put("USA", "Akcja USA Notowania");

		put("AUDCAD", "AUD/CAD");
		put("AUDCHF", "AUD/CHF");
		put("AUDCNY", "AUD/CNY");
		put("AUDGBP", "AUD/GBP");
		put("AUDHKD", "AUD/HKD");
		put("AUDJPY", "AUD/JPY");
		put("AUDNOK", "AUD/NOK");
		put("AUDNZD", "AUD/NZD");
		put("AUDPLN", "AUD/PLN");
		put("AUDSGD", "AUD/SGD");
		put("AUDTRY", "AUD/TRY");
		put("AUDUSD", "AUD/USD");

		put("CADHKD", "CAD/HKD");
		put("CADJPY", "CAD/JPY");
		put("CADNOK", "CAD/NOK");
		put("CADNZD", "CAD/NZD");
		put("CADSGD", "CAD/SGD");
		put("CADTRY", "CAD/TRY");
		put("CADUSD", "CAD/USD");

		put("CHFARS", "CHF/ARS");
		put("CHFAUD", "CHF/AUD");
		put("CHFCAD", "CHF/CAD");
		put("CHFCNY", "CHF/CNY");
		put("CHFDKK", "CHF/DKK");
		put("CHFEUR", "CHF/EUR");
		put("CHFGBP", "CHF/GBP");
		put("CHFHKD", "CHF/HKD");
		put("CHFILS", "CHF/ILS");
		put("CHFINR", "CHF/INR");
		put("CHFJPY", "CHF/JPY");
		put("CHFMXN", "CHF/MXN");
		put("CHFNOK", "CHF/NOK");
		put("CHFNZD", "CHF/NZD");
		put("CHFPLN", "CHF/PLN");
		put("CHFSGD", "CHF/SGD");
		put("CHFTRY", "CHF/TRY");
		put("CHFUSD", "CHF/USD");

		put("EURAUD", "EUR/AUD");
		put("EURCAD", "EUR/CAD");
		put("EURCHF", "EUR/CHF");
		put("EURGBP", "EUR/GBP");
		put("EURHKD", "EUR/HKD");
		put("EURJPY", "EUR/JPY");
		put("EURNOK", "EUR/NOK");
		put("EURNZD", "EUR/NZD");
		put("EURPLN", "EUR/PLN");
		put("EURSGD", "EUR/SGD");
		put("EURUSD", "EUR/USD");
		put("EURTRY", "EUR/TRY");

		put("GBPAUD", "GBP/AUD");
		put("GBPCAD", "GBP/CAD");
		put("GBPCHF", "GBP/CHF");
		put("GBPCNY", "GBP/CNY");
		put("GBPDKK", "GBP/DKK");
		put("GBPEUR", "GBP/EUR");
		put("GBPHKD", "GBP/HKD");
		put("GBPILS", "GBP/ILS");
		put("GBPINR", "GBP/INR");
		put("GBPJPY", "GBP/JPY");
		put("GBPNOK", "GBP/NOK");
		put("GBPNZD", "GBP/NZD");
		put("GBPPLN", "GBP/PLN");
		put("GBPRUB", "GBP/RUB");
		put("GBPSEK", "GBP/SEK");
		put("GBPSGD", "GBP/SGD");
		put("GBPTRY", "GBP/TRY");
		put("GBPUSD", "GBP/USD");
		put("GBPZAR", "GBP/ZAR");

		put("HKDJPY", "HKD/JPY");

		put("JPYAUD", "JPY/AUD");
		put("JPYCAD", "JPY/CAD");
		put("JPYCHF", "JPY/CHF");
		put("JPYCNY", "JPY/CNY");
		put("JPYDKK", "JPY/DKK");
		put("JPYEUR", "JPY/EUR");
		put("JPYHKD", "JPY/HKD");
		put("JPYNOK", "JPY/NOK");
		put("JPYNZD", "JPY/NZD");
		put("JPYPLN", "JPY/PLN");
		put("JPYRUB", "JPY/RUB");
		put("JPYSEK", "JPY/SEK");
		put("JPYSGD", "JPY/SGD");
		put("JPYTRY", "JPY/TRY");
		put("JPYUSD", "JPY/USD");
		put("JPYZAR", "JPY/ZAR");

		put("NZDAUD", "NZD/AUD");
		put("NZDCHF", "NZD/CHF");
		put("NZDJPY", "NZD/JPY");
		put("NZDNOK", "NZD/NOK");
		put("NZDPLN", "NZD/PLN");
		put("NZDSGD", "NZD/SGD");
		put("NZDUSD", "NZD/USD");

		put("PLNCHF", "PLN/CHF");
		put("PLNEUR", "PLN/EUR");
		put("PLNGBP", "PLN/GBP");
		put("PLNJPY", "PLN/JPY");
		put("PLNUSD", "PLN/USD");

		put("SGDJPY", "SGD/JPY");

		put("USDARS", "USD/ARS");
		put("USDAUD", "USD/AUD");
		put("USDBRL", "USD/BRL");
		put("USDCAD", "USD/CAD");
		put("USDCHF", "USD/CHF");
		put("USDCNY", "USD/CNY");
		put("USDDKK", "USD/DKK");
		put("USDEUR", "USD/EUR");
		put("USDGBP", "USD/GBP");
		put("USDILS", "USD/ILS");
		put("USDINR", "USD/INR");
		put("USDJPY", "USD/JPY");
		put("USDMXN", "USD/MXN");
		put("USDNOK", "USD/NOK");
		put("USDNZD", "USD/NZD");
		put("USDPLN", "USD/PLN");
		put("USDRUB", "USD/RUB");
		put("USDSEK", "USD/SEK");
		put("USDSGD", "USD/SGD");
		put("USDTRY", "USD/TRY");
		put("USDZAR", "USD/ZAR");


		put("ADA.V", "Cardano (USD)");
		put("ADA2.V", "Cardano 2.0 (USD)");
		put("ALGO.V", "Algorand (USD)");
		put("ATOM.V", "Cosmos (USD)");
		put("AVAX.V", "Avalanche (USD)");
		put("BCH.V", "Bitcoin Cash (USD)");
		put("BNB.V", "Binance Coin (USD)");
		put("BSV.V", "Bitcoin SV (USD)");
		put("BTT.V", "BitTorrent (USD)");
		put("BTC.V", "Bitcoin (USD)");
		put("DOGE.V", "Dogecoin (USD)");
		put("DOT.V", "Polkadot (USD)");
		put("ETC.V", "Ethereum Classic (USD)");
		put("ETH.V", "Ethereum (USD)");
		put("ETH2.V", "Ethereum 2.0 (USD)");
		put("FET.V", "Fetch.ai (USD)");
		put("FIL.V", "Filecoin (USD)");
		put("FTT.V", "FTX Token (USD)");
		put("GRIN.V", "Grin (USD)");
		put("HBAR.V", "Hedera Hashgraph (USD)");
		put("HNS.V", "Handshake (USD)");
		put("HT.V", "Huobi Token (USD)");
		put("ICX.V", "Icon (USD)");
		put("INJ.V", "Injin (USD)");
		put("IOTA.V", "Iota (USD)");
		put("KAVA.V", "Kava (USD)");
		put("LINK.V", "Chainlink (USD)");
		put("LTC.V", "Litecoin (USD)");
		put("LUNA.V", "Terra (USD)");
		put("LUNA2.V", "Terra 2.0 (USD)");
		put("MATIC.V", "Matic Network (USD)");
		put("MATIC2", "Matic 2.0 (USD)");
		put("NEO.V", "NEO (USD)");
		put("OMG.V", "OmiseGO (USD)");
		put("QTUM.V", "Qtum (USD)");
		put("REN.V", "REN (USD)");
		put("ROSE.V", "Rose (USD)");
		put("SHIB.V", "Shiba (USD)");
		put("SOL.V", "Solana (USD");
		put("TRX.V", "TRON (USD)");
		put("UNI.V", "Uniswap (USD)");
		put("USDC.V", "USD Coin (USD)");
		put("USDT.V", "Tether USD (USD)");
		put("XLM.V", "Stellar (USD)");
		put("XMR.V", "Monero (USD)");
		put("XRP.V", "XRP (USD)");
		put("XTZ.V", "Tezos (USD)");
		put("ZEC.V", "Zcash (USD)");
		put("ZRX.V", "0x (USD)");

	}};
}
