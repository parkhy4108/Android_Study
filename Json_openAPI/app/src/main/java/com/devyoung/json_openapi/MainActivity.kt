package com.devyoung.json_openapi

import android.net.Network
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.w3c.dom.Element
import java.lang.Exception
import javax.xml.parsers.DocumentBuilderFactory

var text = ""


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = ""

        val key = "이곳에서는 자신의 인증키를 넣어서 사용"
        val pageNo = "&pageNo=1"
        val numOfRows = "&numOfRows=10"
        val MobileOS = "&MobileOS=AND"
        val MobileApp = "&MobileApp=AppTest"
        val url =
            "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList?serviceKey=$key$pageNo$numOfRows$MobileOS$MobileApp&_type_json"

        button.setOnClickListener {
            val thread = Thread(NetworkThread(url))
            thread.start()
            thread.join()
            textView.text = text
        }

    }

    class NetworkThread(var url: String) : Runnable {
        @RequiresApi(Build.VERSION_CODES.N)
        override fun run() {
            try {
                val xml : Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url)

                xml.documentElement.normalize()

                val list:NodeList = xml.getElementsByTagName("item")

                for (i in 0 until list.length){

                    val n:Node = list.item(i)

                    if(n.nodeType==Node.ELEMENT_NODE){

                        val elem = n as Element

                        val map = mutableMapOf<String,String>()

                        for(j in 0 until elem.attributes.length){

                            map.putIfAbsent(elem.attributes.item(j).nodeName,elem.attributes.item(j).nodeValue)
                        }

                        println("=========${i+1}=========")
                        text += "${i + 1}번 캠핑장 \n"

                        println("1. 주소 : ${elem.getElementsByTagName("addr1").item(0).textContent}")
                        text += "1. 주소 : ${elem.getElementsByTagName("addr1").item(0).textContent} \n"

                        println("2. 캠핑장 이름 : ${elem.getElementsByTagName("facltNm").item(0).textContent}")
                        text += "2. 캠핑장 이름 : ${elem.getElementsByTagName("facltNm").item(0).textContent} \n"

                        println("3. 위도 : ${elem.getElementsByTagName("mapX").item(0).textContent}")
                        text += "3. 위도 : ${elem.getElementsByTagName("mapX").item(0).textContent} \n"

                        println("4. 경도 : ${elem.getElementsByTagName("mapY").item(0).textContent}")
                        text += "4. 경도 : ${elem.getElementsByTagName("mapY").item(0).textContent} \n"

                        println("5. 업종 : ${elem.getElementsByTagName("induty").item(0).textContent}")
                        text += "5. 업종 : ${elem.getElementsByTagName("induty").item(0).textContent} \n"
                    }
                }
            } catch (e:Exception){
                Log.d("TTT", "오픈API$e")
            }
        }
    }


}