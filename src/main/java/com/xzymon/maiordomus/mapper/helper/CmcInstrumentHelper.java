package com.xzymon.maiordomus.mapper.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CmcInstrumentHelper {
	public static Map<String, CmcInstrumentDetails> VALOR_NAME_TO_INSTRUMENT_MAP = new HashMap<>() {{
		put("Rachunek", new CmcInstrumentDetails("Rachunek", "Rachunek", List.of("rachunek")));
		put("PL", new CmcInstrumentDetails("PL", "Akcja polska Notowania", List.of("akcja pl")));
		put("USA", new CmcInstrumentDetails("USA", "Akcja USA Notowania", List.of("akcja usa")));

		put("AUDCAD", new CmcInstrumentDetails("AUDCAD", "AUD/CAD", List.of("AUD", "CAD")));
		put("AUDCHF", new CmcInstrumentDetails("AUDCHF", "AUD/CHF", List.of("AUD", "CHF")));
		put("AUDCNY", new CmcInstrumentDetails("AUDCNY", "AUD/CNY", List.of("AUD", "CNY")));
		put("AUDGBP", new CmcInstrumentDetails("AUDGBP", "AUD/GBP", List.of("AUD", "GBP")));
		put("AUDHKD", new CmcInstrumentDetails("AUDHKD", "AUD/HKD", List.of("AUD", "HKD")));
		put("AUDJPY", new CmcInstrumentDetails("AUDJPY", "AUD/JPY", List.of("AUD", "JPY")));
		put("AUDNOK", new CmcInstrumentDetails("AUDNOK", "AUD/NOK", List.of("AUD", "NOK")));
		put("AUDNZD", new CmcInstrumentDetails("AUDNZD", "AUD/NZD", List.of("AUD", "NZD")));
		put("AUDPLN", new CmcInstrumentDetails("AUDPLN", "AUD/PLN", List.of("AUD", "PLN")));
		put("AUDSGD", new CmcInstrumentDetails("AUDSGD", "AUD/SGD", List.of("AUD", "SGD")));
		put("AUDTRY", new CmcInstrumentDetails("AUDTRY", "AUD/TRY", List.of("AUD", "TRY")));
		put("AUDUSD", new CmcInstrumentDetails("AUDUSD", "AUD/USD", List.of("AUD", "USD")));

		put("CADHKD", new CmcInstrumentDetails("CADHKD", "CAD/HKD", List.of("CAD", "HKD")));
		put("CADJPY", new CmcInstrumentDetails("CADJPY", "CAD/JPY", List.of("CAD", "JPY")));
		put("CADNOK", new CmcInstrumentDetails("CADNOK", "CAD/NOK", List.of("CAD", "NOK")));
		put("CADNZD", new CmcInstrumentDetails("CADNZD", "CAD/NZD", List.of("CAD", "NZD")));
		put("CADSGD", new CmcInstrumentDetails("CADSGD", "CAD/SGD", List.of("CAD", "SGD")));
		put("CADTRY", new CmcInstrumentDetails("CADTRY", "CAD/TRY", List.of("CAD", "TRY")));
		put("CADUSD", new CmcInstrumentDetails("CADUSD", "CAD/USD", List.of("CAD", "USD")));

		put("CHFARS", new CmcInstrumentDetails("CHFARS", "CHF/ARS", List.of("CHF", "ARS")));
		put("CHFAUD", new CmcInstrumentDetails("CHFAUD", "CHF/AUD", List.of("CHF", "AUD")));
		put("CHFCAD", new CmcInstrumentDetails("CHFCAD", "CHF/CAD", List.of("CHF", "CAD")));
		put("CHFCNY", new CmcInstrumentDetails("CHFCNY", "CHF/CNY", List.of("CHF", "CNY")));
		put("CHFDKK", new CmcInstrumentDetails("CHFDKK", "CHF/DKK", List.of("CHF", "DKK")));
		put("CHFEUR", new CmcInstrumentDetails("CHFEUR", "CHF/EUR", List.of("CHF", "EUR")));
		put("CHFGBP", new CmcInstrumentDetails("CHFGBP", "CHF/GBP", List.of("CHF", "GBP")));
		put("CHFHKD", new CmcInstrumentDetails("CHFHKD", "CHF/HKD", List.of("CHF", "HKD")));
		put("CHFILS", new CmcInstrumentDetails("CHFILS", "CHF/ILS", List.of("CHF", "ILS")));
		put("CHFINR", new CmcInstrumentDetails("CHFINR", "CHF/INR", List.of("CHF", "INR")));
		put("CHFJPY", new CmcInstrumentDetails("CHFJPY", "CHF/JPY", List.of("CHF", "JPY")));
		put("CHFMXN", new CmcInstrumentDetails("CHFMXN", "CHF/MXN", List.of("CHF", "MXN")));
		put("CHFNOK", new CmcInstrumentDetails("CHFNOK", "CHF/NOK", List.of("CHF", "NOK")));
		put("CHFNZD", new CmcInstrumentDetails("CHFNZD", "CHF/NZD", List.of("CHF", "NZD")));
		put("CHFPLN", new CmcInstrumentDetails("CHFPLN", "CHF/PLN", List.of("CHF", "PLN")));
		put("CHFSGD", new CmcInstrumentDetails("CHFSGD", "CHF/SGD", List.of("CHF", "SGD")));
		put("CHFTRY", new CmcInstrumentDetails("CHFTRY", "CHF/TRY", List.of("CHF", "TRY")));
		put("CHFUSD", new CmcInstrumentDetails("CHFUSD", "CHF/USD", List.of("CHF", "USD")));

		put("EURAUD", new CmcInstrumentDetails("EURAUD", "EUR/AUD", List.of("EUR", "AUD")));
		put("EURCAD", new CmcInstrumentDetails("EURCAD", "EUR/CAD", List.of("EUR", "CAD")));
		put("EURCHF", new CmcInstrumentDetails("EURCHF", "EUR/CHF", List.of("EUR", "CHF")));
		put("EURGBP", new CmcInstrumentDetails("EURGBP", "EUR/GBP", List.of("EUR", "GBP")));
		put("EURHKD", new CmcInstrumentDetails("EURHKD", "EUR/HKD", List.of("EUR", "HKD")));
		put("EURJPY", new CmcInstrumentDetails("EURJPY", "EUR/JPY", List.of("EUR", "JPY")));
		put("EURNOK", new CmcInstrumentDetails("EURNOK", "EUR/NOK", List.of("EUR", "NOK")));
		put("EURNZD", new CmcInstrumentDetails("EURNZD", "EUR/NZD", List.of("EUR", "NZD")));
		put("EURPLN", new CmcInstrumentDetails("EURPLN", "EUR/PLN", List.of("EUR", "PLN")));
		put("EURSGD", new CmcInstrumentDetails("EURSGD", "EUR/SGD", List.of("EUR", "SGD")));
		put("EURUSD", new CmcInstrumentDetails("EURUSD", "EUR/USD", List.of("EUR", "USD")));
		put("EURTRY", new CmcInstrumentDetails("EURTRY", "EUR/TRY", List.of("EUR", "TRY")));

		put("GBPAUD", new CmcInstrumentDetails("GBPAUD", "GBP/AUD", List.of("GBP", "AUD")));
		put("GBPCAD", new CmcInstrumentDetails("GBPCAD", "GBP/CAD", List.of("GBP", "CAD")));
		put("GBPCHF", new CmcInstrumentDetails("GBPCHF", "GBP/CHF", List.of("GBP", "CHF")));
		put("GBPCNY", new CmcInstrumentDetails("GBPCNY", "GBP/CNY", List.of("GBP", "CNY")));
		put("GBPDKK", new CmcInstrumentDetails("GBPDKK", "GBP/DKK", List.of("GBP", "DKK")));
		put("GBPEUR", new CmcInstrumentDetails("GBPEUR", "GBP/EUR", List.of("GBP", "EUR")));
		put("GBPHKD", new CmcInstrumentDetails("GBPHKD", "GBP/HKD", List.of("GBP", "HKD")));
		put("GBPILS", new CmcInstrumentDetails("GBPILS", "GBP/ILS", List.of("GBP", "ILS")));
		put("GBPINR", new CmcInstrumentDetails("GBPINR", "GBP/INR", List.of("GBP", "INR")));
		put("GBPJPY", new CmcInstrumentDetails("GBPJPY", "GBP/JPY", List.of("GBP", "JPY")));
		put("GBPNOK", new CmcInstrumentDetails("GBPNOK", "GBP/NOK", List.of("GBP", "NOK")));
		put("GBPNZD", new CmcInstrumentDetails("GBPNZD", "GBP/NZD", List.of("GBP", "NZD")));
		put("GBPPLN", new CmcInstrumentDetails("GBPPLN", "GBP/PLN", List.of("GBP", "PLN")));
		put("GBPRUB", new CmcInstrumentDetails("GBPRUB", "GBP/RUB", List.of("GBP", "RUB")));
		put("GBPSEK", new CmcInstrumentDetails("GBPSEK", "GBP/SEK", List.of("GBP", "SEK")));
		put("GBPSGD", new CmcInstrumentDetails("GBPSGD", "GBP/SGD", List.of("GBP", "SGD")));
		put("GBPTRY", new CmcInstrumentDetails("GBPTRY", "GBP/TRY", List.of("GBP", "TRY")));
		put("GBPUSD", new CmcInstrumentDetails("GBPUSD", "GBP/USD", List.of("GBP", "USD")));
		put("GBPZAR", new CmcInstrumentDetails("GBPZAR", "GBP/ZAR", List.of("GBP", "ZAR")));

		put("HKDJPY", new CmcInstrumentDetails("HKDJPY", "HKD/JPY", List.of("HKD", "JPY")));

		put("JPYAUD", new CmcInstrumentDetails("JPYAUD", "JPY/AUD", List.of("JPY", "AUD")));
		put("JPYCAD", new CmcInstrumentDetails("JPYCAD", "JPY/CAD", List.of("JPY", "CAD")));
		put("JPYCHF", new CmcInstrumentDetails("JPYCHF", "JPY/CHF", List.of("JPY", "CHF")));
		put("JPYCNY", new CmcInstrumentDetails("JPYCNY", "JPY/CNY", List.of("JPY", "CNY")));
		put("JPYDKK", new CmcInstrumentDetails("JPYDKK", "JPY/DKK", List.of("JPY", "DKK")));
		put("JPYEUR", new CmcInstrumentDetails("JPYEUR", "JPY/EUR", List.of("JPY", "EUR")));
		put("JPYGBP", new CmcInstrumentDetails("JPYGBP", "JPY/GBP", List.of("JPY", "GBP")));
		put("JPYHKD", new CmcInstrumentDetails("JPYHKD", "JPY/HKD", List.of("JPY", "HKD")));
		put("JPYNOK", new CmcInstrumentDetails("JPYNOK", "JPY/NOK", List.of("JPY", "NOK")));
		put("JPYNZD", new CmcInstrumentDetails("JPYNZD", "JPY/NZD", List.of("JPY", "NZD")));
		put("JPYPLN", new CmcInstrumentDetails("JPYPLN", "JPY/PLN", List.of("JPY", "PLN")));
		put("JPYRUB", new CmcInstrumentDetails("JPYRUB", "JPY/RUB", List.of("JPY", "RUB")));
		put("JPYSEK", new CmcInstrumentDetails("JPYSEK", "JPY/SEK", List.of("JPY", "SEK")));
		put("JPYSGD", new CmcInstrumentDetails("JPYSGD", "JPY/SGD", List.of("JPY", "SGD")));
		put("JPYTRY", new CmcInstrumentDetails("JPYTRY", "JPY/TRY", List.of("JPY", "TRY")));
		put("JPYUSD", new CmcInstrumentDetails("JPYUSD", "JPY/USD", List.of("JPY", "USD")));
		put("JPYZAR", new CmcInstrumentDetails("JPYZAR", "JPY/ZAR", List.of("JPY", "ZAR")));

		put("NZDAUD", new CmcInstrumentDetails("NZDAUD", "NZD/AUD", List.of("NZD", "AUD")));
		put("NZDCHF", new CmcInstrumentDetails("NZDCHF", "NZD/CHF", List.of("NZD", "CHF")));
		put("NZDJPY", new CmcInstrumentDetails("NZDJPY", "NZD/JPY", List.of("NZD", "JPY")));
		put("NZDNOK", new CmcInstrumentDetails("NZDNOK", "NZD/NOK", List.of("NZD", "NOK")));
		put("NZDPLN", new CmcInstrumentDetails("NZDPLN", "NZD/PLN", List.of("NZD", "PLN")));
		put("NZDSGD", new CmcInstrumentDetails("NZDSGD", "NZD/SGD", List.of("NZD", "SGD")));
		put("NZDUSD", new CmcInstrumentDetails("NZDUSD", "NZD/USD", List.of("NZD", "USD")));

		put("PLNCHF", new CmcInstrumentDetails("PLNCHF", "PLN/CHF", List.of("PLN", "CHF")));
		put("PLNEUR", new CmcInstrumentDetails("PLNEUR", "PLN/EUR", List.of("PLN", "EUR")));
		put("PLNGBP", new CmcInstrumentDetails("PLNGBP", "PLN/GBP", List.of("PLN", "GBP")));
		put("PLNJPY", new CmcInstrumentDetails("PLNJPY", "PLN/JPY", List.of("PLN", "JPY")));
		put("PLNUSD", new CmcInstrumentDetails("PLNUSD", "PLN/USD", List.of("PLN", "USD")));

		put("SGDJPY", new CmcInstrumentDetails("SGDJPY", "SGD/JPY", List.of("SGD", "JPY")));

		put("USDARS", new CmcInstrumentDetails("USDARS", "USD/ARS", List.of("USD", "ARS")));
		put("USDAUD", new CmcInstrumentDetails("USDAUD", "USD/AUD", List.of("USD", "AUD")));
		put("USDBRL", new CmcInstrumentDetails("USDBRL", "USD/BRL", List.of("USD", "BRL")));
		put("USDCAD", new CmcInstrumentDetails("USDCAD", "USD/CAD", List.of("USD", "CAD")));
		put("USDCHF", new CmcInstrumentDetails("USDCHF", "USD/CHF", List.of("USD", "CHF")));
		put("USDCNY", new CmcInstrumentDetails("USDCNY", "USD/CNY", List.of("USD", "CNY")));
		put("USDDKK", new CmcInstrumentDetails("USDDKK", "USD/DKK", List.of("USD", "DKK")));
		put("USDEUR", new CmcInstrumentDetails("USDEUR", "USD/EUR", List.of("USD", "EUR")));
		put("USDGBP", new CmcInstrumentDetails("USDGBP", "USD/GBP", List.of("USD", "GBP")));
		put("USDILS", new CmcInstrumentDetails("USDILS", "USD/ILS", List.of("USD", "ILS")));
		put("USDINR", new CmcInstrumentDetails("USDINR", "USD/INR", List.of("USD", "INR")));
		put("USDJPY", new CmcInstrumentDetails("USDJPY", "USD/JPY", List.of("USD", "JPY")));
		put("USDMXN", new CmcInstrumentDetails("USDMXN", "USD/MXN", List.of("USD", "MXN")));
		put("USDNOK", new CmcInstrumentDetails("USDNOK", "USD/NOK", List.of("USD", "NOK")));
		put("USDNZD", new CmcInstrumentDetails("USDNZD", "USD/NZD", List.of("USD", "NZD")));
		put("USDPLN", new CmcInstrumentDetails("USDPLN", "USD/PLN", List.of("USD", "PLN")));
		put("USDRUB", new CmcInstrumentDetails("USDRUB", "USD/RUB", List.of("USD", "RUB")));
		put("USDSEK", new CmcInstrumentDetails("USDSEK", "USD/SEK", List.of("USD", "SEK")));
		put("USDSGD", new CmcInstrumentDetails("USDSGD", "USD/SGD", List.of("USD", "SGD")));
		put("USDTRY", new CmcInstrumentDetails("USDTRY", "USD/TRY", List.of("USD", "TRY")));
		put("USDZAR", new CmcInstrumentDetails("USDZAR", "USD/ZAR", List.of("USD", "ZAR")));


		put("ADA.V", new CmcInstrumentDetails("ADA.V", "Cardano (USD)", List.of("USD")));
		put("ADA2.V", new CmcInstrumentDetails("ADA2.V", "Cardano 2.0 (USD)", List.of("USD")));
		put("ALGO.V", new CmcInstrumentDetails("ALGO.V", "Algorand (USD)", List.of("USD")));
		put("ATOM.V", new CmcInstrumentDetails("ATOM.V", "Cosmos (USD)", List.of("USD")));
		put("AVAX.V", new CmcInstrumentDetails("AVAX.V", "Avalanche (USD)", List.of("USD")));
		put("BCH.V", new CmcInstrumentDetails("BCH.V", "Bitcoin Cash (USD)", List.of("USD")));
		put("BNB.V", new CmcInstrumentDetails("BNB.V", "Binance Coin (USD)", List.of("USD")));
		put("BSV.V", new CmcInstrumentDetails("BSV.V", "Bitcoin SV (USD)", List.of("USD")));
		put("BTT.V", new CmcInstrumentDetails("BTT.V", "BitTorrent (USD)", List.of("USD")));
		put("BTC.V", new CmcInstrumentDetails("BTC.V", "Bitcoin (USD)", List.of("USD")));
		put("DASH.V", new CmcInstrumentDetails("DASH.V", "Dash (USD)", List.of("USD")));
		put("DOGE.V", new CmcInstrumentDetails("DOGE.V", "Dogecoin (USD)", List.of("USD")));
		put("DOT.V", new CmcInstrumentDetails("DOT.V", "Polkadot (USD)", List.of("USD")));
		put("ETC.V", new CmcInstrumentDetails("ETC.V", "Ethereum Classic (USD)", List.of("USD")));
		put("ETH.V", new CmcInstrumentDetails("ETH.V", "Ethereum (USD)", List.of("USD")));
		put("ETH2.V", new CmcInstrumentDetails("ETH2.V", "Ethereum 2.0 (USD)", List.of("USD")));
		put("FET.V", new CmcInstrumentDetails("FET.V", "Fetch.ai (USD)", List.of("USD")));
		put("FIL.V", new CmcInstrumentDetails("FIL.V", "Filecoin (USD)", List.of("USD")));
		put("FTT.V", new CmcInstrumentDetails("FTT.V", "FTX Token (USD)", List.of("USD")));
		put("GRIN.V", new CmcInstrumentDetails("GRIN.V", "Grin (USD)", List.of("USD")));
		put("HBAR.V", new CmcInstrumentDetails("HBAR.V", "Hedera Hashgraph (USD)", List.of("USD")));
		put("HNS.V", new CmcInstrumentDetails("HNS.V", "Handshake (USD)", List.of("USD")));
		put("HT.V", new CmcInstrumentDetails("HT.V", "Huobi Token (USD)", List.of("USD")));
		put("ICX.V", new CmcInstrumentDetails("ICX.V", "Icon (USD)", List.of("USD")));
		put("INJ.V", new CmcInstrumentDetails("INJ.V", "Injin (USD)", List.of("USD")));
		put("IOTA.V", new CmcInstrumentDetails("IOTA.V", "Iota (USD)", List.of("USD")));
		put("KAVA.V", new CmcInstrumentDetails("KAVA.V", "Kava (USD)", List.of("USD")));
		put("LINK.V", new CmcInstrumentDetails("LINK.V", "Chainlink (USD)", List.of("USD")));
		put("LTC.V", new CmcInstrumentDetails("LTC.V", "Litecoin (USD)", List.of("USD")));
		put("LUNA.V", new CmcInstrumentDetails("LUNA.V", "Terra (USD)", List.of("USD")));
		put("LUNA2.V", new CmcInstrumentDetails("LUNA2.V", "Terra 2.0 (USD)", List.of("USD")));
		put("MATIC.V", new CmcInstrumentDetails("MATIC.V", "Matic Network (USD)", List.of("USD")));
		put("MATIC2.V", new CmcInstrumentDetails("MATIC2.V", "Matic 2.0 (USD)", List.of("USD")));
		put("NEO.V", new CmcInstrumentDetails("NEO.V", "NEO (USD)", List.of("USD")));
		put("OMG.V", new CmcInstrumentDetails("OMG.V", "OmiseGO (USD)", List.of("USD")));
		put("QTUM.V", new CmcInstrumentDetails("QTUM.V", "Qtum (USD)", List.of("USD")));
		put("REN.V", new CmcInstrumentDetails("REN.V", "REN (USD)", List.of("USD")));
		put("ROSE.V", new CmcInstrumentDetails("ROSE.V", "Rose (USD)", List.of("USD")));
		put("SHIB.V", new CmcInstrumentDetails("SHIB.V", "Shiba (USD)", List.of("USD")));
		put("SOL.V", new CmcInstrumentDetails("SOL.V", "Solana (USD", List.of("USD")));
		put("TRX.V", new CmcInstrumentDetails("TRX.V", "TRON (USD)", List.of("USD")));
		put("UNI.V", new CmcInstrumentDetails("UNI.V", "Uniswap (USD)", List.of("USD")));
		put("USDC.V", new CmcInstrumentDetails("USDC.V", "USD Coin (USD)", List.of("USD")));
		put("USDT.V", new CmcInstrumentDetails("USDT.V", "Tether USD (USD)", List.of("USD")));
		put("XLM.V", new CmcInstrumentDetails("XLM.V", "Stellar (USD)", List.of("USD")));
		put("XMR.V", new CmcInstrumentDetails("XMR.V", "Monero (USD)", List.of("USD")));
		put("XRP.V", new CmcInstrumentDetails("XRP.V", "XRP (USD)", List.of("USD")));
		put("XTZ.V", new CmcInstrumentDetails("XTZ.V", "Tezos (USD)", List.of("USD")));
		put("ZEC.V", new CmcInstrumentDetails("ZEC.V", "Zcash (USD)", List.of("USD")));
		put("ZRX.V", new CmcInstrumentDetails("ZRX.V", "0x (USD)", List.of("USD")));

	}};
}
