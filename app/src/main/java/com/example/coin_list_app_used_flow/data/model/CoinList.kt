package com.example.coin_list_app_used_flow.data.model

import android.util.Log
import com.example.coin_list_app_used_flow.domain.model.CoinData
import com.google.gson.Gson
import org.json.JSONObject


data class CoinList(
    val `data`: HashMap<String, Any>,
    val status: String
) {
    fun toCoinDataList(): List<CoinData> {
        val list = mutableListOf<CoinData>()
        data.forEach { (coinName, any) ->
            if (coinName != "date") {
                val coinInfo = JSONObject(Gson().toJson(any))
                val closingPrice = coinInfo.get("closing_price").toString()
                val unitsTraded = coinInfo.get("units_traded").toString()
                val coinData = CoinData(coinName, closingPrice, unitsTraded)
                list.add(coinData)
            }
        }
        return list
    }
}



/*
{
  "status": "0000",
  "data": {
      `"GMT": {
          "opening_price": "1241",
          "closing_price": "1223",
          "min_price": "1214",
          "max_price": "1247",
          "units_traded": "134153.57375082",
          "acc_trade_value": "164964047.2977",
          "prev_closing_price": "1243",
          "units_traded_24H": "167388.74499314",
          "acc_trade_value_24H": "206294045.6053",
          "fluctate_24H": "-22",
          "fluctate_rate_24H": "-1.77"
        },

        "TAVA": {
          "opening_price": "1830",
          "closing_price": "1779",
          "min_price": "1753",
          "max_price": "1837",
          "units_traded": "435725.06653455",
          "acc_trade_value": "783324092.2456",
          "prev_closing_price": "1830",
          "units_traded_24H": "483421.721981",
          "acc_trade_value_24H": "870724421.3966",
          "fluctate_24H": "-56",
          "fluctate_rate_24H": "-3.05"
        },
        "date": "1659866049821"`
  }
}
* */
