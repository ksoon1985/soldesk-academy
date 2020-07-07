<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Summary</title>
</head>
<body>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=14fd3b068b8bf7e55df64e665bf5143e"></script>
<script>

// 맵 세팅 
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};

// 맵 생성   option을 토대로 -> container(div 요소) 
var map = new kakao.maps.Map(mapContainer, mapOption); 


// 지도 이동 
var moveLatLon = new kakao.maps.LatLng(33.452613, 126.570888);
map.setCenter(moveLatLon);
map.panTo(moveLatLon);// 가까운 거리라면 부드럽게 이동 

// 줌 
var level = map.getLevel();
map.setLevel(level - 1) // 확대
map.setLevel(level + 1) // 축소


// 지도,스카이뷰 컨트롤러 
var mapTypeControl = new kakao.maps.MapTypeControl();
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

map.setMapTypeId(kakao.maps.MapTypeId.ROADMAP); //지도뷰
map.setMapTypeId(kakao.maps.MapTypeId.HYBRID);  //스카이뷰
// 줌 컨트롤러 
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);


// 중심좌표
var center = map.getCenter();
center.getLat() // 위도
center.getLng() // 경도
// 지도타입을 얻어옵니다
var mapTypeId = map.getMapTypeId(); 
// 지도의 현재 영역을 얻어옵니다 
var bounds = map.getBounds();
var swLatLng = bounds.getSouthWest(); // 남서쪽 좌표
var neLatLng = bounds.getNorthEast(); // 북동쪽 좌표
// 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
var boundsStr = bounds.toString();


// 지도 드래그 이동 가능 여부 draggable = true or false
map.setDraggable(draggable);
// 지도 확대 축소 가능 여부  zoomable = t or f
map.setZoomable(zoomable);


// 교통정보 표시
map.addOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
// 교통정보 표시 제거
map.removeOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);


// 마커 생성과 , 마커의 위치에 맞는 지도의 위치 조정===============================
// 버튼을 클릭하면 아래 배열의 좌표들이 모두 보이게 지도 범위를 재설정합니다 
var points = [
    new kakao.maps.LatLng(33.452278, 126.567803),
    new kakao.maps.LatLng(33.452671, 126.574792),
    new kakao.maps.LatLng(33.451744, 126.572441)
];

// 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
var bounds = new kakao.maps.LatLngBounds();    

var i, marker;
for (i = 0; i < points.length; i++) {
    // 배열의 좌표들이 잘 보이게 마커를 지도에 추가합니다
    marker =     new kakao.maps.Marker({ position : points[i] });
    marker.setMap(map);
    
    // LatLngBounds 객체에 좌표를 추가합니다
    bounds.extend(points[i]);
}

function setBounds() {
    // LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
    // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
    map.setBounds(bounds);
}




</script>
</body>
</html>