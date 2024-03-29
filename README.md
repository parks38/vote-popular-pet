## 강아지 인기 투표
----

### 📌 프로젝트 개요


### 📌 프로젝트 목표
- 대규모 트래픽을 안정적으로 처리하기 위해 자주 활용되는 비동기 이벤트 처리 아키텍처 구현
- rabbitMQ 통한 비동기 이벤트 처리 구현
- Redis를 이용하여 Cache 구현 
- CQRS 패턴을 적용하여 변경과 조회 책임의 분리한 아키텍쳐

#### 💻 개발 환경
Java, Spring-Boot, RabbitMQ, Redis, MySQL

#### 📌 시스템 아키텍쳐

![시스템 아키텍쳐](/src/main/resources/PROJECT-1691631348038.jpeg)

### 📌 프로젝트 중점 사항

- 버전 관리
- 서버의 확장성
- 의존적이지 않은 코드 작성

### 📌 핵심 기능
- 강아지 목록을 조회하는 API
- 강아지 상세 정보 API
- 투표하기/ 투표취소 API
- 투표 처리 백엔드

### 📁 프로젝트 ISSUE

### ⛓️ Github PR 방식

#### ✔️ 브랜치 전략

- Main : 배포했거나 곧 배포할 코드 관리합니다.
- Feature : 기능 개발을 진행할 때 사용합니다. 기능을 완성할 때까지 유지하고 완성 시 Main 브랜치로 merge 합니다.
- Release : 배포를 준비하는 브랜치로 배포를 필요한 메타데이터를 준비합니다.
- Hotfix :  배포한 버전에서 발생한 버그를 수정하는 브랜치입니다.

#### Redis 동작 방법 
> redis cli.exe 