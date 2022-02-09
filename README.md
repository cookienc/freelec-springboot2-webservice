# [스프링 부트와 AWS로 혼자 구현하는 웹 서비스](https://book.naver.com/bookdb/book_detail.nhn?bid=15871738)

> 책을 바탕으로 실습한 내용을 푸시한 레퍼지토리입니다.

<br/>

## 기술스택
SpringBoot + Mustache + H2 + Oauth2.0 + AWS EC2, RDS(Maria DB), CodeDeploy + Travis Ci + Nginx

<br/>

## 설명
- 간단한 CRUD 기능을 구현한 한페이지 페이지를 만드는 프로젝트 입니다.
  - Mustache을 이용하여 화면 구성을 하였습니다.(JS도 포함되어있으나 아직 학습이 부족합니다.)
- Oauth를 사용하여 네이버와 구글 로그인 기능을 구현하였고, 로그인을 한 사용자만 글을 쓰고 수정할 수 있도록 했습니다.
- 데이터베이스는 local에서 H2데이터베이스를 사용하고 추후에 AWS로 RDS로 옮겼습니다.
- Travis Ci를 이용하여 CI, AWS CodeDeploy를 사용해 CD를 학습하였습니다.
- Nginx(여기선, amazon-linux-extras의 nginx1)을 사용하여 무중단 배포를 사용해보았습니다.

<br/>

## 배운것
- Maria DB가 MYSQL보다 성능이 더 좋고, 문법도 호환이 되며 기타 좋은 이유들([MYSQL 에서 MARIADB 로 마이그레이션 해야할 10가지 이유](https://xdhyix.wordpress.com/2016/03/24/mysql-에서-mariadb-로-마이그레이션-해야할-10가지-이유/))을 가지고 있다.
- 개발할 때 로그의 중요성을 깨달았습니다.
  - [Oauth와 Springboot](https://kookiencream.tistory.com/57)에 기록

<br/>

## 사진
### 1. 초기 화면

<img width="1138" alt="스크린샷 2022-02-09 오후 11 29 28" src="https://user-images.githubusercontent.com/83010167/153221888-eb6fa2e4-ea1d-4039-8107-94ca43cbd3af.png">


### 2. 로그인을 한 화면

<img width="1213" alt="image" src="https://user-images.githubusercontent.com/83010167/153222173-9ed3862d-7f54-4d88-9118-fbc796ef1a98.png">


### 3. 게시글 등록 화면

<img width="507" alt="image" src="https://user-images.githubusercontent.com/83010167/153222335-383f8627-ae02-4290-9adb-500e97462e87.png">

<img width="955" alt="image" src="https://user-images.githubusercontent.com/83010167/153226178-cdccf061-a472-4b82-80f7-4e11c1e5ea09.png">

### 4. 게시글 수정 화면

<img width="504" alt="image" src="https://user-images.githubusercontent.com/83010167/153226282-09c9fa40-0ce7-471d-83bc-e0cc8c45c56f.png">
