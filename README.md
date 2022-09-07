# SSG.COM 클론코딩

## 📍 프로젝트 소개

> 본 프로젝트는 스파로스 아카데미 1기에서 진행한 **SSG.COM 신세계몰 클론 코딩 프로젝트**입니다.

- **쓱싹쓱싹(5조)의 프론트엔드 저장소**입니다.

### Project Repositories

- [프론트엔드](https://github.com/Im-hass/SSG_SSAG_FE)
- [백엔드](https://github.com/K-J-HYEON/SSG_SSAG_BE)
- [Demo](https://shinsegae-mall.shop/)

&nbsp;

## 📍 개발환경

```bash
> OS : Windows 10, Mac OS, Ubuntu 20.04.4 LTS
> Infra : AWS EC2, Nginx
> DB : AWS RDS(MySQL 8.0.28)
> Storage : AWS S3
> Backend : Spring Boot 2.6.10, Gradle(빌드), JPA(DB접근)
> Api : Naver SMS API, Naver Login API, KaKao Login API
```

### 설치 및 실행

1. `.env.sample` 파일 `.env`로 수정

2. `.env` 파일의 `REACT_APP_ZIPCODE_SERVICE_KEY2`, `REACT_APP_ZIPCODE_SERVICE_URL2` 수정  
   [주소기반산업지원서비스의 도로명주소 검색 API](https://www.juso.go.kr/addrlink/openApi/searchApi.do) 사용 중

3. 설치 및 실행
   ```bash
   $ npm install
   $ npm run start
   ```

&nbsp;

## 📍 사용 기술

### Frontend

<img src="https://img.shields.io/badge/Vscode-23a9f2?style=flat-square&logo=visual studio code&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/React-17b6e7?style=flat-square&logo=React&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/recoil-17b6e7?style=flat-square&logo=recoil&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/SASS-CC6699?style=flat-square&logo=SASS&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/ESLint-4B32C3?style=flat-square&logo=ESLint&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/Prettier-F7B93E?style=flat-square&logo=Prettier&logoColor=white"/></a>&nbsp;

### Backend

<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=Gradle&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/JPA-0D86C1?style=flat-square&logo=JPA&logoColor=white"/></a>&nbsp;

### Deploy

<img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=flat-square&logo=Amazon EC2&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/NGINX-009639?style=flat-square&logo=NGINX&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/Amazon RDS-527FFF?style=flat-square&logo=Amazon RDS&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/Amazon S3-569A31?style=flat-square&logo=Amazon S3&logoColor=white"/></a>&nbsp;

### Tools

<img src="https://img.shields.io/badge/Jira-0052CC?style=flat-square&logo=Jira&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/Github-000000?style=flat-square&logo=Github&logoColor=white"/></a>&nbsp;
<img src="https://img.shields.io/badge/Notion-fafafa?style=flat-square&logo=Notion&logoColor=black"/></a>&nbsp;

&nbsp;

## 📍 디렉터리 구조

```bash
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─ssg
    │  │          ├─config # config, security, exception, etc.. 관리
    │  │          ├─ssg_be
    │  │          │  ├─cart
    │  │          │  │  ├─application # Service 폴더
    │  │          │  │  ├─domain # 해당 도메인의 entity 폴더
    │  │          │  │  ├─dto # DTO 폴더
    │  │          │  │  ├─infrastructure # Repository 폴더
    │  │          │  │  └─presentation # Controller 폴더
    │  │          │  └─ ... # 나머지 도메인
    │  │          └─utils
    │  │              ├─jwt
    │  │              ├─oauth
    │  │              └─s3
    │  └─resources # application.yml 관리
    └─test
```
