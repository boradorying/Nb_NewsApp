# 프로젝트 제목

**간단한 뉴스앱**

## 프로젝트 설명 및 목적


- 프래그먼트를 이용해 화면을 띄울 수 있습니다
- 가로모드를 이용해서 title,article fragment를 동시에 띄을 수 있습니다
- bundle을 이용해서 정보를 전달할 수 있습니다.



## 구체적인 설명

### 1. Main에서 title과 article fragment를 두가지 호스팅하기

![0831101225345526](https://github.com/boradorying/Nb_NewsApp/assets/136980408/98f7b3b3-68bb-4b72-86fb-a1b6dd237c85)



- main에서 처음 화면은 titlefragment 띄워줍니다 
- support.commit등 프래그먼트 사용할 수 있는 메서드를 사용해서 메인에 리싸이클러뷰위젯을 가지고 있는 titlefragment를 띄워줍니다.

### 2. 가로모드

![0831204532703601](https://github.com/boradorying/Nb_NewsApp/assets/136980408/fa301874-7c57-4e6a-9aa1-cdd344e790a5)



- resources.configruation.orientation ==Configuration.ORIENTATION_LANDSCAPE를 이용함
- 가로로 했을 때 타이틀을 클릭! 했을 때 옆에 articleFragment를 띄워야하니까 titlefragment에 onclick에도 구현해준다










## 구현 동영상

프로젝트의 구현 내용을 시연하는 동영상을 아래 링크에서 확인하실 수 있습니다:
[프로젝트 시연 동영상](https://boradoritech-ai.tistory.com/49)

## 사용 기술 및 라이브러리

- **Android Kotlin**: 안드로이드 앱 개발에 사용되는 주요 프로그래밍 언어입니다.
- **RecyclerView**: 아이템 목록을 표시하기 위해 사용되며 효율적인 아이템 관리를 지원합니다.
- ## 사용 기술 및 라이브러리

- **Android Kotlin**: 안드로이드 앱 개발에 사용되는 주요 프로그래밍 언어입니다.
- **RecyclerView**: 아이템 목록을 표시하기 위해 사용되며 효율적인 아이템 관리를 지원합니다.
- **Fragment**: 앱의 화면을 모듈화하고 다양한 화면 요소를 구성하는 데 사용됩니다.
- **가로모드(land)**: 가로 방향의 디바이스 화면을 지원하여 타이틀과 아티클 프래그먼트를 동시에 표시합니다.


