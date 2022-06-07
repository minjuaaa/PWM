var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨 
    }; 

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
    
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function(position) {
        
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        
        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="padding:5px;">내 위치</div>'; // 인포윈도우에 표시될 내용입니다
        
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
        

            
      });
    
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    
    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
        message = 'geolocation을 사용할수 없어요..'
        
    displayMarker(locPosition, message);
}

// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, message) {

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    
    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        content : iwContent,
        removable : iwRemoveable
    });
    
    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}    


// 선을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 선을 표시합니다
var linePath = [
    new kakao.maps.LatLng(37.474010, 127.134422),
    new kakao.maps.LatLng(37.474431, 127.134460),
    new kakao.maps.LatLng(37.474261, 127.137147) 
];

// 지도에 표시할 선을 생성합니다
var polyline = new kakao.maps.Polyline({
    path: linePath, // 선을 구성하는 좌표배열 입니다
    strokeWeight: 5, // 선의 두께 입니다
    strokeColor: '#FFAE00', // 선의 색깔입니다
    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
    strokeStyle: 'solid' // 선의 스타일입니다
});

// 지도에 선을 표시합니다 
polyline.setMap(map);  



function getLocation() {
  if (navigator.geolocation) { // GPS를 지원하면
    navigator.geolocation.getCurrentPosition(function(position) {
      alert(position.coords.latitude + ' ' + position.coords.longitude);
    }, function(error) {
      console.error(error);
    }, {
      enableHighAccuracy: false,
      maximumAge: 0,
      timeout: Infinity
    });
    
    
    
  } else {
    alert('GPS를 지원하지 않습니다');
  }
}

getLocation();


if(!navigator.geolocation)
    alert("지원하지 않음");
else {
    var options = { // watchPosition()의 마지막 매개 변수로 전달
        enableHighAccuracy: false,
        timeout: 5000,
        maximumAge: 0 };
    var img = new Image();
    var count=0;
    var watchID;
 
    // changed() 콜백 함수를 등록하고, 반복 위치 서비스 시작
    watchID = navigator.geolocation.watchPosition(changed, null, options);
}
 
 

//위치가 바뀌면 changed()가 호출되고, 위치 정보가 들어 있는 position 객체가 매개 변수로 넘어온다.
function changed(position) {
    if(count == 5) { // clearWatch() 테스트를 위해 5번만 서비스
        navigator.geolocation.clearWatch(watchID); // 반복 서비스 종료
        document.getElementById("msg").innerHTML = "위치 서비스 종료";
        return;
    }
    var lat = position.coords.latitude; // 변경된 위도
    var lon = position.coords.longitude // 변경된 경도
    var text = count + ": (위도 " + lat + "°, 경도 " + lon + "°)로 변경됨<br>";
    var lat_txt = "위도:" + lat;
    document.getElementById("msg").innerHTML = text; // 위치 정보 출력
    document.getElementById("html_lat").innerHTML = lat_txt;
}

	
	
