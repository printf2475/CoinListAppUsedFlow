# CoinListAppUsedFlow

코루틴 강의를 수료후 앱을 구현하였으며

코인 가격과 관련 정보를 확인할수있는 앱을 구현하였습니다. <br> <br>


1. 코인 가격및 구매 가능 여부 페이지

  - 코인 가격및 이름 API와 구매가능여부 API를 FLOW를 사용하여 받아온 후 <br>
    2개의 스트림을 하나의 스트림으로 병합하여(ZIP 메서드 사용) 화면에 보여주도록 구현하였습니다. 
    
2. COIN 및 NFT 관련 뉴스 페이지

  - NAVER 뉴스 API를 사용하여 COIN 과 NFT의 검색 결과를 코루틴을 사용하여 병렬처리 후 <br>
    하나의 리스트로 병합하여 화면에 보여주도록 구현하였습니다.
    
    
 
    
    
 <br>   사용 기술
 - Clean Architecture
 - Coroutine
 - Flow
 - MVVM
 
 <br>
[COIN lIST USECASE]
<br><br>
<img src="https://user-images.githubusercontent.com/80373743/184586776-29b41ff3-46d3-4616-b445-c176b742e4ab.png" width="600" height="800"/>


<br>
[NEWS LIST USECASE]
<br><br>
<img src="https://user-images.githubusercontent.com/80373743/184586814-7722ff7b-219c-4240-b9a3-2eab72f505ea.png" width="600" height="400"/>

