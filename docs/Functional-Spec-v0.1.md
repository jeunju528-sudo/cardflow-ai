# CardFlow AI — Functional Spec v0.1

## 1. 프로젝트 개요
CardFlow AI는 대용량 카드 거래 로그(CSV)를 업로드하고,
Spring Batch로 DB에 적재한 뒤 REST API를 통해 조회/통계를 제공한다.
추가적으로 생성형 AI를 활용해 요약/개선 권고/리스크 리포트를 자동 생성한다.

#### 1) 구조: Spring Boot MVC + MyBatis
#### 2) 계층:
 - Controller → Service → Mapper → DB(MySQL)
#### 3) Batch: Spring Batch (CSV → DB 적재)
#### 4) API 문서화: Swagger(OpenAPI)
#### 5) 모니터링: Actuator + Micrometer + Prometheus + Grafana
#### 6) AI 연동: OpenAI API (REST 호출)


## 2. 기능 목록
### MVP
1) 대량 데이터 업로드
- CSV 파일 업로드 → DB 저장
- 데이터 유효성 검사(금액, 국가 코드, 통화 코드 등)
- 업로드 결과 리포트(성공/실패 건수, 오류 내역)

2) 거래 데이터 조회
- 기간/사용자/국가/채널별 검색
- 페이지네이션 지원
- 결과 다운로드(CSV)

3) AI 기반 자동 리포트
- 거래 데이터 기반 승인율·거절율, 국가별 통계 산출
- 주요 리스크 요인 분석
- 리포트 PDF/Markdown 다운로드

4) 시스템 모니터링
- Actuator + Prometheus + Grafana 대시보드 제공
- 배치 처리량, API 응답시간, 에러율 추적

### 사용자 유형
- 운영자: CSV 업로드 및 데이터 검증
- 분석가: 조건 기반 거래 데이터 조회
- 팀장/관리자: AI 자동 리포트 확인
- 운영팀: 시스템 모니터링

### 확장
- 이상 거래 탐지 (야간 고액, 특정 국가 급증)
- 관리자 권한 기능 (사용자 관리)
- 데이터 Export (CSV, Excel)
